// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.*;

import java.lang.management.OperatingSystemMXBean;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;
import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.RobotModeTriggers;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.robot.Commands.AimAndShoot;
import frc.robot.Commands.CloseMouth;
import frc.robot.Commands.OpenMouth;
import frc.robot.Commands.Shoot;
import frc.robot.Commands.ShootAt50Percent;
import frc.robot.Commands.ShootAt75Percent;
import frc.robot.Commands.ShootAtMaxPower;
import frc.robot.Commands.StopIntake;
import frc.robot.Commands.SuckingBalls;
import frc.robot.Commands.reverseIntake;
import frc.robot.Commands.ReverseShooter;
// import frc.robot.Commands.Digest;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Vision;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StringPublisher;
import com.pathplanner.lib.auto.NamedCommands;
import frc.robot.Commands.testIntake;
import frc.robot.Commands.reverseIntake;
import frc.robot.Commands.ShootAt50Percent;
import frc.robot.Commands.ShootAtMaxPower;
import frc.robot.Commands.ShootAt75Percent;



public class RobotContainer {
    //Default MaxSpeed = 1.0, jack made 0.2 for testing
    private double MaxSpeed = 0.2 * TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
    private double MaxAngularRate = RotationsPerSecond.of(0.77).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

    /* Setting up bindings for necessary control of the swerve drive platform */
    private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
            .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors
    private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
    private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();
    

    private final Telemetry logger = new Telemetry(MaxSpeed);

    private final Intake intake = new Intake();
    private final Feeder feeder = new Feeder();
    private final Loader loader = new Loader();
    private final Vision limeLight = new Vision(drive);
    private final Shooter shooter = new Shooter(limeLight);

    private final CommandXboxController joystick = new CommandXboxController(0);
    private final CommandGenericHID operator = new CommandGenericHID(1);

    private final CommandSwerveDrivetrain drivetrain = TunerConstants.createDrivetrain();

    public final Command suckingBalls = new SuckingBalls(intake);
    public final Command stopIntake = new StopIntake(intake);
    public final Command openMouth = new OpenMouth(intake);
    public final Command closeMouth = new CloseMouth(intake);
    private final Shoot shoot = new Shoot(shooter, loader, feeder);
    private final Command aimAndShoot = new AimAndShoot(limeLight, shooter, loader, feeder);

    // private final Command digest = new Digest(feeder);
    private final Command reverseShooter = new ReverseShooter(shooter, loader, feeder);
    private final Command testIntake = new testIntake(intake);
    private final Command reverseIntake = new reverseIntake(intake);
    private final Command shootAt50Percent = new ShootAt50Percent(shooter, loader, feeder);
    private final Command shootMaxPower = new ShootAtMaxPower(shooter, loader, feeder);
    private final Command shootAt75Percent = new ShootAt75Percent(shooter, loader, feeder);

    private final SendableChooser<Command> autoChooser;
    


    public RobotContainer() {
        NamedCommands.registerCommand("SuckingBalls", suckingBalls.withTimeout(3));
        NamedCommands.registerCommand("StopIntake", stopIntake);
        NamedCommands.registerCommand("Open", openMouth);
        NamedCommands.registerCommand("Close", closeMouth);
        NamedCommands.registerCommand("Shoot", shoot.withTimeout(1));
        NamedCommands.registerCommand("TEST", Commands.print("HELP MEEEEE FAWKKKKKK"));

        autoChooser = AutoBuilder.buildAutoChooser("Tests");
        SmartDashboard.putData("Auto Mode", autoChooser);
        configureBindings();
        robotModelPublisher.set("/deploy/advantageScope/Robot2026.glb"); 
    }

    private final StringPublisher robotModelPublisher =
    NetworkTableInstance.getDefault()
        .getStringTopic("Field/RobotModel")
        .publish();

    private void configureBindings() {
        // Note that X is defined as forward according to WPILib convention,
        // and Y is defined as to the left according to WPILib convention.
        drivetrain.setDefaultCommand(
            // Drivetrain will execute this command periodically
            drivetrain.applyRequest(() ->
                //DAVID, WE TOOK THE LAZY ROUTE AND REMOVED NEGATIVES FROM THESE NEXT TWO LINES. I AM SORRY
                drive.withVelocityX(-joystick.getLeftY() * MaxSpeed) // Drive forward with negative Y (forward)
                    .withVelocityY(-joystick.getLeftX() * MaxSpeed) // Drive left with negative X (left)
                    .withRotationalRate(-joystick.getRightX() * MaxAngularRate) // Drive counterclockwise with negative X (left)
            )
        );

        // Idle while the robot is disabled. This ensures the configured
        // neutral mode is applied to the drive motors while disabled.
        final var idle = new SwerveRequest.Idle();
        RobotModeTriggers.disabled().whileTrue(
            drivetrain.applyRequest(() -> idle).ignoringDisable(true)
        );

        joystick.a().whileTrue(drivetrain.applyRequest(() -> brake));
        joystick.b().whileTrue(drivetrain.applyRequest(() ->
            point.withModuleDirection(new Rotation2d(-joystick.getLeftY(), -joystick.getLeftX()))
        ));

        // Run SysId routines when holding back/start and X/Y.
        // Note that each routine should be run exactly once in a single log.
        joystick.back().and(joystick.y()).whileTrue(drivetrain.sysIdDynamic(Direction.kForward));
        joystick.back().and(joystick.x()).whileTrue(drivetrain.sysIdDynamic(Direction.kReverse));
        joystick.start().and(joystick.y()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kForward));
        joystick.start().and(joystick.x()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kReverse));

        // Reset the field-centric heading on left bumper press.
        operator.button(5).onTrue(drivetrain.runOnce(drivetrain::seedFieldCentric));

        drivetrain.registerTelemetry(logger::telemeterize);
        
        //joystick.x().onTrue(suckingBalls);
        operator.button(3).whileTrue(testIntake);
        operator.button(4).whileTrue(reverseIntake);

        operator.axisGreaterThan(1, 0.5).whileTrue(closeMouth);
        operator.axisLessThan(1, -0.5).whileTrue(openMouth);

        operator.axisGreaterThan(3, 0.95).whileTrue(shoot);
        operator.button(1).whileTrue(reverseShooter);
        // operator.axisGreaterThan(2, 0.95).onTrue(digest);
        joystick.x().whileTrue(shootAt50Percent);
        joystick.y().whileTrue(shootMaxPower);
        // joystick.rightTrigger().whileTrue(digest);
        joystick.leftTrigger().whileTrue(shootAt75Percent);
        joystick.rightTrigger().whileTrue(shoot);

// dual controller, controller + buttonboard, where controller moves button board for commands.
// add buttonboard
// probably add the table for angle similar to distance. "at this distance, rotate until this degree


        operator.button(4).whileTrue((Commands.runOnce(() -> limeLight.driveToTag()).repeatedly()));
    }

    public Command getAutonomousCommand() {
        /* Run the path selected from the auto chooser */
        return autoChooser.getSelected();
    }
}

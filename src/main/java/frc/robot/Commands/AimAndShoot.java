package frc.robot.Commands;

import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.CommandSwerveDrivetrain;

public class AimAndShoot  extends Command {
    private Shooter shooter; 
    private Loader loader;
    private Feeder feeder;
    private Vision vision;
    private CommandSwerveDrivetrain drivetrain;
    
        public AimAndShoot(Vision vision, Shooter shooter, Loader loader, Feeder feeder, CommandSwerveDrivetrain drivetrain) {
            this.vision = vision;
            this.shooter = shooter;
            this.loader = loader;
            this.feeder = feeder;
            this.drivetrain = drivetrain;
        addRequirements(shooter, loader, feeder, vision, drivetrain);
    }


    @Override
    public void execute() {
        boolean onTarget = vision.aim();
        drivetrain.setControl(new SwerveRequest.FieldCentric().withVelocityX(0).withVelocityY(0).withRotationalRate(0));
        
    if (onTarget) {
        toggleShooterOn();
    } else {
        toggleShooterOff();
    }
    }

    @Override
    public void end(boolean interrupted) {
        toggleShooterOff();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    private boolean shooterisOn() {
        return shooter.isShooterOn();
    }

    private void toggleShooterOn() {
        shooter.shoot();
        loader.load();
        feeder.startFeeder();
    }

    private void toggleShooterOff() {
        shooter.stopShooting();
        loader.stop();
        feeder.stopFeeder();
   }
}
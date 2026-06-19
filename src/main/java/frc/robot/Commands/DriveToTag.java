package frc.robot.Commands;

import com.ctre.phoenix6.swerve.SwerveRequest;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Vision;

public class DriveToTag extends Command {
    private final CommandSwerveDrivetrain m_drivetrain;
    private final Vision m_vision;
    private final SwerveRequest.FieldCentric m_drive;

    public DriveToTag(CommandSwerveDrivetrain drivetrain, Vision vision, SwerveRequest.FieldCentric drive) {
        m_drivetrain = drivetrain;
        m_vision = vision;
        m_drive = drive;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        if (!LimelightHelpers.getTV("limelight")) {
            m_drivetrain.setControl(m_drive.withVelocityX(0).withVelocityY(0).withRotationalRate(0));
            return;
        }
        double xSpeed = m_vision.limelight_range_proportional();
        double ySpeed = m_vision.limelight_strafe_proportional();
        double rot    = m_vision.limelight_aim_proportional();
        m_drivetrain.setControl(m_drive.withVelocityX(xSpeed).withVelocityY(ySpeed).withRotationalRate(rot));
    }

    @Override
    public void end(boolean interrupted) {
        m_drivetrain.setControl(m_drive.withVelocityX(0).withVelocityY(0).withRotationalRate(0));
    }

    @Override
    public boolean isFinished() {
        if (!LimelightHelpers.getTV("limelight")) return false;
        double tx = LimelightHelpers.getTX("limelight");
        double ty = LimelightHelpers.getTY("limelight");
        boolean aligned = Math.abs(tx) < Constants.LimelightConstants.kAimingTolerance;
        boolean atRange = Math.abs(ty) < Constants.LimelightConstants.kRangeTolerance;
        return aligned && atRange;
    }
}

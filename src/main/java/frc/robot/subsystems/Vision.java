package frc.robot.subsystems;

import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;

public class Vision extends SubsystemBase {

    private final SwerveRequest.FieldCentric drive;

    public Vision(SwerveRequest.FieldCentric drive) {
        this.drive = drive;
    }

    public void driveToTag() {
    double ySpeed = limelight_strafe_proportional();
    double rot = limelight_aim_proportional();
    double xSpeed = limelight_range_proportional(); 

    drive.withVelocityX(xSpeed).withVelocityY(ySpeed).withRotationalRate(rot);

    if (!LimelightHelpers.getTV("limelight")) {
      drive.withVelocityX(0).withVelocityY(0).withRotationalRate(0);
      return;
    }
  }

    /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  double limelight_aim_proportional() {    
    // kP (constant of proportionality)
    // this is a hand-tuned number that determines the aggressiveness of our proportional control loop
    // if it is too high, the robot will oscillate.
    // if it is too low, the robot will never reach its target
    // if the robot never turns in the correct direction, kP should be inverted.
    double kP = -.035;

    // tx ranges from (-hfov/2) to (hfov/2) in degrees. If your target is on the rightmost edge of 
    // your limelight 3 feed, tx should return roughly 31 degrees.
    double targetingAngularVelocity = LimelightHelpers.getTX("limelight") * kP;

    // convert to radians per second for our drive method
    targetingAngularVelocity *= Constants.LimelightConstants.kMaxAngularSpeed;

    //invert since tx is positive when the target is to the right of the crosshair
    targetingAngularVelocity *= -1.0;

    return targetingAngularVelocity;
  }

  // simple proportional ranging control with Limelight's "ty" value
  // this works best if your Limelight's mount height and target mount height are different.
  // if your limelight and target are mounted at the same or similar heights, use "ta" (area) for target ranging rather than "ty"
  double limelight_range_proportional() {    
    double kP = -.2;
    double targetingForwardSpeed = LimelightHelpers.getTY("limelight") * kP;
    targetingForwardSpeed *= Constants.LimelightConstants.kMaxSpeed;
    targetingForwardSpeed *= -1.0;
    return targetingForwardSpeed;
  }


  double limelight_strafe_proportional() {
    double kP = 0.03; // tune this
    double tx = LimelightHelpers.getTX("limelight");
    double strafeSpeed = tx * kP;
    strafeSpeed *= Constants.LimelightConstants.kMaxSpeed;
    strafeSpeed *= -1.0;
    return strafeSpeed;
  }
    
}

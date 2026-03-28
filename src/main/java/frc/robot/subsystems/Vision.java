package frc.robot.subsystems;

import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import edu.wpi.first.math.interpolation.InterpolatingDoubleTreeMap;


public class Vision extends SubsystemBase {

    private final SwerveRequest.FieldCentric drive;

    private static InterpolatingDoubleTreeMap shootingDistance = new InterpolatingDoubleTreeMap();

    private static double minimum_distance = 1.0;
    private static double maximum_distance = 4.5;

    private final NetworkTableEntry shooterPowerEntry;

    static {
        shootingDistance.put(minimum_distance, 0.35);
        shootingDistance.put(1.5, 0.425);
        shootingDistance.put(2.0, 0.50);
        shootingDistance.put(2.5, 0.575);
        shootingDistance.put(3.0, 0.65);
        shootingDistance.put(3.5, 0.725);
        shootingDistance.put(4.0, 0.80);
        shootingDistance.put(maximum_distance, 0.875);
    }
//85 inches max distance, convert to meters and measure
//175 diagnally max distance


    public Vision(SwerveRequest.FieldCentric drive) {
        this.drive = drive;
        NetworkTable table = NetworkTableInstance.getDefault().getTable("Settings");
        shooterPowerEntry = table.getEntry(Constants.ShooterSettings.SHOOTER_POWER_NAME);
        shooterPowerEntry.setDefaultDouble(Constants.ShooterSettings.POWER);
    }

    public void driveToTag() {

      double ySpeed = limelight_strafe_proportional();
      double rot = limelight_aim_proportional();
      double xSpeed = limelight_range_proportional();

      if (LimelightHelpers.getTV("limelight")) {
        drive.withVelocityX(xSpeed).withVelocityY(ySpeed).withRotationalRate(rot);
        return;
      }
    }

    public boolean aim() {

      double rot = limelight_aim_proportional();

      if (LimelightHelpers.getTV("limelight")) {
        drive.withVelocityX(0).withVelocityY(0).withRotationalRate(rot);

        double tx = LimelightHelpers.getTX("limelight"); // get the horizontal offset from the crosshair to the target in degrees. This will be used for aiming.
        return Math.abs(tx) < Constants.LimelightConstants.kAimingTolerance; // check if the robot is aimed at the target
      }
      return false;
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

  public double distance_estimation_for_shooting() {
    if (!hasTarget()){
      return -1;
    }
      double[] botpose = NetworkTableInstance.getDefault()
              .getTable("limelight")
              .getEntry("botpose_targetspace") // TODO: verify this is doing what you expect
              .getDoubleArray(new double[6]);

      double x = botpose[0];
      double z = botpose[2];

      return Math.sqrt(x * x + z * z);
  }

  public double getShootingPower(int correctTagID) {
    if (!isCorrectTag(correctTagID)) {
      return shooterPowerEntry.getDouble(Constants.ShooterSettings.POWER);
    }
    double distance = distance_estimation_for_shooting();

    if (distance < 0) {
      return shooterPowerEntry.getDouble(Constants.ShooterSettings.POWER);
    }

    distance = Math.min(distance, maximum_distance);
    distance = Math.max(distance, minimum_distance);

    Double power = shootingDistance.get(distance);

    return power != null ? power : 1.0;
  }

  public boolean hasTarget() {
    return LimelightHelpers.getTV("limelight");
}

public boolean isCorrectTag(int tagID) {
    if (!hasTarget()) return false;
    return (int) LimelightHelpers.getFiducialID("limelight") == tagID;
}

}

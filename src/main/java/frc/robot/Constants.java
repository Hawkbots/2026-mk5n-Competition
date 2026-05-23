package frc.robot;

public class Constants {

    public static class LimelightConstants {
        public static final double kMaxSpeed = 10.0; // 3 meters per second
        public static final double kMaxAngularSpeed = Math.PI; // 1/2 rotation per second
        public static final double kAimingTolerance = 4.0; // degrees
    }

    public static class MotorConstants {
        public static final int FEEDER_MOTOR_DEVICE_ID = 52;
        public static final int INTAKE_MOTOR_DEVICE_ID = 55;
        public static final int DEPLOY_INTAKE_MOTOR_DEVICE_ID = 56;
        public static final int LOADER_MOTOR_DEVICE_ID = 53;
        public static final int LEFT_SHOOTER_DEVICE_ID = 51;
        public static final int MIDDLE_SHOOTER_DEVICE_ID = 54;
        public static final int RIGHT_SHOOTER_DEVICE_ID = 57;
    }

    public static class ShooterSettings {
        public static final String SHOOTER_POWER_NAME = "Shooter Power";
        public static final double POWER = 5; // Placeholder value, adjust as needed
        public static final double POWER2 = 5; //default is 7.5
    }


}

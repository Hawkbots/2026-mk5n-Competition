package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Feeder extends SubsystemBase {
    private TalonFX feederMotor = new TalonFX(MotorConstants.FEEDER_MOTOR_DEVICE_ID); //placeholder for CAN ID

    public Feeder() {
    }

    public void startFeeder() {
        feederMotor.set(1);
    }

    public void stopFeeder(){
        feederMotor.set(0);
    }

    public void reverseFeeder(){
        feederMotor.set(-1);
    }

        public boolean isFeederOn() {
        double velocity = feederMotor.getVelocity().getValueAsDouble();
        return Math.abs(velocity) > .1;
    }

}

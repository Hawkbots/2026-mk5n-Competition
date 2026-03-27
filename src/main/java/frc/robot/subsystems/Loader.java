package frc.robot.subsystems; //i want to name it bladder or intestine

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Loader extends SubsystemBase{
    private TalonFX loaderMotor = new TalonFX(MotorConstants.LOADER_MOTOR_DEVICE_ID); //placeholder for CAN ID

    public Loader() {
    }

    public void load() {
        loaderMotor.set(-.5);
    }

    public void stop(){
        loaderMotor.set(0);
    }

    public void reverseLoader() {
        loaderMotor.set(-0.5);
    }

}

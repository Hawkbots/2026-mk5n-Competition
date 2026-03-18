package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Intake extends SubsystemBase {
    private TalonFX intakeMotor = new TalonFX(MotorConstants.INTAKE_MOTOR_DEVICE_ID); //placeholder for CAN ID
    private TalonFX deployMotor = new TalonFX(MotorConstants.DEPLOY_INTAKE_MOTOR_DEVICE_ID); // placeholder for CAN ID
    private DigitalInput deployLimitSwitch = new DigitalInput(0); // placeholder channel cuz idk how to use
                                                                  // limitswitches
    private DigitalInput storedLimitSwitch = new DigitalInput(1); // placeholder channel cuz idk how to use
                                                                  // limitswitches

    public double getIntakeVelocity() {
        return intakeMotor.getVelocity().getValueAsDouble(); // check if intake motor is spinning
    }

    public Intake() {
    }

    public void startIntake() {
        if (deployed()) {
            intakeMotor.set(1); // spins wheel
        } else {
            stopIntake();
        }
    }

    public void stopIntake() {
        intakeMotor.set(0); // stop
    }

    public void reverseIntake() {
        intakeMotor.set(-1);
    }

    public boolean isIntakeOn() {
        double velocity = intakeMotor.getVelocity().getValueAsDouble();
        return Math.abs(velocity) > .1;
    }

    public void deploy() {
        if (deployed()) {
            halt();
            return;
        }
        deployMotor.set(.5); // set the intake down
    }

    public void halt() {
        deployMotor.set(0);
    }

    public void store() {
        if (stored()) {
            halt();
            return;
        }
        deployMotor.set(-.5); // store the intake
    }

    public boolean deployed() {
        return deployLimitSwitch.get(); // bottom limitswitch
    }

    public boolean stored() {
        return storedLimitSwitch.get(); // top limit switch
    }
}

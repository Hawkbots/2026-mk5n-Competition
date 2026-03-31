package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;



public class Intake extends SubsystemBase {
    private TalonFX intakeMotor = new TalonFX(MotorConstants.INTAKE_MOTOR_DEVICE_ID); //placeholder for CAN ID
    private SparkMax deployMotor = new SparkMax(MotorConstants.DEPLOY_INTAKE_MOTOR_DEVICE_ID, MotorType.kBrushless); // placeholder for CAN ID
    private DigitalInput deployLimitSwitch = new DigitalInput(0); // placeholder channel cuz idk how to use
                                                                  // limitswitches
    private DigitalInput storedLimitSwitch = new DigitalInput(1); // placeholder channel cuz idk how to use
                                                                  // limitswitches
    public double getIntakeVelocity() {
        return intakeMotor.getVelocity().getValueAsDouble(); // check if intake motor is spinning

    }

    //Troy Test Code Below
    public void testIntake() { //paste this in somewhere in Intake.java
        intakeMotor.set(-0.35);
    }
// setIntakeRPM(-1100); // example RPM
//     }
//     private final VelocityDutyCycle velocityRequest = new VelocityDutyCycle(0);

    public Intake() {
//             Slot0Configs slot0 = new Slot0Configs();
//             slot0.kP = 0.1;
//     slot0.kI = 0.0;
//     slot0.kD = 0.0;

//     intakeMotor.getConfigurator().apply(slot0);
    }

//     public void setIntakeRPM(double rpm) {
//     double rps = rpm / 60.0; // convert RPM → RPS
//     intakeMotor.setControl(velocityRequest.withVelocity(rps));
// }

// public double getIntakeVelocityRPM() {
//     double rps = intakeMotor.getVelocity().getValueAsDouble();
//     return rps * 60.0;
// }

    public void startIntake() {
        // if (deployed()) {
            intakeMotor.set(-1); // spins wheel
        // } else {
        //     stopIntake();
        // }
    }

    public void stopIntake() {
        intakeMotor.set(0); // stop
    }

    public void reverseIntake() {
        intakeMotor.set(0.3);
    }

    public boolean isIntakeOn() {
        double velocity = intakeMotor.getVelocity().getValueAsDouble();
        return Math.abs(velocity) > .3;
    }

    public void deploy() { 
        deployMotor.set(.5); // set the intake down
    }

    public void halt() {
        deployMotor.set(0);
    }

    public void store() {
        deployMotor.set(-.5); // store the intake
    }

    // public boolean deployed() {
    //     return deployLimitSwitch.get(); // bottom limitswitch
    // }

    // public boolean stored() {
    //     return storedLimitSwitch.get(); // top limit switch
    // }
}

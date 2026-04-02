package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;



public class Intake extends SubsystemBase {
    private TalonFX intakeMotor = new TalonFX(MotorConstants.INTAKE_MOTOR_DEVICE_ID); //placeholder for CAN ID
    private SparkMax deployMotor = new SparkMax(MotorConstants.DEPLOY_INTAKE_MOTOR_DEVICE_ID, MotorType.kBrushless); // placeholder for CAN ID

    public double getIntakeVelocity() {
        return intakeMotor.getVelocity().getValueAsDouble(); // check if intake motor is spinning

    }

    //Troy Test Code Below
    public void testIntake() { //paste this in somewhere in Intake.java
        intakeMotor.set(-0.34);
    }
// setIntakeRPM(-1100); // example RPM
//     }
//     private final VelocityDutyCycle velocityRequest = new VelocityDutyCycle(0);

    public Intake() {
    }


    public void startIntake() {
            intakeMotor.set(-0.4); // spins wheel
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
}

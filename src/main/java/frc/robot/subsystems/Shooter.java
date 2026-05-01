package frc.robot.subsystems; //i want to name it willy or butt

import java.util.Set;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Shooter extends SubsystemBase {
    private Vision vision;
    private TalonFX leftShooterMotor = new TalonFX(MotorConstants.LEFT_SHOOTER_DEVICE_ID);
    private TalonFX middleShooterMotor = new TalonFX(MotorConstants.MIDDLE_SHOOTER_DEVICE_ID);
    private TalonFX rightShooterMotor = new TalonFX(MotorConstants.RIGHT_SHOOTER_DEVICE_ID);

    public double getLeftShooterVelocity() {
        return leftShooterMotor.getVelocity().getValueAsDouble(); // check if intake motor is spinning
    }
    public double getMiddleShooterVelocity(){
        return middleShooterMotor.getVelocity().getValueAsDouble();
    }
    public double getRightShooterVelocity(){
        return rightShooterMotor.getVelocity().getValueAsDouble();
    }

    public Shooter(Vision vision) {
        this.vision = vision;
    }

    double shootingPower = vision.getShootingPower(Set.of(18, 26));


    public void shoot() {
        leftShooterMotor.setVoltage(-shootingPower);
        middleShooterMotor.setVoltage(shootingPower);
        rightShooterMotor.setVoltage(shootingPower);
    }

        public void shoot50Percent() {
        leftShooterMotor.setVoltage(-9);
        middleShooterMotor.setVoltage(9);
        rightShooterMotor.setVoltage(9);
    }

        public void shoot75Percent() {
        leftShooterMotor.setVoltage(-6);
        middleShooterMotor.setVoltage(6);
        rightShooterMotor.setVoltage(6);
    }

        public void shootMaxPower() {
        leftShooterMotor.setVoltage(-5);
        middleShooterMotor.setVoltage(5);
        rightShooterMotor.setVoltage(5);
    }




    public void stopShooting() {
        leftShooterMotor.set(0);
        middleShooterMotor.set(0);
        rightShooterMotor.set(0);
    }

    public void reverseShooter(){
        leftShooterMotor.set(0.5);
        middleShooterMotor.set(-0.5);
        rightShooterMotor.set(-0.5);
    }

    public void shootMiddleMotor(){
        middleShooterMotor.setVoltage(shootingPower);
    }

    // public boolean isLeftShooterOn() {
    //     double leftVelocity = leftShooterMotor.getVelocity().getValueAsDouble();
    //     return Math.abs(leftVelocity) > .1;
    // }

    // public boolean isMiddleShooterOn() {
    //     double middleVelocity = middleShooterMotor.getVelocity().getValueAsDouble();
    //     return Math.abs(middleVelocity) > .1;
    // }

    // public boolean isRightShooterOn() {
    //     double rightVelocity = rightShooterMotor.getVelocity().getValueAsDouble();
    //     return Math.abs(rightVelocity) > .1;
    // }


    public boolean isShooterOn() {
        return Math.abs(leftShooterMotor.getVelocity().getValueAsDouble()) > .1 ||
                Math.abs(middleShooterMotor.getVelocity().getValueAsDouble()) > 0.1 ||
                Math.abs(rightShooterMotor.getVelocity().getValueAsDouble()) > 0.1;
    }

}

    // public void startIntake() {
//         if (deployed()) {
//             intakeMotor.set(1); // spins wheel
//         } else {
//             stopIntake();
//         }
//     }

//     public void stopIntake() {
//         intakeMotor.set(0); // stop
//     }

//     public boolean isIntakeOn() {
//         double velocity = intakeMotor.getVelocity().getValueAsDouble();
//         return Math.abs(velocity) > .1;
//     }
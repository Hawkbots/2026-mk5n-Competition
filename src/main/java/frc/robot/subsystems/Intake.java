package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private TalonFX intakeMotor = new TalonFX(1); //placeholder for CAN ID
    private TalonFX deployMotor = new TalonFX(2); //placeholder for CAN ID
    private DigitalInput DeploylimitSwitch = new DigitalInput(0); //placeholder channel cuz idk how to use limitswitches

    public Intake(){
    }
    
    public void intakeStart() {
        intakeMotor.set(1); //spins wheel
    }

    public void intakeStop(){
        intakeMotor.set(0); // stop
    }

    public void deployStart() {
        deployMotor.set(.5); //set the intake down
        }

    public void deployEnd() {
        deployMotor.set(0);
    }

    public void deployReturn() {
        deployMotor.set(-.5); // store the intake
    }

    public boolean deployed() {
        return DeploylimitSwitch.get();
    }
}

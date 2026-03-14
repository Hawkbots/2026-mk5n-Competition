package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {
    private TalonFX feederMotor = new TalonFX(3); //placeholder for CAN ID

    public Feeder() {
    }

    public void swallow() {
        feederMotor.set(1);
    }

    public void full(){
        feederMotor.set(0);
    }

}

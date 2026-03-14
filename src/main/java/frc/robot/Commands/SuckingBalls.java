package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Feeder;

public class SuckingBalls extends Command {
    private Intake suck; 
    private Feeder digest;

    public SuckingBalls(Intake suck, Feeder digest) {
        this.suck = suck;
        this.digest = digest; 
        addRequirements(suck, digest);
    }

    @Override
    public void execute() {
        if (isOn()) {
            toggleOff();
        } else {
            toggleOn();
        }
    }

    private boolean isOn() {
        return suck.isIntakeOn();
    }

    private void toggleOn() {
        suck.startIntake();
        digest.swallow();
    }

    private void toggleOff() {
        suck.stopIntake();
        digest.full();
    }
}
    

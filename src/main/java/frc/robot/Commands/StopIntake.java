package frc.robot.Commands; //lowk idk what im doing

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class StopIntake extends Command {
    private Intake suck; 

    public StopIntake(Intake suck) {
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
    public void execute() {
        suck.stopIntake();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

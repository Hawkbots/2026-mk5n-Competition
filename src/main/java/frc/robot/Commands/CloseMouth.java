package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class CloseMouth extends Command {
    private Intake suck;


    public CloseMouth(Intake suck) {
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
    public void execute() {
        suck.stopIntake();
        suck.store(); // if top limitswitch returns true, store will halt and return
    }
}
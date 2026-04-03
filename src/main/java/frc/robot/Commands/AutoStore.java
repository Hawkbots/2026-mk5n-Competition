package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class AutoStore extends Command {
    private Intake suck;


    public AutoStore(Intake suck) {
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
    public void initialize() {
        suck.stopIntake();
        suck.store(); // if top limitswitch returns true, store will halt and return
    }

    @Override
    public void end(boolean interrupted) {
        suck.halt();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

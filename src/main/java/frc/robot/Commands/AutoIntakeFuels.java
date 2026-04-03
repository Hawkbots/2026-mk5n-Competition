package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class AutoIntakeFuels extends Command {
    private Intake suck;


    public AutoIntakeFuels(Intake suck) {
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
public void initialize() {
    suck.testIntake();
}

@Override
public void end(boolean interrupted) {
    suck.stopIntake();
}

@Override
public boolean isFinished() {
    return false;
    }
}

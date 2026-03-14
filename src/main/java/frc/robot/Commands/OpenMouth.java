package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class OpenMouth extends Command {
    private Intake suck;


    public OpenMouth(Intake suck) {
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
    public void execute() {
        suck.deploy(); // if bottom limitswitch returns true, deploy will halt and return
    }
}
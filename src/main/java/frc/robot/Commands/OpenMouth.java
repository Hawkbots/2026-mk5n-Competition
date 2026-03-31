package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class OpenMouth extends Command {
    private Intake suck;


    public OpenMouth(Intake suck) {
        System.err.println("fuck you troy");
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
    public void initialize() {
        suck.stopIntake();
        suck.deploy(); // if bottom limitswitch returns true, deploy will halt and return
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
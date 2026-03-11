package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Feeder;

public class SuckingBalls extends Command {
    private Intake Suck; 
    private Feeder Digest;

    public SuckingBalls(Intake Suck, Feeder Digest) {
        this.Suck = Suck;
        this.Digest = Digest; 
        addRequirements(Suck, Digest);
    }

    @Override
    public void execute() {

        if (!Suck.deployed()) {
            Suck.deployStart();   //deploys the intake until triggered
        } else {
            Suck.deployEnd();   // stop deploy
            Suck.intakeStart();
            Digest.Swallow();
        }
    }

    @Override
    public void end(boolean interrupted) {
        Suck.deployEnd();
    }
}
    

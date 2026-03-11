package frc.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Feeder;

public class ZipPants extends Command{
    private Intake Suck; 
    private Feeder Digest;

    @Override
    public void execute() {
        Suck.intakeStop();
        Digest.Full();
        Suck.deployReturn();
    }
}

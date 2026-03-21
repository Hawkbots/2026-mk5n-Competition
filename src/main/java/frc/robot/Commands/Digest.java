package frc.robot.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;


public class Digest extends Command {
    private Feeder feeder;

        public Digest(Feeder feeder) {
        this.feeder = feeder;
        addRequirements(feeder);
    }

    @Override
    public void execute() {
        if (isFeederOn()) {
            toggleFeederOff();
        } else {
            toggleFeederOn();
        }
    }

    private boolean isFeederOn() {
        return feeder.isFeederOn();
    }

    private void toggleFeederOn() {
        feeder.startFeeder();
    }

    private void toggleFeederOff() {
        feeder.stopFeeder();
    }

}

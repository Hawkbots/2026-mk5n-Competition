package frc.robot.Commands; //back up code in case limitswitch too hard to install

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class reverseIntake extends Command {
    private Intake suck;


    public reverseIntake(Intake suck) {
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
    public void initialize() { // idk which one. One of these will work
        if (isOn()) {
            suck.stopIntake();
        } else {
            suck.reverseIntake();

        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    private boolean isOn() {
        return suck.isIntakeOn();
    }
}


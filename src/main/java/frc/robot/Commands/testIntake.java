package frc.robot.Commands; //back up code in case limitswitch too hard to install

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class testIntake extends Command {
    private Intake suck;


    public testIntake(Intake suck) {
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


    // @Override
    // public void initialize() { // idk which one. One of these will work
    //     if (isOn()) {
    //         suck.stopIntake();
    //     } else {
    //         suck.testIntake();

    //     }
    // }

    @Override
    public boolean isFinished() {
        return false;
    }

    // private boolean isOn() {
    //     return suck.isIntakeOn();
    // }
}


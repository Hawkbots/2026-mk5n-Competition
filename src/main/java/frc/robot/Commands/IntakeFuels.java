package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;


public class IntakeFuels extends Command {
    private Intake suck; 

    public IntakeFuels(Intake suck) {
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
    public void initialize() {
        // if (isOn()) {
        //     toggleOff();
        // } else {
        //     toggleOn();
            
        // }
        suck.startIntake();
    }

//   @Override
//     public boolean isFinished() {
//         return false;
//     }


    @Override
    public void end(boolean interrupted) {
        suck.stopIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }


    private boolean isOn() {
        return suck.isIntakeOn();
    }

    private void toggleOn() {
        suck.startIntake();
    }

    private void toggleOff() {
        suck.stopIntake();
    }
}
    

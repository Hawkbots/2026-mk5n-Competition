package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;


public class SuckingBalls extends Command {
    private Intake suck; 

    public SuckingBalls(Intake suck) {
        this.suck = suck;
        addRequirements(suck);
    }

    @Override
    public void end(boolean interrupted) {
        //stopIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }


    @Override
    public void execute() {
        // if (isOn()) {
        //     toggleOff();
        // } else {
        //     toggleOn();
            
        // }
        System.err.println("fuck you troy");
        suck.startIntake();
    }

//   @Override
//     public boolean isFinished() {
//         return false;
//     }

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
    

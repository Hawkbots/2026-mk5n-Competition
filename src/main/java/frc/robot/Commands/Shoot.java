package frc.robot.Commands; //i want to name it poop or pee

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;

public class Shoot  extends Command {
    private Shooter shooter; 
    private Loader loader;

    public Shoot(Shooter shooter, Loader loader) {
        this.shooter = shooter;
        this.loader = loader;
        addRequirements(shooter, loader);
    }



// @Override
// public void execute() {
//     shooter.shoot();
//     loader.load();
// }


    @Override
    public void execute() {
        if (shooterisOn()) {
            toggleShooterOff();
        } else {
            toggleShooterOn();
        }
    }

    private boolean shooterisOn() {
        return shooter.isShooterOn();
    }

    private void toggleShooterOn() {
        shooter.shoot();
        loader.load();
    }

    private void toggleShooterOff() {
        shooter.stopShooting();
        loader.stop();
   }
}

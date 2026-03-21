package frc.robot.Commands; //i want to name it poop or pee

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;

public class Shoot  extends Command {
    private Shooter shooter; 
    private Loader loader;
    private Feeder feeder;

    public Shoot(Shooter shooter, Loader loader, Feeder feeder) {
        this.shooter = shooter;
        this.loader = loader;
        this.feeder = feeder;
        addRequirements(shooter, loader, feeder);
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
        feeder.startFeeder();
    }

    private void toggleShooterOff() {
        shooter.stopShooting();
        loader.stop();
        feeder.stopFeeder();
   }
}

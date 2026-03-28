package frc.robot.Commands; //i want to name it poop or pee

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.Feeder;

public class AimAndShoot  extends Command {
    private Shooter shooter; 
    private Loader loader;
    private Feeder feeder;
    private Vision vision;

    public AimAndShoot(Vision vision, Shooter shooter, Loader loader, Feeder feeder) {
        this.vision = vision;
        this.shooter = shooter;
        this.loader = loader;
        this.feeder = feeder;
        addRequirements(shooter, loader, feeder, vision);
    }


    @Override
    public void execute() {
        boolean onTarget = vision.aim();
        if (onTarget && !shooterisOn()) {
            toggleShooterOn();
        }
    }

    @Override
    public boolean isFinished() {
        toggleShooterOff();
        return true;
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

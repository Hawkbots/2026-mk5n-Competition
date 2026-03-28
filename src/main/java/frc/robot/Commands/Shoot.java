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


    @Override
    public void initialize() {
        // if (shooterisOn()) {
        //     toggleShooterOff();
        // } else {
        //     toggleShooterOn();
        // }
        toggleShooterOn();

    }

    @Override
    public void end(boolean interrupted) {
        toggleShooterOff();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    private boolean shooterisOn() {
        return shooter.isShooterOn();
    }

    private void toggleShooterOn() {
        shooter.shoot();
        loader.load();
        feeder.startFeeder();
    }

    public void toggleShooterOff() {
        shooter.stopShooting();
        loader.stop();
        feeder.stopFeeder();
   }
}

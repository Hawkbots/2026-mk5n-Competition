package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;

public class ShootAt50Percent extends Command {
    private Shooter shooter; 
    private Loader loader;
    private Feeder feeder;

    public ShootAt50Percent(Shooter shooter, Loader loader, Feeder feeder) {
        this.shooter = shooter;
        this.loader = loader;
        this.feeder = feeder;
        addRequirements(shooter, loader, feeder);
    }


    @Override
    public void initialize() {
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
        shooter.shoot50Percent();
        loader.load();
        feeder.startFeeder();
    }

    public void toggleShooterOff() {
        shooter.stopShooting();
        loader.stop();
        feeder.stopFeeder();
   }
}


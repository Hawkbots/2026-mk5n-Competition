package frc.robot.Commands;

import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj2.command.Command;

public class ReverseShooter extends Command{
        private Loader loader;
        private Shooter shooter;
        
        private Feeder feeder;

    public ReverseShooter(Shooter shooter, Loader loader, Feeder feeder) {
        this.shooter = shooter;
        this.loader = loader;

        this.feeder = feeder;
        addRequirements(shooter, loader, feeder);
    }

    @Override
    public void execute() {
        shooter.reverseShooter();
        loader.reverseLoader();
        
        feeder.reverseFeeder();
    }

    @Override
    public void end(boolean interrupted) {  
        shooter.stopShooting();
        loader.stop();
        feeder.stopFeeder();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}
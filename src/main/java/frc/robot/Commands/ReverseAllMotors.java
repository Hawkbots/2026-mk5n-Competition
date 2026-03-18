package frc.robot.Commands; //calling it vomit

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Feeder;
import edu.wpi.first.wpilibj2.command.Command;

public class ReverseAllMotors extends Command{
        private Loader loader;
        private Shooter shooter;
        private Intake intake;
        private Feeder feeder;

    public ReverseAllMotors(Shooter shooter, Loader loader, Intake intake, Feeder feeder) {
        this.shooter = shooter;
        this.loader = loader;
        this.intake = intake;
        this.feeder = feeder;
        addRequirements(shooter, loader, intake, feeder);
    }

    @Override
    public void execute() {
        shooter.reverseShooter();
        loader.reverseLoader();
        intake.reverseIntake();
        feeder.reverseFeeder();
    }
}

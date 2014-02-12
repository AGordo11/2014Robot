import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.templates.commands.*;

public class Shooter extends Subsystem{
    Jaguar shootJag, wenchJag;
    
    public void initDefaultCommand(){
        setDefaultCommand(new Shoot());
    }

    public Shooter(){
        shootJag = new Jaguar(RobotMap.Shooter_Jag);
        wenchJag = new Jaguar(RobotMap.Wench_Jag);
    }
}
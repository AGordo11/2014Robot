package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.*;

public class Shooter extends Subsystem{
    Talon winchTal;
    Solenoid brakeSol, shifterSol;
    
    public Shooter(){
        //winchTal = new Talon(RobotMap.Winch_Talon);
        
        //brakeSol = new Solenoid(RobotMap.Winch_Talon);
        //shifterSol = new Solenoid(RobotMap.Shifter_Solenoid);
    }
    
    public void initDefaultCommand(){}
    
    public void Release(){
        //brakeSol.set(false);
    }
    
    public void Retract(){
        /*winchTal.set(1);
        brakeSol.set(false);
        shifterSol.set(false);*/
    }
    
    public void Stop(){
        /*winchTal.set(0);
        brakeSol.set(true);
        shifterSol.set(true);*/
    }
}
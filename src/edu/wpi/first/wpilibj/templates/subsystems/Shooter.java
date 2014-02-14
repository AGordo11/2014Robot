package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Shooter extends Subsystem{
    Talon sTal;
    
    public Shooter(){
        sTal = new Talon(RobotMap.Shooter_Talon);
        LiveWindow.addActuator("Shooter", "Shooter Motor", sTal);
    }
    
    public void initDefaultCommand(){}
    
    public void Retract(){
        sTal.set(-0.1);
    }
    
    public void Stop(){
        sTal.set(0);
    }
}
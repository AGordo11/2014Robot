package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Shooter extends Subsystem{
    DigitalInput sSen;
    Talon sTal;
    
    public Shooter(){
        sTal = new Talon(RobotMap.Shooter_Talon);
        LiveWindow.addActuator("Shooter", "Shooter Motor", sTal);
        
        sSen = new DigitalInput(RobotMap.Shooter_Sensor);
        LiveWindow.addActuator("Shooter", "Shooter Sensor", sSen);
    }
    
    public void initDefaultCommand(){}
    
    public void Shoot(double power){
        sTal.set(power);
    }
    
    public void Stop(){
        sTal.set(0);
    }
    
    public boolean getSensor(){
        return !sSen.get();
    }
}
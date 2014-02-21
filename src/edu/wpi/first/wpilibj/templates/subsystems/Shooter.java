package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Shooter extends Subsystem{
    DigitalInput sSen;
    //DigitalInput sSen;
    Talon sTal;
    //Solenoid stopSol;
    
    public Shooter(){
        sTal = new Talon(RobotMap.Shooter_Talon);
        LiveWindow.addActuator("Shooter", "Shooter Motor", sTal);
        
        //stopSol = new Solenoid(RobotMap.Stopper_Solenoid);
        //LiveWindow.addActuator("Shooter", "Stopper Solenoid", stopSol);
        
        sSen = new DigitalInput(RobotMap.Shooter_Sensor);
        LiveWindow.addActuator("Shooter", "Shooter Sensor", sSen);
    }
    
    public void initDefaultCommand(){}
    
    public void Shoot(){
        sTal.set(-1.0);
    }
    
    public void Stop(){
        sTal.set(0);
    }
    
    /*public void MoveStopper(){
        if(getStopper()){
            stopSol.set(false);
        }else{
            stopSol.set(true);
        }
    }
    
    public boolean getStopper(){
        return stopSol.get();
    }*/
    
    public boolean getSensor(){
        return !sSen.get();
    }
}
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.JoystickRotate;

public class Intake extends Subsystem{
    Talon rTal, roTal;
    
    public void initDefaultCommand(){
        setDefaultCommand(new JoystickRotate());
    }

    public Intake(){
        rTal = new Talon(RobotMap.Roller_Talon);
        roTal = new Talon(RobotMap.Rotator_Talon);
        LiveWindow.addActuator("Intake", "Roller Motor", rTal);
        LiveWindow.addActuator("Intake", "Rotator Motor", roTal);
    }
    
    public void Rotate(double output){
        roTal.set(output);
    }
          
    public void RotStop(){
        roTal.set(0);
    }
    
    public void Roller(double output){
        rTal.set(output);
    }
    
    public double getRoller(){
        return rTal.get();
    }
    
    public double getRot(){
        return roTal.get();
    }
}
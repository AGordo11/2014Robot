package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.JoystickRotate;

public class Intake extends PIDSubsystem{
    public static final double P = 0.250;
    public static final double I = 0;
    public static final double D = 0.015;
    
    AnalogPotentiometer pot;
    Talon rTal, roTal;
    
    public void initDefaultCommand(){
        setDefaultCommand(new JoystickRotate());
    }

    public Intake(){
        super("Intake", P, I, D);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Intake", "PID", getPIDController());
        
        rTal = new Talon(RobotMap.Roller_Talon);
        roTal = new Talon(RobotMap.Rotator_Talon);
        LiveWindow.addActuator("Intake", "Roller Motor", rTal);
        LiveWindow.addActuator("Intake", "Rotator Motor", roTal);
        
        pot = new AnalogPotentiometer(RobotMap.Rotator_Pot);
        LiveWindow.addSensor("Intake", "Rotator Potentiometer", pot);     
    }
    
    public void Rotate(double output){
        roTal.set(output);
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
    
    public double getPot(){
        return pot.pidGet();
    }
    
    protected void usePIDOutput(double output){
        roTal.set(output);
    }
    
    protected double returnPIDInput(){
        return pot.pidGet();
    }
}
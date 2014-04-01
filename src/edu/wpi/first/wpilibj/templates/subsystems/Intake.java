package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Timer;

public class Intake extends Subsystem{
    Timer timer;
    DoubleSolenoid ears, rollers;
    Talon rTal, uTal;

    public void initDefaultCommand(){}

    public Intake(){
        timer = new Timer();
        
        rTal = new Talon(RobotMap.Roller_Talon);
        uTal = new Talon(RobotMap.Up_Roller_Talon);
        
        ears = new DoubleSolenoid(RobotMap.Ears_SolenoidA, RobotMap.Ears_SolenoidB);
        rollers = new DoubleSolenoid(RobotMap.Intake_SolenoidA, RobotMap.Intake_SolenoidB);
    }
    
    public void ActEars(){
        if(!Global.isRun){
            ears.set(DoubleSolenoid.Value.kForward);
            Global.isRun = true;
        }else{
            ears.set(DoubleSolenoid.Value.kReverse);
            Global.isRun = false;
        }
    }
    
    public void ActRollers(){
        if(!Global.isRun){
            rollers.set(DoubleSolenoid.Value.kForward);
            Global.isRun = true;
        }else{
            rollers.set(DoubleSolenoid.Value.kReverse);
            Global.isRun = false;
        }
    }
    
    public void OpenIntake(double output){
        uTal.set(output);
        if(Global.isRun){
            ears.set(DoubleSolenoid.Value.kForward);
            rollers.set(DoubleSolenoid.Value.kForward);
        }else{
            ears.set(DoubleSolenoid.Value.kReverse);
            rollers.set(DoubleSolenoid.Value.kReverse);
        }
    }
    
    public void RunRollers(double output){
        rTal.set(output);
    }
    
    public void RunUpRollers(double output){
        uTal.set(output);
    }
    
    public void RunIntake(double output){
        rTal.set(output);
        uTal.set(output);
        if(Global.isRun){
            rollers.set(DoubleSolenoid.Value.kForward);
        }else{
            rollers.set(DoubleSolenoid.Value.kReverse);
            timer.start();
            while(timer.get() <= 1.0){
                uTal.set(1.0);
            }
            uTal.set(0);
        }
    }
    
    public double getUpRollers(){
        return uTal.get();
    }
    
    public double getRollers(){
        return rTal.get();
    }
}
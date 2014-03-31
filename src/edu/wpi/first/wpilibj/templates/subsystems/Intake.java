package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.JoystickRotate;

public class Intake extends PIDSubsystem{
    public static final double P = 0.250;
    public static final double I = 0;
    public static final double D = 0.015;
    
    AnalogPotentiometer pot;
    DoubleSolenoid ears;
    Talon rTal, roTal;
    
    public void initDefaultCommand(){
        setDefaultCommand(new JoystickRotate());
    }

    public Intake(){
        super("Intake", P, I, D);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Intake", "PID", getPIDController());
        
        rTal = new Talon(RobotMap.Roller_Talon);
        LiveWindow.addActuator("Intake", "Roller Motor", rTal);
        
        ears = new DoubleSolenoid(RobotMap.Ears_SolenoidA, RobotMap.Ears_SolenoidB);
        LiveWindow.addActuator("Intake", "Ears", ears);
    }
    
    public void Rotate(double output){
        roTal.set(output);
    }
    
    public void Roller(double output){
        rTal.set(output);
    }
    
    public void Ears(){
        if(ears.get() == DoubleSolenoid.Value.kForward){
            ears.set(DoubleSolenoid.Value.kReverse);
            Global.msg = "kReverse";
        }else{
            ears.set(DoubleSolenoid.Value.kForward); 
            Global.msg = "kForward";
        }
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
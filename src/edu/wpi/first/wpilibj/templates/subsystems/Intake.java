package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Intake extends Subsystem{
    Timer timer;
    DigitalInput bSen;
    DoubleSolenoid ears, rollers;
    Talon rTal, uTal;

    public void initDefaultCommand(){}

    public Intake(){
        timer = new Timer();
        
        rTal = new Talon(RobotMap.Roller_Talon);
        uTal = new Talon(RobotMap.Up_Roller_Talon);
        
        ears = new DoubleSolenoid(RobotMap.Ears_SolenoidA, RobotMap.Ears_SolenoidB);
        rollers = new DoubleSolenoid(RobotMap.Intake_SolenoidA, RobotMap.Intake_SolenoidB);
        
        bSen = new DigitalInput(RobotMap.Ball_Sensor);
    }
    
    public void StartConfiguration(){
        ears.set(DoubleSolenoid.Value.kReverse);
        rollers.set(DoubleSolenoid.Value.kReverse);
        uTal.set(0);
        rTal.set(0);
        Global.isActRoller = false;
        Global.isEars = false;
        Global.isRoller = false;
        Global.isUpRoller = false;
        Global.isAction = false;
    }
    
    public void IntakeConfiguration(){
        timer.start();
        rollers.set(DoubleSolenoid.Value.kReverse);  
        rTal.set(1.0);
        uTal.set(1.0);
        while(!Global.isBall && timer.get() <= 0.9){
            if(getSensor()){
                Global.isBall = true;
            }
        }
        timer.stop();
        timer.reset();
        uTal.set(0);
        rTal.set(0);
        Global.isActRoller = false;
        Global.isEars = false;
        Global.isRoller = false;
        Global.isUpRoller = false;
        Global.isAction = false;
    }
    
    public void QuickPickup(){
        timer.start();
        while(timer.get() <= 0.4){
            rTal.set(1.0);
        }
        rTal.set(0);
    }
    
    public void MedPickup(){
        timer.start();
        while(timer.get() <= 1.0){
            rTal.set(1.0);
        }
        rTal.set(0);
    }
    
    public void ActEars(){
        if(Global.isEars){
            ears.set(DoubleSolenoid.Value.kReverse);
            Global.isEars = false;
        }else{
            ears.set(DoubleSolenoid.Value.kForward);
            Global.isEars = true;
        }
    }
    
    public void ActRollers(){
        if(Global.isActRoller){
            rollers.set(DoubleSolenoid.Value.kReverse);
            Global.isActRoller = false;
        }else{
            rollers.set(DoubleSolenoid.Value.kForward);
            Global.isActRoller = true;
        }
    }
    
    public void RunRollers(){
        if(Global.isRoller){
            rTal.set(1.0);
            Global.isRoller = false;
        }else{
            rTal.set(0);
            Global.isRoller = true;
        }
    }
    
    public void RunUpRollers(){
        if(Global.isUpRoller){
            uTal.set(1.0);
            Global.isUpRoller = false;
        }else{
            uTal.set(0);
            Global.isUpRoller = true;
        }
    }
    //Important methods
    public void RunIntake(){
        if(Global.isAction){
            IntakeConfiguration();
        }else{
            if(!Global.isActRoller){
                Global.isActRoller = true;
                rollers.set(DoubleSolenoid.Value.kForward);
            }
            if(!Global.isRoller){
                Global.isRoller = true;
                rTal.set(1.0);
            }
            if(!Global.isUpRoller){
                Global.isUpRoller = true;
                uTal.set(1.0);
            }
            Global.isAction = true;
        }
    }
    
    public void RunSpittake(){
        if(Global.isAction){
            StartConfiguration();
        }else{
            if(!Global.isUpRoller){
                Global.isUpRoller = true;
                uTal.set(-1.0);
            }
            if(!Global.isRoller){
                Global.isRoller = true;
                rTal.set(-1.0);
            }
            Global.isAction = true;
        }
    }
    
    public void PickupStationary(){
        if(Global.isAction){
            StartConfiguration();
        }else{
            if(!Global.isUpRoller){
                Global.isUpRoller = true;
                uTal.set(1.0);
            }
            if(!Global.isRoller){
                Global.isRoller = true;
                rTal.set(1.0);
            }
            Global.isAction = true;
        }
    }
       
    public void OpenIntake(){
        if(Global.isAction){
            StartConfiguration();
        }else{
            if(!Global.isUpRoller){
                Global.isUpRoller = true;
                uTal.set(1.0);
            }
            if(!Global.isActRoller){
                Global.isActRoller = true;
                rollers.set(DoubleSolenoid.Value.kForward);
            }
            if(!Global.isEars){
                Global.isEars = true;
                ears.set(DoubleSolenoid.Value.kForward);
            }
            Global.isAction = true;
        }
    }
    
    public double getUpRollers(){
        return uTal.get();
    }
    
    public double getRollers(){
        return rTal.get();
    }
    
    public boolean getSensor(){
        return !bSen.get();
    }
}
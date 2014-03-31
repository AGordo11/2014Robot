package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

public class GoForward extends CommandBase{
    int inches;
    
    Timer timer;
    
    public GoForward(int inch){
        requires(dr);
        inches = inch;
        timer = new Timer();
    }

    protected void initialize(){
        timer.start();
        dr.ResetEncoders();
        dr.pid.setSetpoint(inches);
        dr.pid.enable();
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(inches >= 0){
            if(dr.getRightEnc() - inches >= -(inches/10) || timer.get() >= 1.5){
                return true;
            }else{
                return false;
            }
        }else{
            if(dr.getRightEnc() - inches <= -(inches/10) || timer.get() >= 1.5){
                return true;
            }else{
                return false;
            }
        }
    }

    protected void end(){
        timer.stop();
        timer.reset();
        dr.pid.disable();
        dr.Stop();    
    }
    
    protected void interrupted(){
        dr.Stop();
        dr.pid.disable();
        timer.stop();
        timer.reset();
    }
}

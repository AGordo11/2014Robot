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

    protected void execute(){
        if(inches <= 0){
            inches = -inches;
        }
    }

    protected boolean isFinished(){
        if(dr.getRightEnc() - inches > -3 || timer.get() >= 5){
            timer.stop();
            timer.reset();
            dr.pid.disable();
            dr.Stop();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){}
    
    protected void interrupted(){
        dr.Stop();
        dr.pid.disable();
        timer.stop();
        timer.reset();
    }
}

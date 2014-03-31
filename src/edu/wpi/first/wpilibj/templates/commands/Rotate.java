package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;

public class Rotate extends CommandBase{
    Timer timer;
    public int position;
    
    public Rotate(int pos) {
        requires(in);
        position = pos;
        timer = new Timer();
    }

    protected void initialize(){
        timer.start();
        in.enable();
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(Math.abs(in.getSetpoint() - in.getPosition()) < 0.01 || timer.get() >= 1.0){
            in.disable();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){
        timer.stop();
        timer.reset();
    }

    protected void interrupted(){
        timer.stop();
        timer.reset();
        in.disable();
    }
}

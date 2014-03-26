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
        if(position == 0){//Position 0 sets rotator inwards
            in.setSetpoint(Global.rotIn);
        }else if(position == 1){//Position 1 sets rotator upwards
            in.setSetpoint(Global.rotUp);
        }else if(position == 2){//Position 2 sets rotator outwards
            in.setSetpoint(Global.rotOut);
        }
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

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.Global;

public class Rotate extends CommandBase{
    public int position;
    
    Timer timer;
    
    public Rotate(int pos) {
        requires(in);
        position = pos;
        timer = new Timer();
    }

    protected void initialize(){
        if(position == 0){//Position 0 sets rotator inwards
            in.setSetpoint(Global.rotIn);
        }else if(position == 1){//Position 1 sets rotator upwards
            in.setSetpoint(Global.rotUp);
        }else if(position == 2){//Position 2 sets rotator outwards
            in.setSetpoint(Global.rotOut);
        }
        timer.start();
        in.enable();
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(Math.abs(in.getSetpoint() - in.getPosition()) < 0.01 || timer.get() >= 5){
            in.disable();
            timer.stop();
            timer.reset();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){}

    protected void interrupted(){
        in.disable();
        timer.stop();
        timer.reset();
    }
}

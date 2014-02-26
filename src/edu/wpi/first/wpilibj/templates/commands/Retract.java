package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;

public class Retract extends CommandBase{
    Timer timer = new Timer();
    
    public Retract(){
        requires(sh);
    }

    protected void initialize(){
        timer.start();
        if(!Global.isRetract){
            sh.Shoot();
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(sh.getSensor() || timer.get() >= 5){
            sh.Stop();
            Global.isRetract = true;
            timer.stop();
            timer.reset();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){
        sh.Stop();
        timer.stop();
        timer.reset();
    }

    protected void interrupted(){
        sh.Stop();
        timer.stop();
        timer.reset();
    }
}

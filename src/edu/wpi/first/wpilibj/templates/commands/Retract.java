package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;

public class Retract extends CommandBase{
    Timer timer;
    
    public Retract(){
        requires(sh);
        timer = new Timer();
    }

    protected void initialize(){
        timer.start();
        if(!Global.isRetract){
            sh.Shoot(-1.0);
            Global.msg = "Retracting...";
            Global.error = "";
        }else{
            Global.msg = "See error";
            Global.error = "Already retracted";
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(Global.isRetract){
            sh.Stop();
            Global.msg = "Retracted";
            Global.error = "";
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
        Global.msg = "See error";
        Global.error = "Retraction interrupted";
        sh.Stop();
        timer.stop();
        timer.reset();
    }
}

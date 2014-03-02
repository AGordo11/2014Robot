package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class Retract extends CommandBase{
    
    public Retract(){
        requires(sh);
    }

    protected void initialize(){
        if(!Global.isRetract){
            sh.Shoot();
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
    }

    protected void interrupted(){
        Global.msg = "See error";
        Global.error = "Retraction interrupted";
        sh.Stop();
    }
}

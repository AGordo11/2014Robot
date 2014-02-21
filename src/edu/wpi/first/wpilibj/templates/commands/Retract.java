package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class Retract extends CommandBase{
    
    public Retract(){
        requires(sh);
    }

    protected void initialize(){
        if(!Global.isRetract){
            sh.Shoot();
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(sh.getSensor()){
            sh.Stop();
            Global.isRetract = true;
            return true;
        }else{
            return false;
        }
    }

    protected void end(){
        sh.Stop();
    }

    protected void interrupted(){
        sh.Stop();
    }
}

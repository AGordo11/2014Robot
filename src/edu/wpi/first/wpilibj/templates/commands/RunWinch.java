package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.*;

public class RunWinch extends CommandBase{
    
    public RunWinch(){
        requires(sh);
    }

    protected void initialize(){}

    protected void execute(){
        if(Global.isUp){
            sh.Retract();
        }else{
            sh.Release();
        }
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}

    protected void interrupted(){}
}

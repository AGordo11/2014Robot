package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class RetractChange extends CommandBase{
    
    public RetractChange(){
        requires(sh);
    }

    protected void initialize(){
        if(Global.isRetract){
            Global.isRetract = false;
        }else{
            Global.isRetract = true;
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

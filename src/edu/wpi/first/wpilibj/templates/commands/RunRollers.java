package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class RunRollers extends CommandBase{
    
    public RunRollers(){}
    
    protected void initialize(){
        if(!Global.isRun){
            in.RunRollers(1.0);
            Global.isRun = true;
        }else{
            in.RunRollers(0);
            Global.isRun = false;
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

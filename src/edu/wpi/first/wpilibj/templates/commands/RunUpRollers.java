package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class RunUpRollers extends CommandBase{
    
    public RunUpRollers(){}

    protected void initialize(){
        if(!Global.isRun){
            in.RunUpRollers(1.0);
            Global.isRun = true;
        }else{
            in.RunUpRollers(0);
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

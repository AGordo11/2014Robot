package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class RunSpittake extends CommandBase{
    
    public RunSpittake(){
        requires(in);
    }

    protected void initialize(){
        if(!Global.isRun){
            Global.isRun = true;
            in.RunRollers(-1.0);
            in.RunUpRollers(-1.0);
        }else{
            Global.isRun = false;
            in.RunRollers(0);
            in.RunUpRollers(0);
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}
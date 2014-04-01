package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class OpenIntake extends CommandBase {
    
    public OpenIntake(){
        requires(in);
    }

    protected void initialize(){
        if(!Global.isRun){
            Global.isRun = true;
            in.OpenIntake(1.0);
        }else{
            Global.isRun = false;
            in.OpenIntake(0);
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

package edu.wpi.first.wpilibj.templates.commands;

//In case there's a problem with the limit tripping, this manual change allows for
//further retraction (limit switch still applies). For example, the arm goes down
//halfway and stops for whatever reason, you can use this command to continue retraction
//but the limit switch will still stop it in the future

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

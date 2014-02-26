package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class StopEverything extends CommandBase{
    
    public StopEverything(){
        requires(sh);
    }

    protected void initialize(){
        dr.Stop();
        sh.Stop();
        in.Roller(0);
        in.Rotate(0);
        Global.isRun = false;
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

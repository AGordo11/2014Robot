package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class PickAuto extends CommandBase{
    int pick;
    
    public PickAuto(int p){
        pick = p;
    }

    protected void initialize(){
        Global.autoPick = pick;
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}


    protected void interrupted(){}
}

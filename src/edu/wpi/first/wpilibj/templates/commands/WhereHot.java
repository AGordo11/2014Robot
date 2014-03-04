package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;

public class WhereHot extends CommandBase{
    
    public WhereHot(){
        requires(dr);
    }

    protected void initialize(){
        if(Global.boundX2 - Global.boundX >= 150 && Global.boundY >= 150 && Global.boundY2 - Global.boundY >= 50){
            Global.isHot = true;
        }else{
            Global.isHot = false;
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

package edu.wpi.first.wpilibj.templates.commands;

public class ChangeGears extends CommandBase{
    
    public ChangeGears(){
        requires(dr);
    }

    protected void initialize(){
        if(!dr.highGear()){
            dr.ChangeGearsHigh(false);
        }else{
            dr.ChangeGearsHigh(true);
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

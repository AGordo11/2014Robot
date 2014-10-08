package edu.wpi.first.wpilibj.templates.commands;

//A simple command to run or stop the upper wheels (inwards only)

public class RunUpRollers extends CommandBase{
    
    public RunUpRollers(){
        requires(in);
    }

    protected void initialize(){
        in.RunUpRollers();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

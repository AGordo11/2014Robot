package edu.wpi.first.wpilibj.templates.commands;

//A simple command to run the rollers inward

public class RunRollers extends CommandBase{
    
    public RunRollers(){
        requires(in);
    }
    
    protected void initialize(){
        in.RunRollers();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

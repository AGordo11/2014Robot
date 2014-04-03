package edu.wpi.first.wpilibj.templates.commands;

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

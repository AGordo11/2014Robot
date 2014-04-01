package edu.wpi.first.wpilibj.templates.commands;

public class ActRollers extends CommandBase{
    
    public ActRollers(){
        requires(in);
    }

    protected void initialize(){
        in.ActRollers();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}
    
    protected void interrupted(){}
}
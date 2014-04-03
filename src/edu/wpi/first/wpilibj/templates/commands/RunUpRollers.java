package edu.wpi.first.wpilibj.templates.commands;

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

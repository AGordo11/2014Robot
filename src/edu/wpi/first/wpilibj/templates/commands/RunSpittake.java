package edu.wpi.first.wpilibj.templates.commands;

public class RunSpittake extends CommandBase{
    
    public RunSpittake(){
        requires(in);
    }

    protected void initialize(){
        in.RunSpittake();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}
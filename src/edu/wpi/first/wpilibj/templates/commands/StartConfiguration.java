package edu.wpi.first.wpilibj.templates.commands;

public class StartConfiguration extends CommandBase{
    
    public StartConfiguration(){
        requires(in);
    }

    protected void initialize(){
        in.StartConfiguration();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

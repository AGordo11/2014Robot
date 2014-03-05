package edu.wpi.first.wpilibj.templates.commands;

public class Ears extends CommandBase{
    
    public Ears(){
        requires(in);
    }

    protected void initialize(){
        in.Ears();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

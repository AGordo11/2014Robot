package edu.wpi.first.wpilibj.templates.commands;

public class CompressorStart extends CommandBase{
    
    public CompressorStart(){
        requires(co);
    }

    protected void initialize(){
        co.Start();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}

    protected void interrupted(){}
}

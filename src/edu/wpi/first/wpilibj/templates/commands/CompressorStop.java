package edu.wpi.first.wpilibj.templates.commands;

public class CompressorStop extends CommandBase{
    
    public CompressorStop(){
        requires(co);
    }

    protected void initialize(){
        co.Stop();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}

    protected void interrupted(){}
}

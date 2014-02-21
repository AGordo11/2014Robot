package edu.wpi.first.wpilibj.templates.commands;

public class LowGear extends CommandBase{
    
    public LowGear() {
        requires(dr);
    }

    protected void initialize(){
        dr.ForceLow();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

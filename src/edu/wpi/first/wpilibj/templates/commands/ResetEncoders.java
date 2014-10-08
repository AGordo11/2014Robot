package edu.wpi.first.wpilibj.templates.commands;

//Reset encoders. Pretty obvious

public class ResetEncoders extends CommandBase{
    
    public ResetEncoders(){
        requires(dr);
    }

    protected void initialize(){
        dr.ResetEncoders();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

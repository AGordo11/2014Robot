package edu.wpi.first.wpilibj.templates.commands;

public class ResetEncoders extends CommandBase{
    
    public ResetEncoders(){
        requires(dr);
    }

    protected void initialize(){
        dr.ResetEncoders();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted(){}
}

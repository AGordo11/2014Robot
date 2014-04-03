package edu.wpi.first.wpilibj.templates.commands;

public class OpenIntake extends CommandBase {
    
    public OpenIntake(){
        requires(in);
    }

    protected void initialize(){
        in.OpenIntake();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

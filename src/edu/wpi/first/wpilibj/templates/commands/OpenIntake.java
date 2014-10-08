package edu.wpi.first.wpilibj.templates.commands;

//Automatic command--opens and closes pneumatic wings and rollers

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

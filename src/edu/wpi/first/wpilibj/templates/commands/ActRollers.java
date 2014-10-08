package edu.wpi.first.wpilibj.templates.commands;

//Actuates the pneumatic rollers up or down

public class ActRollers extends CommandBase{
    
    public ActRollers(){
        requires(in);
    }

    protected void initialize(){
        in.ActRollers();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}
    
    protected void interrupted(){}
}
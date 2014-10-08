package edu.wpi.first.wpilibj.templates.commands;

//Actuates the pneumatic wings

public class ActEars extends CommandBase{
    
    public ActEars(){
        requires(in);
    }

    protected void initialize(){
        in.ActEars();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

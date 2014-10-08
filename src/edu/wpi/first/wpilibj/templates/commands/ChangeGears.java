package edu.wpi.first.wpilibj.templates.commands;

//Changes gears--straightforward, innit?

public class ChangeGears extends CommandBase{
    
    public ChangeGears(){
        requires(dr);
    }

    protected void initialize(){
        dr.ChangeGears();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

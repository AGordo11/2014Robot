package edu.wpi.first.wpilibj.templates.commands;

public class Stopper extends CommandBase{
    
    public Stopper(){
        requires(sh);
    }

    protected void initialize(){
        //sh.MoveStopper();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

package edu.wpi.first.wpilibj.templates.commands;

//Starts roller motors briefly to hold the ball in just the rollers--used for auto

public class QuickPickup extends CommandBase{
    
    public QuickPickup(){
        requires(in);
    }

    protected void initialize(){
        in.QuickPickup();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

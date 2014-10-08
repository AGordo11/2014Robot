package edu.wpi.first.wpilibj.templates.commands;

//A longer version of QuickPickup--see that command for further details

public class MedPickup extends CommandBase{
    
    public MedPickup(){
        requires(in);
    }

    protected void initialize(){
        in.MedPickup();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

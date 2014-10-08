package edu.wpi.first.wpilibj.templates.commands;

//Intakes ball when stationary--kiss pass by rolling top and roller motors inwards

public class PickupStationary extends CommandBase{
    
    public PickupStationary(){
        requires(in);
    }

    protected void initialize(){
        in.PickupStationary();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

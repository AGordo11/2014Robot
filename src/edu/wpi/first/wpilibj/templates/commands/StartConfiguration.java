package edu.wpi.first.wpilibj.templates.commands;

//Brings rollers and wings back to the starting configuration and resets all IO
//values--both pneumatics and both motors

public class StartConfiguration extends CommandBase{
    
    public StartConfiguration(){
        requires(in);
    }

    protected void initialize(){
        in.StartConfiguration();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

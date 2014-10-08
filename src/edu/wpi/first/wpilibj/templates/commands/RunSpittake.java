package edu.wpi.first.wpilibj.templates.commands;

//An automatic command to spin both intake motors outwards (the rollers and the 
//upper wheels) to spit out the ball when it's in the robot

public class RunSpittake extends CommandBase{
    
    public RunSpittake(){
        requires(in);
    }

    protected void initialize(){
        in.RunSpittake();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}
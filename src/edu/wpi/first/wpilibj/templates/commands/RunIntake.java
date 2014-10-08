package edu.wpi.first.wpilibj.templates.commands;

//On first press, rollers actuate out, and the rollers/upper wheels go inwards
//On the next press, it brings the rollers in and stops the rolling inwards when
//the ball is in the machine all nice and snug

public class RunIntake extends CommandBase{
    
    public RunIntake(){
        requires(in);
    }

    protected void initialize(){
        in.RunIntake();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

package edu.wpi.first.wpilibj.templates.commands;

public class RunIntake extends CommandBase{
    
    public RunIntake(){
        requires(in);
    }

    protected void initialize(){
        in.Roller(-1.0);
    }

    protected void execute(){}

    protected boolean isFinished() {
        return false;
    }

    protected void end(){
        in.Roller(0);
    }

    protected void interrupted(){}
}

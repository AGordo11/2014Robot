package edu.wpi.first.wpilibj.templates.commands;

public class RetractAntlers extends CommandBase{
    
    public RetractAntlers() {
        requires(sh);
    }

    protected void initialize(){
        sh.Retract();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return false;
    }

    protected void end(){
        sh.Stop();
    }

    protected void interrupted(){}
}

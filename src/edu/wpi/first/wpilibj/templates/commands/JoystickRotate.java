package edu.wpi.first.wpilibj.templates.commands;

public class JoystickRotate extends CommandBase{
    
    public JoystickRotate(){
        requires(in);
    }

    protected void initialize(){}

    protected void execute(){
        in.Rotate(oi.getShooterY());
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}

    protected void interrupted(){}
}

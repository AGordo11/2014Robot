package edu.wpi.first.wpilibj.templates.commands;

public class JoystickDrive extends CommandBase{
    
    public JoystickDrive(){
        requires(dr);
    }

    protected void initialize(){}

    protected void execute(){
        dr.DriveJoysticks(oi.getLeftStick(), oi.getRightStick());
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

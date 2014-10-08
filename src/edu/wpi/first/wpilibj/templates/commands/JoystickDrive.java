package edu.wpi.first.wpilibj.templates.commands;

//Sends joystick values to the Drive subsystem for robot to move

public class JoystickDrive extends CommandBase{
    
    public JoystickDrive(){
        requires(dr);
    }

    protected void initialize(){}

    protected void execute(){
        dr.DriveJoysticks(oi.getLeftStick() * oi.getRightZ(), -oi.getRightStick() * oi.getRightZ());
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

package edu.wpi.first.wpilibj.templates.commands;

public class JoystickRotate extends CommandBase{
    
    public JoystickRotate(){
        requires(in);
    }

    protected void initialize(){}

    protected void execute(){
        if(oi.getShooterY() >= 0.5){
            
        }else if(oi.getShooterY() <= -0.5){
        
        }
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}

    protected void interrupted(){}
}

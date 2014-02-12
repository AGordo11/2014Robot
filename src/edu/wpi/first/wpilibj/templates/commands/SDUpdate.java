package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.*;

public class SDUpdate extends CommandBase{
    
    public SDUpdate(){
        requires(sd);
    }

    protected void initialize(){}

    protected void execute(){
        SmartDashboard.putNumber("Left Z: ", oi.getLeftThrottle());
        SmartDashboard.putNumber("Right Z: ", oi.getRightThrottle());
        SmartDashboard.putNumber("Shooter Z: ", oi.getShooterThrottle());
        SmartDashboard.putNumber("Left Output: ", dr.getLeftMotor() * -1);
        SmartDashboard.putNumber("Right Output: ", dr.getRightMotor());
        SmartDashboard.putNumber("Left Encoder: ", dr.getLeftEnc());
        SmartDashboard.putNumber("Right Encoder: ", dr.getRightEnc());
        SmartDashboard.putNumber("Distance Travelled: ", dr.getTravelled());
        SmartDashboard.putNumber("Crosshair X:", Global.crossX);
        SmartDashboard.putNumber("Crosshair Y:", Global.crossY);
        SmartDashboard.putBoolean("High Gear: ", dr.highGear());
        SmartDashboard.putBoolean("Is Right?", Global.isRight);
        SmartDashboard.putBoolean("Practice Robot? ", Global.isPrac);
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

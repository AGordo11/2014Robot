package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Global;

public class SDUpdate extends CommandBase{
    
    public SDUpdate(){
        requires(sd);
    }

    protected void initialize(){}

    protected void execute(){
        SmartDashboard.putNumber("Shooter Y ", oi.getShooterY());
        SmartDashboard.putNumber("Left Output ", -dr.getLeftMotor());
        SmartDashboard.putNumber("Right Output ", dr.getRightMotor());
        SmartDashboard.putNumber("Left Encoder ", dr.getLeftEnc());
        SmartDashboard.putNumber("Right Encoder ", dr.getRightEnc());
        SmartDashboard.putNumber("Roller Output ", in.getRoller());
        SmartDashboard.putNumber("Rotator Output ", in.getRot());
        SmartDashboard.putNumber("Rotator Position ", in.getPot());
        SmartDashboard.putNumber("Crosshair X ", Global.crossX);
        SmartDashboard.putNumber("Crosshair Y ", Global.crossY);
        SmartDashboard.putBoolean("High Gear ", dr.highGear());
        SmartDashboard.putBoolean("Is Right? ", Global.isRight);
        SmartDashboard.putBoolean("Shooter Sensor ", sh.getSensor());
        //SmartDashboard.putBoolean("Stopper ", sh.getStopper());
        SmartDashboard.putString("Error ", Global.error);
        SmartDashboard.putString("Message ", Global.msg);
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

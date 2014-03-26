package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Global;

public class SDUpdate extends CommandBase{
    
    public SDUpdate(){
        requires(sd);
    }

    protected void initialize(){}

    protected void execute(){
        if(sh.getSensor()){
            Global.isRetract = true;
        }
        //SmartDashboard.putNumber("Shooter Y ", oi.getShooterY());
        SmartDashboard.putNumber("Left Output ", -dr.getLeftMotor());
        SmartDashboard.putNumber("Right Output ", dr.getRightMotor());
        SmartDashboard.putNumber("Left Encoder ", dr.getLeftEnc());
        SmartDashboard.putNumber("Right Encoder ", dr.getRightEnc());
        SmartDashboard.putNumber("Roller Output ", in.getRoller());
        //SmartDashboard.putNumber("Rotator Output ", in.getRot());
        SmartDashboard.putNumber("Rotator Position ", in.getPot());
        SmartDashboard.putNumber("Laser Distance ", dr.getLaser());
        SmartDashboard.putBoolean("High Gear ", dr.highGear());
        SmartDashboard.putBoolean("Is Hot? ", Global.isHot);
        SmartDashboard.putBoolean("Is Retracted? ", Global.isRetract);
        SmartDashboard.putBoolean("Shooter Sensor ", sh.getSensor());
        SmartDashboard.putString("Error ", Global.error);
        SmartDashboard.putString("Message ", Global.msg);
        
        SmartDashboard.putNumber("Bound X ", Global.boundX);
        SmartDashboard.putNumber("Bound X2 ", Global.boundX2);
        SmartDashboard.putNumber("Bound Y", Global.boundY);
        SmartDashboard.putNumber("Bound Y2 ", Global.boundY2);
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

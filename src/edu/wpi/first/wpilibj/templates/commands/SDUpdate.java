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
        if(Global.isRetract && in.getSensor()){
            Global.isBall = true;
        }else{
            Global.isBall = false;
        }
        SmartDashboard.putNumber("Left Encoder ", dr.getLeftEnc());
        SmartDashboard.putNumber("Right Encoder ", dr.getRightEnc());
        SmartDashboard.putBoolean("High Gear ", dr.highGear());
        SmartDashboard.putBoolean("Is Retracted? ", Global.isRetract);
        SmartDashboard.putBoolean("Shooter Sensor ", sh.getSensor());
        SmartDashboard.putBoolean("Ball Sensor ", in.getSensor());
        
        SmartDashboard.putBoolean("isActRoller? ", Global.isActRoller);
        SmartDashboard.putBoolean("isRoller? ", Global.isRoller);
        SmartDashboard.putBoolean("isEars? ", Global.isEars);
        SmartDashboard.putBoolean("isUpRoller? ", Global.isUpRoller);
        SmartDashboard.putBoolean("isAction? ", Global.isAction);
        
        SmartDashboard.putBoolean("Current right: ", Global.isHotRight);
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

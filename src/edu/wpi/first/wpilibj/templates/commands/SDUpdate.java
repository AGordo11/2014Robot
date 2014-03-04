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
        SmartDashboard.putNumber("Shooter Y ", oi.getShooterY());
        SmartDashboard.putNumber("Left Output ", -dr.getLeftMotor());
        SmartDashboard.putNumber("Right Output ", dr.getRightMotor());
        SmartDashboard.putNumber("Left Encoder ", dr.getLeftEnc());
        SmartDashboard.putNumber("Right Encoder ", dr.getRightEnc());
        SmartDashboard.putNumber("Roller Output ", in.getRoller());
        SmartDashboard.putNumber("Rotator Output ", in.getRot());
        SmartDashboard.putNumber("Rotator Position ", in.getPot());
        SmartDashboard.putBoolean("High Gear ", dr.highGear());
        SmartDashboard.putBoolean("Is Hot? ", Global.isHot);
        SmartDashboard.putBoolean("Is Retracted? ", Global.isRetract);
        SmartDashboard.putBoolean("Shooter Sensor ", sh.getSensor());
        SmartDashboard.putString("Error ", Global.error);
        SmartDashboard.putString("Message ", Global.msg);
        try{
            Global.boundX = Double.parseDouble(SmartDashboard.getString("BOUNDX"));
            Global.boundX2 = Double.parseDouble(SmartDashboard.getString("BOUNDX2"));
            Global.boundY = Double.parseDouble(SmartDashboard.getString("BOUNDY"));
            Global.boundY2 = Double.parseDouble(SmartDashboard.getString("BOUNDY2"));
        }catch(NumberFormatException ex){
            Global.boundX = 0;
            Global.boundX2 = 0;
            Global.boundY = 0;
            Global.boundY2 = 0;
        }
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){}
    
    protected void interrupted(){}
}

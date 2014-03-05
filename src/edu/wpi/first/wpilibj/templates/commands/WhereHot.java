package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.Global;

public class WhereHot extends CommandBase{
     NetworkTable nt;
    
    public WhereHot(){
        requires(dr);
    }

    protected void initialize(){
        try{
            nt = NetworkTable.getTable("RoboRealm");
            Global.boundX = SmartDashboard.getNumber("BOUNX");
            Global.boundX2 = SmartDashboard.getNumber("BOUNDX2");
            Global.boundY = SmartDashboard.getNumber("BOUNDY");
            Global.boundY2 = SmartDashboard.getNumber("BOUNDY2");
        }catch(NumberFormatException ex){
            Global.boundX = 0;
            Global.boundX2 = 0;
            Global.boundY = 0;
            Global.boundY2 = 0;
        }
        
        if(Global.boundX2 - Global.boundX >= 100 && Global.boundY >= 100 && Global.boundY2 - Global.boundY >= 50){
            Global.isHot = true;
        }else{
            Global.isHot = false;
        }
        Global.msg = "Generic";
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

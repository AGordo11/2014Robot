package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Global;

public class WhereHot extends CommandBase{
    
    public WhereHot(){}

    protected void initialize(){
        /*try{
            Global.boundX = SmartDashboard.getNumber("BOUNDX", 4.0);
            Global.boundX2 = SmartDashboard.getNumber("BOUNDX2", 3.0);
            Global.boundY = SmartDashboard.getNumber("BOUNDY", 2.0);
            Global.boundY2 = SmartDashboard.getNumber("BOUNDY2", 1.0);
        }catch(Exception ex){}
        if(Global.boundY2 >= 80 && (Global.boundY2 - Global.boundY) >= 10 && (Global.boundX2 - Global.boundX) >= 80){
            Global.isHot = true;
        }else{*/
            Global.isHot = false;
        //}
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.TableKeyExistsWithDifferentTypeException;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.templates.Global;

public class WhereHot extends CommandBase{
    NetworkTable nt;
    
    public WhereHot(){
        requires(dr);
    }

    protected void initialize(){
        NumberArray cross = new NumberArray();
        try{
            nt = NetworkTable.getTable("SmartDashboard");
            nt.retrieveValue("CROSSHAIR_COORDINATES", cross);
            Global.crossX = cross.get(0);
            Global.crossY = cross.get(1);
            if(Global.crossX >= 320){
                Global.isRight = true;
            }else{
                Global.isRight = false;
            }
        }catch(TableKeyExistsWithDifferentTypeException ex){
            Global.isRight = true;
            Global.error = "Camera Failure";
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}

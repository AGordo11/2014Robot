package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.Timer;

public class Spin extends CommandBase{
    Timer timer;
    
    public Spin(){
        requires(dr);
        timer = new Timer();
    }
    
    public Spin(boolean rig){
        requires(dr);
        timer = new Timer();
        Global.isRight = rig;
    }

    protected void initialize(){
        timer.start();
    }

    protected void execute(){
        if(Global.isRight){
            dr.TankDrive(-1.0, 1.0);
        }else{
            dr.TankDrive(1.0, -1.0);
        }
    }

    protected boolean isFinished(){
        if(timer.get() >= 0.3){
            timer.stop();
            timer.reset();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){}
    
    protected void interrupted(){}
}

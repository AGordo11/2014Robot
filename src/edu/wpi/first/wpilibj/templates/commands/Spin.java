package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.Global;

public class Spin extends CommandBase{
    Timer timer;
    
    public Spin(){
        requires(dr);
        timer = new Timer();
    }

    protected void initialize(){
        timer.start();
    }

    protected void execute(){
        if(Global.isRight){
            dr.TankDrive(-1.0, -1.0);
        }else{
            dr.TankDrive(1.0, 1.0);
        }
    }

    protected boolean isFinished(){
        if(timer.get() >= 0.1){
            timer.stop();
            timer.reset();
            dr.Stop();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){}
    
    protected void interrupted(){
        timer.stop();
        timer.reset();
        dr.Stop();
    }
}

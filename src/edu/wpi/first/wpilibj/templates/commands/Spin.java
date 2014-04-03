package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

public class Spin extends CommandBase{
    Timer timer;
    boolean right;
    
    public Spin(boolean rig){
        requires(dr);
        timer = new Timer();
        right = rig;
    }

    protected void initialize(){
        timer.start();
    }

    protected void execute(){
        if(right){
            dr.TankDrive(-1.0, 1.0);//Spins right
        }else{
            dr.TankDrive(1.0, -1.0);//Spins left
        }
    }

    protected boolean isFinished(){
        if(timer.get() >= 0.2){
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

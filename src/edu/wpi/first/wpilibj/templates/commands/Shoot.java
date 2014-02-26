package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;

public class Shoot extends CommandBase{
    Timer timer;
    
    public Shoot(){
        requires(sh);
        timer = new Timer();
    }

    protected void initialize(){
        if(Global.isRetract){
            sh.Shoot();
            Global.msg = "Shooting...";
        }else{
            Global.error = "Not retracted";
        }
        timer.start();
        sh.Shoot();
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(!sh.getSensor() || timer.get() >= 2){
            sh.Stop();
            Global.isRetract = false;
            timer.stop();
            timer.reset();
            return true;
        }else{
            return true;
        }
    }

    protected void end(){}

    protected void interrupted(){
        sh.Stop();
        timer.stop();
        timer.reset();
    }
}

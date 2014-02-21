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
        /*if(Global.isRetract){
            sh.Shoot();
            Global.msg = "Shooting...";
        }else{
            sh.Stop();
            Global.error = "Not retracted";
        }*/
        timer.start();
        sh.Shoot();
    }

    protected void execute(){}

    protected boolean isFinished(){
        /*if(sh.getSensor()){
            return false;
        }else{
            sh.Stop();
            Global.isRetract = false;
            return true;
        }*/
        if(timer.get() >= 1){
            sh.Stop();
            Global.isRetract = false;
            return true;
        }else{
            return false;
        }
    }

    protected void end(){}

    protected void interrupted(){
        sh.Stop();
    }
}

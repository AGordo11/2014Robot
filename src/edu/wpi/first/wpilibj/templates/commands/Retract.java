package edu.wpi.first.wpilibj.templates.commands;

//As long as the auto command or button is held down, arm will retract until the 
//limit switch has been tripped

import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;

public class Retract extends CommandBase{
    Timer timer;
    
    public Retract(){
        requires(sh);
        timer = new Timer();
    }

    protected void initialize(){
        timer.start();
        if(!Global.isRetract){
            sh.Shoot(-1.0);
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(Global.isRetract){
            sh.Stop();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){
        sh.Stop();
        timer.stop();
        timer.reset();
    }

    protected void interrupted(){
        sh.Stop();
        timer.stop();
        timer.reset();
    }
}

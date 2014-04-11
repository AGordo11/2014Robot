package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.Global;

public class Shoot extends CommandBase{
    Timer timer = new Timer();
    
    public Shoot(){
        requires(sh);
    }

    protected void initialize(){
        if(Global.isAction){
            in.StartConfiguration();
        }else{
            timer.start();
            if(Global.isRetract){
                in.OpenIntake();
                while(timer.get() <= 0.2){}
                timer.reset();
                sh.Shoot(-1.0);
            }
        }
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(timer.get() >= 0.5){
            sh.Stop();
            Global.isRetract = false;
            timer.reset();
            while(timer.get() <= 0.2){}
            in.StartConfiguration();
            timer.stop();
            timer.reset();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){}

    protected void interrupted(){
        sh.Stop();
        in.StartConfiguration();
        timer.stop();
        timer.reset();
    }
}

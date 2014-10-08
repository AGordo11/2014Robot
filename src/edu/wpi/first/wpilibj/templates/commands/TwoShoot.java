package edu.wpi.first.wpilibj.templates.commands;

//A specialized shooting for two-ball auto so that the second ball can still be 
//held while the first retracted ball shoots

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.Global;

public class TwoShoot extends CommandBase{
    Timer timer = new Timer();
    
    public TwoShoot(){
        requires(sh);
    }

    protected void initialize(){
        timer.start();
        sh.Shoot(-1.0);
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(timer.get() >= 0.5){
            sh.Stop();
            Global.isRetract = false;
            timer.reset();
            while(timer.get() <= 0.2){}
            in.ActEars();
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
        timer.stop();
        timer.reset();
    }
}

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;

public class EncoderTest extends CommandBase{
    Timer timer;
    
    public EncoderTest(){
        requires(dr);
        timer = new Timer();
    }

    protected void initialize(){
        dr.Move(-0.40, 0.40);
        timer.start();
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(Global.travelled >= 250 || timer.get() >= 8){//When the robot goes 250 inches, stop it
            dr.Stop();
            timer.stop();
            timer.reset();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){
        dr.Stop();
    }

    protected void interrupted(){}
}

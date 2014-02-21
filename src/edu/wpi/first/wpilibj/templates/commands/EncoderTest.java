package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

public class EncoderTest extends CommandBase{
    Timer timer;
    
    public EncoderTest(){
        requires(dr);
        timer = new Timer();
    }

    protected void initialize(){
        dr.Move(-0.40, 0.40);
        dr.ResetEncoders();
        timer.start();
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(dr.getRightEnc() >= 100 || timer.get() >= 5){//When the robot goes 1000(?) inches, stop it
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

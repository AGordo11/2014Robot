package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

public class GoForward extends CommandBase{
    public static final double maxDeviation = 3;
    int inches;
    
    Timer timer;
    
    public GoForward(int inch){
        requires(dr);
        inches = inch;
        timer = new Timer();
    }

    protected void initialize(){
        dr.ResetEncoders();
        timer.start();
    }

    protected void execute(){
        if(inches > 0){
            dr.SetRange(0.5, 1.0);
            if(dr.getTravelled() > inches){
                dr.SetRange(-1.0, 1.0);
            }
        }else if(inches < 0){
            dr.SetRange(-1.0, -0.5);
            if(dr.getTravelled() > inches){
                dr.SetRange(-1.0, 1.0);
            }
        }else{
            dr.SetRange(-1.0, 1.0);
        }
        dr.Go(inches);
    }

    protected boolean isFinished(){
        if((dr.getTravelled() - inches) < maxDeviation || timer.get() >= 4){
            timer.stop();
            timer.reset();
            dr.pid.disable();
            dr.Stop();
            dr.SetRange(-1.0, 1.0);
            return true;
        }else{
            return false;
        }
    }

    protected void end(){}
    
    protected void interrupted(){
        //dr.pid.disable();
        dr.Stop();
    }
}

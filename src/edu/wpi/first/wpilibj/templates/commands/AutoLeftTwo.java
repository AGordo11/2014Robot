package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeftTwo extends CommandGroup{
    Timer timer = new Timer();
    
    public AutoLeftTwo(){
        timer.start();
        
        addSequential(new Rotate(2));
        addSequential(new LowGear());
        addSequential(new WhereHot());
        addParallel(new Retract());
        addSequential(new GoForward(40));
        if(Global.isRight){
            addSequential(new Spin());
            addSequential(new Shoot());
        }else{
            addSequential(new Shoot());
        }
        addParallel(new Retract());
        addSequential(new GoForward(-30));
        if(Global.isRight){
            Global.isRight = false;
        }else{
            Global.isRight = true;
        }
        addSequential(new Spin());
        addSequential(new GoForward(-40));
        addSequential(new Shoot());
        
        timer.stop();
        timer.reset();
    }
}

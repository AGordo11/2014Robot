package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoLeft extends CommandGroup{
    Timer timer = new Timer();
    
    public AutoLeft(){
        timer.start();
        
        addSequential(new LowGear());
        addSequential(new WhereHot());
        while(Global.isRight && timer.get() <= 5){
            Global.msg = "Waiting";
        }
        addSequential(new Shoot());
        addParallel(new GoForward(50));
        addSequential(new Retract());
        
        timer.stop();
        timer.reset();
    }
}

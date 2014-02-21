package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoCenter extends CommandGroup{
    
    public AutoCenter(){
        addSequential(new LowGear());
        addSequential(new WhereHot());
        addSequential(new GoForward(10));
        addSequential(new Spin());
        //addSequential(new Shoot());
        Global.isRight = !Global.isRight;
        addSequential(new Spin());
        addParallel(new GoForward(40));
        //addSequential(new Retract());
    }
}

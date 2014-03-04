package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoRight extends CommandGroup{
    
    public AutoRight(){
        addSequential(new LowGear());
        addSequential(new WhereHot());
        addParallel(new Retract());
        addSequential(new GoForward(35));
        addSequential(new WaitForChildren());
        if(!Global.isHot){
            addSequential(new WaitCommand(5.0));
            Global.msg = "Waiting";
        }
        addSequential(new Shoot());
        addSequential(new WaitCommand(1.0));
        addParallel(new GoForward(50));
        addSequential(new Retract());
    }
}

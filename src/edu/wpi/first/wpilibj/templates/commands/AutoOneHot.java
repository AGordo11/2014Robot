package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class AutoOneHot extends CommandGroup{
    
    public AutoOneHot(){
        addParallel(new Ears());
        addSequential(new Retract());
        addSequential(new WaitForChildren());
        addSequential(new GoForward(75));
        addSequential(new WaitCommand(1.0));
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addParallel(new Retract());
        addSequential(new GoForward(65));
    }
}

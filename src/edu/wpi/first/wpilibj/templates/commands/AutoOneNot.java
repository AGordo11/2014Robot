package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class AutoOneNot extends CommandGroup{
    
    public AutoOneNot(){
        addParallel(new Ears());
        addSequential(new Retract());
        addSequential(new WaitForChildren());
        addSequential(new GoForward(30));
        addSequential(new WaitCommand(6.0));
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addParallel(new Retract());
        addSequential(new GoForward(65));
    }
}

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNone extends CommandGroup{
    
    public AutoNone() {
        addParallel(new GoForward(60));
        addSequential(new Retract());
    }
}

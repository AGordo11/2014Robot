package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNone extends CommandGroup{
    
    public AutoNone() {
        addSequential(new GoForward(75));
        addSequential(new Retract());
    }
}

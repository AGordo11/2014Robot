package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStart extends CommandGroup{
    
    public AutoStart(){
        addSequential(new WhereHot());
    }
}

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CWhereHot extends CommandGroup{
    
    public CWhereHot(){
        addSequential(new WhereHot());
    }
}

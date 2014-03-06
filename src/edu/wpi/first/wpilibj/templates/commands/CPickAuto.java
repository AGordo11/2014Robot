package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CPickAuto extends CommandGroup{
    
    public CPickAuto(int num){
        addSequential(new PickAuto(num));
    }
}

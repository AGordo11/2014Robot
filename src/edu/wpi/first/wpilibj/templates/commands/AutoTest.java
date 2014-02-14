package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTest extends CommandGroup {
    
    public AutoTest(){
        addSequential(new WhereHot());
        addSequential(new Spin());
    }
}

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoTest extends CommandGroup{
    
    public AutoTest(){
        addParallel(new GoForward(55));
        addSequential(new Retract());
        addSequential(new WaitCommand(1.0));
        addSequential(new Shoot());
    }
}

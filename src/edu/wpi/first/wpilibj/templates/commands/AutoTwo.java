package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoTwo extends CommandGroup{
 
    public AutoTwo(){
        addParallel(new Retract());
        addSequential(new OpenIntake());
        addSequential(new WaitForChildren());
        addSequential(new OpenIntake());
        addSequential(new WhereHot());
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new OpenIntake());
        addSequential(new WaitForChildren());
        addSequential(new OpenIntake());
        addSequential(new RunIntake());
        addSequential(new WaitCommand(1.0));
        addSequential(new RunIntake());
        addSequential(new WaitCommand(1.0));
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new GoForward(120));
    }
}

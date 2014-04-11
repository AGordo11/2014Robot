package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class AutoTwo extends CommandGroup{
 
    public AutoTwo(){
        addSequential(new OpenIntake());
        addParallel(new QuickPickup());
        addSequential(new Retract());
        addSequential(new ActEars());
        addSequential(new GoForward(40));
        addSequential(new ActEars());
        addSequential(new TwoShoot());
        addSequential(new Retract());
        addSequential(new MedPickup());
        addSequential(new RunIntake());
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new GoForward(40));
        addSequential(new StartConfiguration());
    }
}

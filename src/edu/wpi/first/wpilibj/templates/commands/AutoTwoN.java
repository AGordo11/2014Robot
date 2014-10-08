package edu.wpi.first.wpilibj.templates.commands;

//Shoots two balls in autonomous, one hot, one not (both on same side)

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoTwoN extends CommandGroup{
 
    public AutoTwoN(){
        addSequential(new OpenIntake());
        addParallel(new QuickPickup());
        addSequential(new Retract());
        addSequential(new ActEars());
        addSequential(new GoForward(45));
        addSequential(new ActEars());
        addSequential(new WaitCommand(0.5));
        addSequential(new TwoShoot());
        addSequential(new Retract());
        addSequential(new MedPickup());
        addSequential(new RunIntake());
        addSequential(new WaitCommand(0.4));
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new StartConfiguration());
    }
}

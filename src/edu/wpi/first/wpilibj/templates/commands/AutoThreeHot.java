package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoThreeHot extends CommandGroup{
    
    public AutoThreeHot(){
        addSequential(new RunIntake());
        addSequential(new Ears());
        addParallel(new Retract());
        addSequential(new Rotate(2));
        addSequential(new WaitCommand(0.2));
        addSequential(new RunIntake());
        addSequential(new GoForward(75));
        addSequential(new Ears());
        addSequential(new Shoot());
        addSequential(new Retract());
        addSequential(new RunIntake());
        addSequential(new Rotate(1));
        addSequential(new WaitCommand(0.3));
        addSequential(new RunIntake());
        addParallel(new Rotate(2));
        addSequential(new Shoot());
        //addSequential(new );
    }
}

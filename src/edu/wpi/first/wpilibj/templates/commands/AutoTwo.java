package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoTwo extends CommandGroup{
 
    public AutoTwo(){
        addSequential(new Ears());
        addParallel(new Retract());
        addSequential(new WaitCommand(1.0));
        addSequential(new RunIntake());
        addParallel(new GoForward(-10));
        addSequential(new Rotate(2));
        addSequential(new RunIntake());
        addSequential(new GoForward(70));
        addSequential(new Ears());
        //addSequential(new Spin(true));
        addSequential(new Shoot());
        addSequential(new Retract());
        addSequential(new RunIntake());
        addSequential(new WaitCommand(0.5));
        addSequential(new Rotate(0));
        addSequential(new WaitCommand(0.3));
        addParallel(new Rotate(2));
        addSequential(new RunIntake());
        addSequential(new WaitCommand(0.2));
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new GoForward(30));
    }
}

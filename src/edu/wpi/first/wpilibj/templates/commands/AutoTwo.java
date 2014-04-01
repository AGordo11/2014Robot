package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoTwo extends CommandGroup{
 
    public AutoTwo(){
        addSequential(new ActEars());
        addParallel(new Retract());
        addSequential(new WaitCommand(1.0));
        addSequential(new RunIntake());
        addParallel(new GoForward(-10));
        addSequential(new RunIntake());
        addSequential(new GoForward(70));
        addSequential(new ActEars());
        //addSequential(new Spin(true));
        addSequential(new Shoot());
        addSequential(new Retract());
        addSequential(new RunIntake());
        addSequential(new WaitCommand(0.5));
        addSequential(new WaitCommand(0.3));
        addSequential(new RunIntake());
        addSequential(new WaitCommand(0.2));
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new GoForward(30));
    }
}

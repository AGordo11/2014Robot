package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class AutoTwoLHot extends CommandGroup{
    
    public AutoTwoLHot(){
        /*addSequential(new RunIntake());
        addSequential(new Rotate(2));
        addSequential(new Ears());
        addSequential(new Retract());
        addSequential(new GoForward(30));
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addParallel(new Retract());
        addSequential(new Spin(true));
        addSequential(new WaitForChildren());
        addSequential(new Rotate(1));
        addSequential(new WaitCommand(1.0));
        addSequential(new Rotate(2));
        addSequential(new RunIntake());
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new GoForward(65));*/
        addSequential(new RunIntake());
        addParallel(new Retract());
        addSequential(new Rotate(2));
        addSequential(new Ears());
        addSequential(new GoForward(75));
        addSequential(new Shoot());
        addSequential(new Retract());
        addSequential(new Rotate(1));
        addSequential(new WaitCommand(0.5));
        addSequential(new Shoot());
    }
}

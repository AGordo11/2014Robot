package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoTwoR extends CommandGroup{
 
    public AutoTwoR(){
        addParallel(new Retract());
        addSequential(new OpenIntake());
        addSequential(new WaitForChildren());
        addSequential(new OpenIntake());
        addSequential(new WhereHot());
        if(!Global.isHot){
            addSequential(new Spin(false));
        }
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new OpenIntake());
        addSequential(new WaitForChildren());
        addSequential(new OpenIntake());
        addSequential(new RunIntake());
        addSequential(new WaitCommand(1.0));
        addSequential(new RunIntake());
        addSequential(new WaitCommand(1.0));
        addSequential(new Spin(true));
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new GoForward(120));
    }
}

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
        if(!Global.isHot){
            addSequential(new Spin(true));
        }else{
            addSequential(new Spin(false));
        }
        //addParallel(new GoForward(10));
        addSequential(new Shoot());
        addParallel(new Retract());
        if(Global.isHot){
            addSequential(new Spin(true));
        }
        addSequential(new GoForward(80));
    }
}

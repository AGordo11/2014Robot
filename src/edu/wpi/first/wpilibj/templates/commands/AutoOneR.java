package edu.wpi.first.wpilibj.templates.commands;

//One-ball autonomous, delays if not hot on right side

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoOneR extends CommandGroup{
    
    public AutoOneR(){
        /*addParallel(new Retract());
        addSequential(new OpenIntake());
        addSequential(new WaitForChildren());
        addSequential(new OpenIntake());
        addSequential(new GoForward(45));
        if(!Global.isHotRight){
            addSequential(new WaitCommand(3.0));
        }
        addSequential(new WaitCommand(1.0));
        addSequential(new Shoot());
        addParallel(new Retract());*/
        addParallel(new OpenIntake());
        addSequential(new Retract());
        addSequential(new ActEars());
        addSequential(new GoForward(45));
        addSequential(new ActEars());
        if(!Global.isHotRight){
            addSequential(new WaitCommand(3.0));
        }
        addSequential(new WaitCommand(0.5));
        addSequential(new TwoShoot());
        addParallel(new Retract());
        addSequential(new WaitCommand(0.5));
        addSequential(new StartConfiguration());
    }
}

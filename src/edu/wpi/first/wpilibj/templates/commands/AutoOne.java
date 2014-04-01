package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoOne extends CommandGroup{
    
    public AutoOne(){
        addParallel(new ActEars());
        addSequential(new Retract());
        addSequential(new WhereHot());
        addSequential(new GoForward(70));
        addSequential(new ActEars());
        if(Global.isHot){
            addSequential(new WaitCommand(1.0));
        }else{
            addSequential(new WaitCommand(4.0));
        }
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addParallel(new Retract());
        addSequential(new GoForward(65));
    }
}

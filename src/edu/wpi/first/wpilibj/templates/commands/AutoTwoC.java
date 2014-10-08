package edu.wpi.first.wpilibj.templates.commands;

//Two-ball autonomous, inclines to hot side and shoots, then picks up ball, 
//inclines the other way and shoots on the other side for two hot shots

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.command.WaitForChildren;

public class AutoTwoC extends CommandGroup{
 
    public AutoTwoC(){
        addSequential(new OpenIntake());
        addParallel(new QuickPickup());
        addSequential(new Retract());
        addSequential(new ActEars());
        addSequential(new GoForward(45));
        if(Global.isHotRight){
            addSequential(new Spin(true));
        }else{
            addSequential(new Spin(false));
        }
        addSequential(new ActEars());
        addSequential(new WaitCommand(0.5));
        addSequential(new TwoShoot());
        addParallel(new Retract());
        if(Global.isHotRight){
            addSequential(new Spin(false));
        }else{
            addSequential(new Spin(true));
        }
        addSequential(new WaitForChildren());
        addSequential(new MedPickup());
        addSequential(new RunIntake());
        if(Global.isHotRight){
            addSequential(new Spin(true));
        }else{
            addSequential(new Spin(false));
        }
        addSequential(new WaitCommand(0.4));
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new StartConfiguration());
    }
}

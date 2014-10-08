package edu.wpi.first.wpilibj.templates.commands;

//Initializes such things as OI, Intake and Drive subsystems--every subsystem
//needs to be called here first

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;

public abstract class CommandBase extends Command{
    public static OI oi;
    public static AirCompressor co = new AirCompressor();
    public static Drive dr = new Drive();
    public static Intake in = new Intake();
    public static SDUpdater sd = new SDUpdater();
    public static Shooter sh = new Shooter();

    public static void init(){
        oi = new OI();
    }

    public CommandBase(String name){
        super(name);
    }

    public CommandBase(){
        super();
    }
}

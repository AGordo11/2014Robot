package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.*;

public class SDUpdater extends Subsystem{
    //Only serves to update SmartDashboard live
    public void initDefaultCommand(){
        setDefaultCommand(new SDUpdate());
    }
}
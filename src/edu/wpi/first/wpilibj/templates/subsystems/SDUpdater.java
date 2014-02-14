package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.SDUpdate;

public class SDUpdater extends Subsystem{

    public void initDefaultCommand(){
        setDefaultCommand(new SDUpdate());
    }
}
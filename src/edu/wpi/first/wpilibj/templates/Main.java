package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.templates.commands.*;

public class Main extends IterativeRobot{
    Command autoCom;
    Command comp;

    public void robotInit(){    
        comp = new CompressorStart();
        autoCom = new AutoTest();
                
        CommandBase.init();
    }

    public void autonomousInit(){
        Global.isPrac = SmartDashboard.getBoolean("Practice Robot? ");
        autoCom.start();
    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        autoCom.cancel();
        comp.start();
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();
    }

    public void testPeriodic(){
        LiveWindow.run();
    }
}

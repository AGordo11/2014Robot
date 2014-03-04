package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.Global;

public class Main extends IterativeRobot{
    Command autoCom;
    Command comp;
    Command reset;
    Command gears;
    SendableChooser sen;

    public void robotInit(){    
        comp = new CompressorStart();
        reset = new ResetEncoders();
        gears = new LowGear();
        sen = new SendableChooser();
        autoCom = new AutoTest();
        
        sen.addDefault("Test Auto", new AutoTest());
        sen.addObject("One Ball Left", new AutoLeft());
        sen.addObject("One Ball Right", new AutoRight());
        SmartDashboard.putData("Autonomous Command ", sen);

        CommandBase.init();
    }

    public void autonomousInit(){
        autoCom = (Command)sen.getSelected();
        reset.start();
        gears.start();
        autoCom.start();
    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        autoCom.cancel();
        comp.start();
        reset.start();
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();
    }

    public void testPeriodic(){
        LiveWindow.run();
    }
}

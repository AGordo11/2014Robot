package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.*;

public class Main extends IterativeRobot{
    Command autoCom, comp, reset, start;
    DriverStation ds;

    public void robotInit(){
        ds = DriverStation.getInstance();
        comp = new CompressorStart();
        reset = new ResetEncoders();
        autoCom = new AutoOne();
        start = new StartConfiguration();

        CommandBase.init();
    }

    public void autonomousInit(){
        Global.isRetract = false;
        if(ds.getDigitalIn(1)){
            autoCom = new AutoOne();
        }else if(ds.getDigitalIn(2)){
            autoCom = new AutoTwo();
        }else if(ds.getDigitalIn(4)){
            autoCom = new AutoTwoL();
        }else if(ds.getDigitalIn(5)){
            autoCom = new AutoTwoR();
        }else if(ds.getDigitalIn(6)){
            autoCom = new AutoTest();
        }else if(ds.getDigitalIn(7)){
            autoCom = new AutoNone();
        }else if(ds.getDigitalIn(8)){
            autoCom = new WhereHot();
        }else{
            autoCom = new AutoOne();
        }
        reset.start();
        autoCom.start();
    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        autoCom.cancel();
        comp.start();
        reset.start();
        start.start();
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();
    }

    public void testPeriodic(){
        LiveWindow.run();
    }
}

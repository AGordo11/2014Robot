package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;

public class Main extends IterativeRobot{
    Command autoCom, comp, reset, strt;
    DriverStation ds;

    public void robotInit(){
        ds = DriverStation.getInstance();
        comp = new CompressorStart();
        reset = new ResetEncoders();
        autoCom = new AutoOneNot();
        strt = new AutoStart();

        CommandBase.init();
    }

    public void autonomousInit(){
        strt.start();
        Global.isRetract = false;
        if(ds.getDigitalIn(1)){
            if(Global.isHot){
                autoCom = new AutoOneHot();
            }else{
                autoCom = new AutoOneNot();
            }
        }else if(ds.getDigitalIn(2)){
            if(Global.isHot){
                autoCom = new AutoTwoLHot();
            }else{
                autoCom = new AutoTwoLNot();
            }
        }else if(ds.getDigitalIn(3)){
            if(Global.isHot){
                autoCom = new AutoTwoRHot();
            }else{
                autoCom = new AutoTwoRNot();
            }
        }else if(ds.getDigitalIn(4)){
            if(Global.isHot){
                autoCom = new AutoThreeHot();
            }else{
                autoCom = new AutoThreeNot();
            }
        }else{
            autoCom = new AutoOneHot();
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
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();
    }

    public void testPeriodic(){
        LiveWindow.run();
    }
}

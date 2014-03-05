package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.templates.commands.AutoTwoLHot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;

public class Main extends IterativeRobot{
    Command autoCom, comp, reset, gears, temp;
    SendableChooser sen;

    public void robotInit(){    
        comp = new CompressorStart();
        reset = new ResetEncoders();
        gears = new LowGear();
        temp = new PickAuto(0);
        sen = new SendableChooser();
        autoCom = new AutoOneNot();
        
        sen.addDefault("One Ball", new PickAuto(0));
        sen.addObject("Two Balls Left", new PickAuto(1));
        sen.addObject("Two Balls Right", new PickAuto(2));
        sen.addObject("Three Balls (On Left)", new PickAuto(3));
        SmartDashboard.putData("Autonomous Command ", sen);

        CommandBase.init();
    }

    public void autonomousInit(){
        temp = (Command)sen.getSelected();
        temp.start();
        Timer.delay(0.3);
        if(Global.isRetract){
            Global.isRetract = false;
        }
        if(Global.autoPick == 0){
            if(Global.isHot){
                autoCom = new AutoOneHot();
            }else{
                autoCom = new AutoOneNot();
            }
        }else if(Global.autoPick == 1){
            if(Global.isHot){
                autoCom = new AutoTwoLHot();
            }else{
                autoCom = new AutoTwoLNot();
            }
        }else if(Global.autoPick == 2){
            if(Global.isHot){
                autoCom = new AutoTwoRHot();
            }else{
                autoCom = new AutoTwoRNot();
            }
        }else if(Global.autoPick == 3){
            if(Global.isHot){
                autoCom = new AutoThreeHot();
            }else{
                autoCom = new AutoThreeNot();
            }
        }else{
            autoCom = new AutoOneNot();
        }
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

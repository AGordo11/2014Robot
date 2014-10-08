package edu.wpi.first.wpilibj.templates;

//Where it all begins

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.*;

public class Main extends IterativeRobot{
    CheesyVisionServer serv;
    Command autoCom, comp, reset, start;
    DriverStation ds;
    
    public final int listenPort = 1180;
    
    public void robotInit(){
        //Initiates starting commands
        serv = CheesyVisionServer.GetInstance();
        ds = DriverStation.getInstance();
        comp = new CompressorStart();
        reset = new ResetEncoders();
        autoCom = new AutoOneR();
        start = new StartConfiguration();
        
        serv.SetPort(listenPort);
        serv.Start();

        CommandBase.init();
    }

    public void autonomousInit(){
        serv.Reset();
        serv.StartSamplingCounts();
        Global.isRetract = false;
        
        //Picks an auto command based on the DI input on the DS (DriverStation)
        if(ds.getDigitalIn(1)){
            autoCom = new AutoOneL();
        }else if(ds.getDigitalIn(2)){
            autoCom = new AutoTwoC();
        }else if(ds.getDigitalIn(3)){
            autoCom = new AutoOneR();
        }else if(ds.getDigitalIn(4)){
            autoCom = new AutoTwoN();
        }else if(ds.getDigitalIn(7)){
            autoCom = new AutoTest();
        }else if(ds.getDigitalIn(8)){
            autoCom = new AutoNone();
        }else{
            autoCom = new AutoOneR();//If a DI isn't pushed on the DS, robot automatically shoots one as if it was on the right
        }
        reset.start();
        autoCom.start();
    }
    
    public void disabledInit(){
        serv.StopSamplingCounts();
    }

    public void autonomousPeriodic(){
        Global.isHotRight = serv.getRightStatus();     
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        //Stops the auto command when teleop initializes
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

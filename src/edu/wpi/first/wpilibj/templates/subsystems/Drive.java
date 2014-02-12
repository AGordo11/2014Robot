package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.templates.commands.*;

public class Drive extends PIDSubsystem{
    public static final double P = 0;
    public static final double I = 0;
    public static final double D = 0;
    public static final double pulseDistance = 0.0238817285;
    
    Encoder lEnc, rEnc;
    RobotDrive drive;
    Solenoid gearSol;
    Talon lTal, rTal;
    
    public PIDController pid;
    private PIDOutput output = new PIDOutput(){
        public void pidWrite(double output){
            drive.tankDrive(output, output);
        }
    };
    private PIDSource source = new PIDSource(){
        public double pidGet(){
            return getTravelled();
        }
    };

    public Drive(){       
        super("Drive", P, I, D);
        
        lTal = new Talon(RobotMap.Left_Talon);
        rTal = new Talon(RobotMap.Right_Talon);
        LiveWindow.addActuator("Drive", "Left Motor", lTal);
        LiveWindow.addActuator("Drive", "Right Motor", rTal);
        
        lEnc = new Encoder(RobotMap.Left_EncoderA, RobotMap.Left_EncoderB, false, CounterBase.EncodingType.k4X);
        rEnc = new Encoder(RobotMap.Right_EncoderA, RobotMap.Right_EncoderB, false, CounterBase.EncodingType.k4X);
        lEnc.start();
        rEnc.start();
        LiveWindow.addSensor("Drive", "Left Encoder", lEnc);
        LiveWindow.addSensor("Drive", "Right Encoder", rEnc);
        
        drive = new RobotDrive(lTal, rTal);
        drive.setSafetyEnabled(false);
        
        pid = new PIDController(P, I, D, source, output);
        LiveWindow.addActuator("Drive", "PID", pid);
        
        gearSol = new Solenoid(RobotMap.Gear_Solenoid);
        LiveWindow.addActuator("Drive", "Gear Solenoid", gearSol);
    }
       
    protected void usePIDOutput(double output){}
    
    public void ChangeGearsHigh(boolean highGear){
        if(!highGear()){
            gearSol.set(false);//If gear solenoid is low, set to high
        }else{
            gearSol.set(true);//If gear solenoid is high, set to false
        }
    }
    
    public void DriveJoysticks(Joystick lStick, Joystick rStick){
        drive.tankDrive(lStick, rStick);
    }
    
    public void Go(int inches){
        pid.setSetpoint(inches);
        pid.enable();
    }
        
    public void initDefaultCommand(){
        setDefaultCommand(new JoystickDrive());
    }
    
    public void ResetEncoders(){
        lEnc.reset();
        rEnc.reset();
    }
    
    public void SetRange(double min, double max){
        pid.setOutputRange(min, max);
    }
    
    public void Stop(){
        drive.tankDrive(0, 0);
    }
        
    public void TankDrive(double lOut, double rOut){
        drive.tankDrive(lOut, rOut);
    }
    
    public boolean highGear(){//Returns high as true
        return !gearSol.get();
    }
        
    public double getLeftEnc(){
        return lEnc.get();
    }
    
    public double getLeftMotor(){
        return lTal.get();
    }
    
    public double getRightEnc(){
        return rEnc.get();
    }
    
    public double getRightMotor(){
        return rTal.get();
    }
    
    public double getTravelled(){
        return lEnc.getDistance();
    }
    
    protected double returnPIDInput() {
        return 0.0;
    }
}
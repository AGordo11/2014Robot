package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.commands.*;
//126 hours logged
public class OI{
    Joystick lStick, rStick, sStick;
    JoystickButton lTrig,
            rTrig, rBut4, rBut5,
            sTrig;
    RobotDrive drive;
    
    public OI(){
        lStick = new Joystick(RobotMap.Left_Joystick);
        lTrig = new JoystickButton(lStick, 1);
        
        rStick = new Joystick(RobotMap.Right_Joystick);
        rTrig = new JoystickButton(rStick, 1);
        
        sStick = new Joystick(RobotMap.Shooter_Joystick);
        sTrig = new JoystickButton(sStick, 1);
        
        lTrig.whenPressed(new ChangeGears());
        
        //rBut4.whenPressed(new Spin(false));
        //rBut5.whenPressed(new Spin(true));   
    }
    
    public Joystick getLeftStick(){
        return lStick;
    }
    
    public double getLeftThrottle(){
        return -1 * lStick.getZ();
    }
    
    public Joystick getRightStick(){
        return rStick;
    }
    
    public double getRightThrottle(){
        return -1 * rStick.getZ();
    }
    
    public Joystick getShooterStick(){
        return sStick;
    }
    
    public double getShooterThrottle(){
        return -1 * sStick.getThrottle();
    }
}


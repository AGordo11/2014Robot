package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;
//140 hours logged
public class OI{
    Joystick lStick, rStick, sStick;
    JoystickButton lTrig, lBut2,
            rTrig,
            sTrig, sBut2, sBut3, sBut5;
    
    public OI(){
        lStick = new Joystick(RobotMap.Left_Joystick);
        lTrig = new JoystickButton(lStick, 1);
        lBut2 = new JoystickButton(lStick, 2);
        
        rStick = new Joystick(RobotMap.Right_Joystick);
        rTrig = new JoystickButton(rStick, 1);
        
        sStick = new Joystick(RobotMap.Shooter_Joystick);
        sBut2 = new JoystickButton(sStick, 2);
        sBut3 = new JoystickButton(sStick, 3);
        sBut5 = new JoystickButton(sStick, 5);
        
        lTrig.whenPressed(new ChangeGears());
        lBut2.whenPressed(new ResetEncoders());
        
        rTrig.whenPressed(new EncoderTest());
        
        sBut2.whileHeld(new RetractAntlers());
        sBut3.whileHeld(new RunSpittake());
        sBut5.whileHeld(new RunIntake());
    }
    
    public Joystick getLeftStick(){
        return lStick;
    }
    
    public Joystick getRightStick(){
        return rStick;
    }
    
    public Joystick getShooterStick(){
        return sStick;
    }
    
    public double getShooterThrottle(){
        return (-sStick.getThrottle() + 1) / 2;
    }
    
    public double getShooterY(){
        return sStick.getY();
    }
}


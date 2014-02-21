package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;
//175 hours logged
public class OI{
    Joystick lStick, rStick, sStick;
    JoystickButton lTrig, lBut2,
            rTrig,
            sTrig, sBut2, sBut3, sBut4, sBut5, sBut6;
    
    public OI(){
        lStick = new Joystick(RobotMap.Left_Joystick);
        lTrig = new JoystickButton(lStick, 1);
        lBut2 = new JoystickButton(lStick, 2);
        
        rStick = new Joystick(RobotMap.Right_Joystick);
        rTrig = new JoystickButton(rStick, 1);
        
        sStick = new Joystick(RobotMap.Shooter_Joystick);
        sTrig = new JoystickButton(sStick, 1);
        sBut2 = new JoystickButton(sStick, 2);
        sBut3 = new JoystickButton(sStick, 3);
        sBut4 = new JoystickButton(sStick, 4);
        sBut5 = new JoystickButton(sStick, 5);
        sBut6 = new JoystickButton(sStick, 6);
        
        lTrig.whenPressed(new ChangeGears());
        lBut2.whenPressed(new ResetEncoders());
        
        rTrig.whenPressed(new EncoderTest());
        
        sTrig.whenPressed(new Shoot());
        sBut2.whileHeld(new Retract());
        sBut3.whenPressed(new RunSpittake());
        sBut4.whenPressed(new StopEverything());
        sBut5.whenPressed(new RunIntake());
        sBut6.whenPressed(new StopEverything());
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
    
    public double getShooterY(){
        return sStick.getY();
    }
}


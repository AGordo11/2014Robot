package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

public class OI{
    Joystick lStick, rStick, sStick;
    JoystickButton lTrig, lBut2,
            rTrig,
            sTrig, sBut2, sBut3, sBut4, sBut5, sBut6, sBut7, sBut8, sBut9, sBut10;
    
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
        sBut7 = new JoystickButton(sStick, 7);
        sBut8 = new JoystickButton(sStick, 8);
        sBut9 = new JoystickButton(sStick, 9);
        sBut10 = new JoystickButton(sStick, 10);
        
        lTrig.whenPressed(new ChangeGears());
        lBut2.whenPressed(new ResetEncoders());

        sTrig.whenPressed(new Shoot());
        sBut2.whileHeld(new Retract());
        sBut3.whenPressed(new RunSpittake());
        sBut4.whenPressed(new RetractChange());
        sBut5.whenPressed(new RunIntake());
        sBut6.whenPressed(new OpenIntake());
        sBut7.whenPressed(new ActEars());
        sBut8.whenPressed(new ActRollers());
        sBut9.whenPressed(new RunUpRollers());
        sBut10.whenPressed(new RunRollers());
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


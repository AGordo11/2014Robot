package edu.wpi.first.wpilibj.templates;

//Makes the pneumatics and intake talons all follow a I/O pattern
//These booleans allow for automatic commands like RunIntake and RunSpittake

public class Global{
    public static boolean isRetract = false;//Is the catapult retracted?
    public static boolean isRoller = false;
    public static boolean isUpRoller = false;
    public static boolean isActRoller = false;
    public static boolean isEars = false;
    public static boolean isAction = false;
    public static boolean isHotRight = false;
    public static boolean isBall = false;
}

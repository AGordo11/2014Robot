package edu.wpi.first.wpilibj.templates;

public class Global{
    public static final double rotIn = 4.000;//The values for the different rotator positions from 0.001 to 5.001
    public static final double rotUp = 2.500;
    public static final double rotOut = 0.300;
    public static boolean isRight = true;//Is the right side hot or not?
    public static boolean isRun;//Are the rollers running?
    public static boolean isRetract;//Is the catapult retracted?
    public static double crossX;//The X + Y value of the crosshair/hot side
    public static double crossY;
    public static String error = "";
    public static String msg = "Don't Panic!";
}

package edu.wpi.first.wpilibj.templates;

public class Global{
    public static final double rotIn = 4.000;//The values for the different rotator positions from 0.001 to 5.001
    public static final double rotUp = 2.500;
    public static final double rotOut = 0.300;
    public static boolean isHot;//Is the target side hot or not?
    public static boolean isRun;//Are the rollers running?
    public static boolean isRetract = false;//Is the catapult retracted?
    public static double boundX;//The X + Y value of the bounding rectangle/hot side
    public static double boundY;
    public static double boundX2;
    public static double boundY2;
    public static int autoPick;
    public static String error = "";
    public static String msg = "Don't Panic!";
}

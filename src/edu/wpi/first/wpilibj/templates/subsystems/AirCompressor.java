package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.Compressor;

public class AirCompressor extends Subsystem{
    Compressor comp;
    
    public AirCompressor(){
        comp = new Compressor(RobotMap.Compressor_DI, RobotMap.Compressor_Relay);
        comp.start();
    }

    public void initDefaultCommand(){}
    
    public void Start(){
        comp.start();
    }
    
    public void Stop(){
        comp.stop();
    }
}
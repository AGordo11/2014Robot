package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.templates.*;
import edu.wpi.first.wpilibj.Compressor;

public class AirCompressor extends Subsystem{
    Compressor comp;

    public void initDefaultCommand(){}

    public AirCompressor(){
        comp = new Compressor(RobotMap.Compressor_DI);
        comp.start();
    }
    
    public void StartCompressor(){
        comp.start();
    }
    
    public void StopCompressor(){
        comp.stop();
    }
}
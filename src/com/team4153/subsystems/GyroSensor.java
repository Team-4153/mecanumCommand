/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team4153.subsystems;

import com.team4153.RobotMap;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author 4153student
 */
public class GyroSensor extends Subsystem {
    private Gyro gyro;
    
    public GyroSensor() {
	gyro = new Gyro(RobotMap.GYRO_CHANNEL);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
	// Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
	
    }
    
    public double getAngle() {
	return gyro.getAngle();
    }
    
    public void reset(){
	gyro.reset();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team4153.subsystems;

import com.team4153.RobotMap;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Gyro subsystem.
 * 
 * @author 4153student
 */
public class GyroSensor extends Subsystem {

    private Gyro gyro;

    public GyroSensor() {
        super("GyroSensor");
        gyro = new Gyro(RobotMap.GYRO_CHANNEL);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }

    /**
     *
     * @return the current angle (degrees I think) integrated from the gyro
     */
    public double getAngle() {
        return gyro.getAngle();
    }
    

    public String toString() {
        return "GyroSensor{" + "gyro=" + gyro + '}';
    }

    /**
     * Reset the gyro integrator to zero.
     */
    public void reset() {
        gyro.reset();
        System.out.println("Gyro Reset");
    }

}

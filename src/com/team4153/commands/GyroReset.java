/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.team4153.commands;


/**
 *
 * @author Team4153
 */
public class GyroReset extends CommandBase {
    
    public GyroReset(){
        // need to require chassis so we get the "focus" in the scheduler since 
        // chassis has a default command DriveWithJoystick that requires it
        requires(chassis); 
        requires(gyroSensor);
    }
    
    protected void initialize() {
        gyroSensor.reset();
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
    
}

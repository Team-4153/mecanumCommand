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
        requires(chassis); // need to require chassis so we get the "focus" in the scheduler
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

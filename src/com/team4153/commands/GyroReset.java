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
        requires(gyroSensor);
    }
    
    protected void initialize() {
        System.out.println("Init");
    }

    protected void execute() {
        System.out.println("Execute");
        gyroSensor.reset();
    }

    protected boolean isFinished() {
        System.out.println("Finished");
        return true;
    }

    protected void end() {
        System.out.println("end");
        scheduler.add(new DriveWithJoystick());
    }

    protected void interrupted() {
        System.out.println("Interupted");
    }
    
    
    
}

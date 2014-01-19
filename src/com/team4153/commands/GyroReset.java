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
    private boolean isReset=false;
    
    private void dbg(String msg){
        System.out.println("GyroReset: " + msg);
    }
    
    public GyroReset(){
        // need to require chassis so we get the "focus" in the scheduler since 
        // chassis has a default command DriveWithJoystick that requires it
        requires(chassis); 
        requires(gyroSensor);
        dbg("const");
    }
    
    protected void initialize() {
        // do the command execution once (i.e one-shot)
        dbg("initialize");
        isReset = false;
        gyroSensor.reset();
        isReset = true;
    }

    protected void execute() {
        dbg("execute");
    }

    protected boolean isFinished() {
        dbg("isFinished=" + isReset);
        return isReset;
    }

    protected void end() {
        dbg("end");
    }

    protected void interrupted() {
        dbg("interrupted");
    }
    
    
    
}

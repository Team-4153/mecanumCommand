package com.team4153.commands;

import com.team4153.OI;

/**
 * Chassis drive command.
 *
 * @author kpt
 */
public class DriveWithJoystick extends CommandBase {

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        requires(gyroSensor);
        System.out.println("** DriveWithJoystick const");
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        chassis.mecanumDrive(oi.getJoystick(), gyroSensor.getAngle());
//        System.out.println("Gyro Angle: "+gyroSensor.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return !OI.getTriggerButton().get();
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        chassis.driveHalt();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("Driver Interrupted");
        end();
    }
}

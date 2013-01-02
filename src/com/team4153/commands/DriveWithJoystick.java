
package com.team4153.commands;

/**
 * Chassis drive command.
 * 
 * @author kpt
 */
public class DriveWithJoystick extends CommandBase {

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
	requires(chassis);
	requires(gyro);
	System.out.println("** DriveWithJoystick const");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	chassis.mecanumDrive(oi.getJoystick(), gyro.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
	return (!oi.getTriggerButton().get());
    }

    // Called once after isFinished returns true
    protected void end() {
	chassis.driveHalt();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
	end();
    }
}

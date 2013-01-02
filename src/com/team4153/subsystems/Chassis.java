
package com.team4153.subsystems;

import com.team4153.RobotMap;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Chassis subsystem for mecanum drive
 */
public class Chassis extends Subsystem {
    private RobotDrive drive;
    /**
     * Jaguar CAN bus motor controllers.
     */
    private CANJaguar rightFront;
    private CANJaguar rightRear;
    private CANJaguar leftFront;
    private CANJaguar leftRear;
    
    /**
     * 
     */
    public Chassis(){
	try {
	    rightFront = new CANJaguar(RobotMap.JAG_RIGHT_FRONT_MOTOR);
	    rightRear = new CANJaguar(RobotMap.JAG_RIGHT_REAR_MOTOR);
	    leftFront = new CANJaguar(RobotMap.JAG_LEFT_FRONT_MOTOR);
	    leftRear = new CANJaguar(RobotMap.JAG_LEFT_REAR_MOTOR);
	} catch (CANTimeoutException ex) {
	    System.out.println("Chassis constructor CANTimeoutException: " + ex.toString());
	    System.exit(-1);
	}
	drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
	drive.setSafetyEnabled(false);
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //eg: setDefaultCommand(new MySpecialCommand());
    }
   
	    
    /**
     * The command to drive mecanum via joystick and gyro angle
     * @param stick The driver's joystick (usually via OI)
     * @param heading The gyro angle/heading
     */
    public void mecanumDrive(Joystick stick, double heading){
	double x,y,twist;
	
	x=stick.getX()/4.0*-1.0; // invert left-right
	y=stick.getY()/4.0;
	twist=stick.getTwist()/3.0;
	System.out.println("X: " + x + " Y: " + y + " Twist: " + twist + " Angle: " + heading);
	this.drive.mecanumDrive_Cartesian(x, y, twist, heading);
    }

    /**
     * Stop the robot chassis from moving
     */
    public void driveHalt() {
	this.drive.mecanumDrive_Cartesian(0,0,0,0);
    }
}


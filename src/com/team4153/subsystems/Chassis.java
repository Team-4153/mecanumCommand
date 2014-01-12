package com.team4153.subsystems;

import com.team4153.OI;
import com.team4153.RobotMap;
import com.team4153.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
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

    /**  The control mode needs to be set in the constructor for the speed mode to work:
     *  http://www.chiefdelphi.com/forums/showthread.php?t=89721
     * 
     * Setting the "changeControlMode" after the constructor does not seem to work.
     * 
     */
    public Chassis() {
        try {
            System.out.println("Chassis Construtor started");
            rightFront = new CANJaguar(RobotMap.JAG_RIGHT_FRONT_MOTOR, CANJaguar.ControlMode.kSpeed);
            configSpeedControl(rightFront);
            System.out.println("JAG Right Front works, " + RobotMap.JAG_RIGHT_FRONT_MOTOR);
            rightRear = new CANJaguar(RobotMap.JAG_RIGHT_REAR_MOTOR, CANJaguar.ControlMode.kSpeed);
            configSpeedControl(rightRear);
            System.out.println("JAG Right Back works, " + RobotMap.JAG_RIGHT_REAR_MOTOR);
            leftFront = new CANJaguar(RobotMap.JAG_LEFT_FRONT_MOTOR, CANJaguar.ControlMode.kSpeed);
            configSpeedControl(leftFront);
            System.out.println("JAG Left Front works, " + RobotMap.JAG_LEFT_FRONT_MOTOR);
            leftRear = new CANJaguar(RobotMap.JAG_LEFT_REAR_MOTOR, CANJaguar.ControlMode.kSpeed);
            configSpeedControl(leftRear);
            System.out.println("JAG Left Back works, " + RobotMap.JAG_LEFT_REAR_MOTOR);

        } catch (CANTimeoutException ex) {
            System.out.println("Chassis constructor CANTimeoutException: ");
            ex.printStackTrace();
            //System.exit(-1);
        }

        drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
        drive.setInvertedMotor(MotorType.kFrontLeft, true);//Left front motor normally opposite
        drive.setMaxOutput(2);//TODO: Fix the magic numbers
//	drive = new RobotDrive(leftRear, leftRear, leftRear, leftRear);
        drive.setSafetyEnabled(false);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private void configSpeedControl(CANJaguar jag) throws CANTimeoutException {
        final int CPR = 360;
        final double ENCODER_FINAL_POS = 0;
        final double VOLTAGE_RAMP = 40;
        // PIDs may be required.  Values here:
        //  http://www.chiefdelphi.com/forums/showthread.php?t=91384
        // and here:
        // http://www.chiefdelphi.com/forums/showthread.php?t=89721
        // neither seem correct.
//        jag.setPID(0.4, .005, 0);
        jag.setPID(1, 0, 0);
        jag.changeControlMode(CANJaguar.ControlMode.kSpeed);
        jag.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
        jag.configEncoderCodesPerRev(CPR);
//        jag.setVoltageRampRate(VOLTAGE_RAMP);
        jag.enableControl();

//        System.out.println("Control Mode = " + jag.getControlMode());
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //eg: setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }

    /**
     * The command to drive mecanum via joystick and gyro angle
     *
     * @param stick The driver's joystick (usually via OI)
     * @param heading The gyro angle/heading
     */
    public void mecanumDrive(Joystick stick, double heading) {
        double twist;

//	
//	x=stick.getX()/4.0*-1.0; // invert left-right
//	y=stick.getY()/4.0;
        twist = stick.getTwist() / 3.0;

//	this.drive.mecanumDrive_Cartesian(x, y, twist, heading);
        //if(OI.getTriggerButton().get()){
        double x, y;
        // These are for percent Vbus      
//            x=stick.getX()/-2.0;
//            y=stick.getY()/-2.0;
        x = stick.getX();
        y = stick.getY();
        this.drive.mecanumDrive_Cartesian(x, y, twist, heading);
//            System.out.println("X: " + x + " Y: " + y + " Twist: " + twist + " Angle: " + heading);
        //   }
        //   else{
        //       double magnitude, direction;
        //       magnitude = stick.getMagnitude()/4.0;
        //      direction = stick.getDirectionDegrees()/4.0;
        //       this.drive.mecanumDrive_Polar( magnitude, direction, twist);
        //   }
    }
    
    public void wheelDrive(Joystick stick){
        double x=stick.getX()*5f;
        try {
            leftFront.setX(x);
            leftRear.setX(x);
            rightFront.setX(x);
            rightRear.setX(x);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Stop the robot chassis from moving
     */
    public void driveHalt() {
        System.out.println("** driveHalt");
        this.drive.mecanumDrive_Polar(0, 0, 0);
    }
}

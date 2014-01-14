package com.team4153;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static final int JOYSTICK_PORT = 1;
    public static final int JAG_LEFT_FRONT_MOTOR = 4;
    public static final int JAG_LEFT_REAR_MOTOR = 2;
    public static final int JAG_RIGHT_FRONT_MOTOR = 8;
    public static final int JAG_RIGHT_REAR_MOTOR = 6;
    public static final int GYRO_CHANNEL = 1;
    public static final int JSBUTTON_TRIGGER = 1;
    public static final int JSBUTTON_GYRO_RESET=2;
}

package com.team4153.commands;

import com.team4153.OI;
import com.team4153.subsystems.Chassis;
import com.team4153.subsystems.GyroSensor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.xxx
 * 
 * @author KPT
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems here
    public static Chassis chassis = new Chassis();
    public static GyroSensor gyro = new GyroSensor();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(chassis);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}

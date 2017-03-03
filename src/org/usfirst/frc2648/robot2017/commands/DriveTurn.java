package org.usfirst.frc2648.robot2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveTurn extends CommandGroup {

    public DriveTurn() {
    	addSequential(new PidDrive(1.25,0,0,-6));
    	addSequential(new PidTurn(.1,0,0,-90));
    	addSequential(new TimeDrive(1,.75));
    	addSequential(new TimeDrive(2,0));
    	addSequential(new PidDrive(1.25,0,0,-2.5));
    	addSequential(new PidTurn(.1,0,0,90));
    	addSequential(new PidDrive(1.25,0,0,4));
    	addSequential(new PidTurn(.1,0,0,-45));
    	addSequential(new PidDrive(1.25,0,0,1));
    }
}

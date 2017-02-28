package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class StartPid extends InstantCommand{
	
	protected void execute(){
		Robot.shooter.start(80, .2);
	}

}

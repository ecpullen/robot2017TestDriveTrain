package org.usfirst.frc2648.robot2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootTest extends CommandGroup {

	public ShootTest(){
		addSequential(new StartPid());
		addSequential(new ShooterOnClose());
	}
}

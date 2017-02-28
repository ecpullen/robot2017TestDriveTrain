package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command{

	private double angle;
	public GyroTurn(double angle){
		this.angle = -angle;
	}

	public void initialize(){
		Robot.driveTrain.resetGyro();
	}
	
	public void execute(){
		Robot.driveTrain.drive(0,.25*(angle-Robot.driveTrain.getGyro().getAngle()));
		//Robot.driveTrain.arcadeDrive(0, 1);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Math.abs(Robot.driveTrain.getGyro().getAngle()+Robot.driveTrain.getGyro().getRate()*.02-angle)<30;
	}
}

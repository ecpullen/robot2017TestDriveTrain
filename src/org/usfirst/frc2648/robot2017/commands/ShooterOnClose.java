package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterOnClose extends Command {

	double p_speed = .3;
	double m_speed = 70;
	protected void Initialize(){
		Robot.shooter.start((double)80,.2);
		//Robot.shooter.spin(.85);
	}
	
	protected void execute(){
		if(Robot.shooter.getShooterEnc().getRate()<60){
			p_speed += .01;
		}
		else{
		if(m_speed < Robot.shooter.getShooterEnc().getRate()){
			p_speed -= .001;
		}
		else
		p_speed += .001;
	}
		p_speed = Math.min(p_speed, 1.0);
		Robot.shooter.spin(p_speed);
		System.out.println(Robot.shooter.getShooterEnc().getRate());
		
		//Robot.shooter.runPID();
	}
	
	protected boolean isFinished(){
		return false;
	}
	
	protected void end(){
		Robot.shooter.stop();
	}
	
	protected void interrupted(){
		end();
	}
}

// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2648.robot2017.subsystems;

import org.usfirst.frc2648.robot2017.Robot;
import org.usfirst.frc2648.robot2017.RobotMap;
import org.usfirst.frc2648.robot2017.commands.ArcadeDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	private double pSpeed;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController lFront = RobotMap.driveTrainlFront;
    private final SpeedController lRear = RobotMap.driveTrainlRear;
    private final SpeedController rFront = RobotMap.driveTrainrFront;
    private final SpeedController rRear = RobotMap.driveTrainrRear;
    private final RobotDrive rd = RobotMap.driveTrainrd;
    private final DigitalInput pixyON = RobotMap.driveTrainpixyON;
    private final AnalogInput pixyX = RobotMap.driveTrainpixyX;
    private final Encoder lEnc = RobotMap.driveTrainlEnc;
    private final Encoder rEnc = RobotMap.driveTrainrEnc;
    private final AnalogInput us = RobotMap.us;
    private final ADXRS450_Gyro gyro = RobotMap.gyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveTrain(){
    	super();
    	gyro.reset();
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ArcadeDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
     /*public void arcadeDrive(){
    	 double adj = 0;
    	 adj = (pSpeed - Robot.oi.getj1().getY(Hand.kLeft))/1.5; 
    	 rd.arcadeDrive(-Robot.oi.getj1().getY(Hand.kLeft)+adj, -Robot.oi.getj1().getX(Hand.kLeft));
    	 pSpeed = Robot.oi.getj1().getY(Hand.kLeft)- adj;
     }*/
    /*public void arcadeDrive(){
    	rd.arcadeDrive(Robot.oi.getj1().getTriggerAxis(Hand.kRight)-Robot.oi.getj1().getTriggerAxis(Hand.kLeft), -Robot.oi.getj1().getX(Hand.kLeft));
    }*/
    
    public void arcadeDrive(){
    	double speed = -Robot.oi.getj1().getY(Hand.kLeft);
    	double turn = -.85*Robot.oi.getj1().getX(Hand.kLeft);
    	if(pSpeed < speed){
    		speed = Math.min(speed, pSpeed + .05);
    		speed = Math.min(speed, 1);
    	}
    	else{
    		speed = Math.max(speed,  pSpeed - .05);
    		speed = Math.max(speed,-1);
    	}
    	pSpeed = speed;
    	System.out.println(lEnc.getDistance()+" "+gyro.getAngle());
    	rd.arcadeDrive(speed, -turn);
    }
    
    public void arcadeDrive(double speed, double turn){
    	rd.arcadeDrive(speed, -turn);
    	//System.out.println(lEnc.getDistance());
    }
    
     public void drive(double left, double right){
    	 rd.tankDrive(left, right);
     }
	public Encoder getlEnc() {
		return lEnc;
	}
	public Encoder getrEnc(){
		return rEnc;
	}
	public void turn(double output) {
		// TODO Auto-generated method stub
		rd.tankDrive(output, output);
	}

	public AnalogInput getUs() {
		return us;
	}
	public void resetEnc(){
		lEnc.reset();
		rEnc.reset();
	}
	
	public void resetGyro(){
		gyro.reset();
	}
	
	public ADXRS450_Gyro getGyro(){
		return gyro;
	}
}


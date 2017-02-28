// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2648.robot2017;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    public static SpeedController driveTrainlFront;
    public static SpeedController driveTrainlRear;
    public static SpeedController driveTrainrFront;
    public static SpeedController driveTrainrRear;
    public static RobotDrive driveTrainrd;
    public static DigitalInput driveTrainpixyON;
    public static AnalogInput driveTrainpixyX;
    public static Encoder driveTrainlEnc;
    public static Encoder driveTrainrEnc;
    public static CANTalon shooterlShooter;
    public static Encoder shooterencShooter;
    public static PIDController shootershooter;
    public static CANTalon shooterrShooter;
    public static CANTalon climberlClimb;
    public static CANTalon climberrClimb;
    public static DoubleSolenoid gearlGear;
    public static DoubleSolenoid gearrGear;
    public static Compressor pneumaticscomp;
    public static DoubleSolenoid intakelIntake;
    public static DoubleSolenoid intakerIntake;
    public static CANTalon intakeintake;
    public static CANTalon shooterFeedershooterFeeder;
    public static AnalogInput us;
    public static ADXRS450_Gyro gyro;

    public static void init() {
    	us = new AnalogInput(0);
    	LiveWindow.addSensor("DriveTrain", "Ultrasonic", us);
    	
        driveTrainlFront = new Talon(16);
        //LiveWindow.addActuator("DriveTrain", "lFront", driveTrainlFront);
        
        driveTrainlRear = new Talon(1);
        //LiveWindow.addActuator("DriveTrain", "lRear", driveTrainlRear);
        
        driveTrainrFront = new Talon(14);
        //LiveWindow.addActuator("DriveTrain", "rFront", driveTrainrFront);
        
        driveTrainrRear = new Talon(0);
        //LiveWindow.addActuator("DriveTrain", "rRear", driveTrainrRear);
        
        driveTrainrd = new RobotDrive(driveTrainlFront, driveTrainlRear,
              driveTrainrFront, driveTrainrRear);
        
        driveTrainrd.setSafetyEnabled(true);
        driveTrainrd.setExpiration(0.1);
        driveTrainrd.setSensitivity(0.5);
        driveTrainrd.setMaxOutput(1.0);

        driveTrainpixyON = new DigitalInput(2);
        LiveWindow.addSensor("DriveTrain", "pixyON", driveTrainpixyON);
        
        driveTrainpixyX = new AnalogInput(3);
        LiveWindow.addSensor("DriveTrain", "pixyX", driveTrainpixyX);
        
        driveTrainlEnc = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "lEnc", driveTrainlEnc);
        driveTrainlEnc.setDistancePerPulse(1.0/170);//170
        driveTrainlEnc.setPIDSourceType(PIDSourceType.kDisplacement);
        driveTrainrEnc = new Encoder(5, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "rEnc", driveTrainrEnc);
        driveTrainrEnc.setDistancePerPulse(1.0/1955);
        driveTrainrEnc.setPIDSourceType(PIDSourceType.kDisplacement);
        shooterlShooter = new CANTalon(12);
        LiveWindow.addActuator("Shooter", "lShooter", shooterlShooter);
        
        shooterencShooter = new Encoder(8, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("Shooter", "encShooter", shooterencShooter);
        shooterencShooter.setDistancePerPulse(0.125);
        shooterencShooter.setPIDSourceType(PIDSourceType.kRate);
        shootershooter = new PIDController(0.0001, 0.0, 0.0, 0.0, shooterencShooter, shooterlShooter, 0.02);
        LiveWindow.addActuator("Shooter", "shooter", shootershooter);
        shootershooter.setContinuous(false);
        shootershooter.setAbsoluteTolerance(0.2);

        shooterencShooter.setDistancePerPulse(.5/3);
        shootershooter.setOutputRange(-1.0, 1.0);
        shooterrShooter = new CANTalon(13);
        LiveWindow.addActuator("Shooter", "rShooter", shooterrShooter);
        
        climberlClimb = new CANTalon(2);
        LiveWindow.addActuator("Climber", "lClimb", climberlClimb);
        
        climberrClimb = new CANTalon(3);
        LiveWindow.addActuator("Climber", "rClimb", climberrClimb);
        
        gearlGear = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Gear", "lGear", gearlGear);
        
        gearrGear = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Gear", "rGear", gearrGear);
        
        
        pneumaticscomp = new Compressor(0);
        
        
        intakelIntake = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("Intake", "lIntake", intakelIntake);
        
        intakerIntake = new DoubleSolenoid(0, 6, 7);
        LiveWindow.addActuator("Intake", "rIntake", intakerIntake);
        
        intakeintake = new CANTalon(4);
        LiveWindow.addActuator("Intake", "intake", intakeintake);
        
        shooterFeedershooterFeeder = new CANTalon(5);
        LiveWindow.addActuator("ShooterFeeder", "shooterFeeder", shooterFeedershooterFeeder);
        
        gyro = new ADXRS450_Gyro();
        LiveWindow.addActuator("DriveTrain", "Gyro", gyro);
    }
}

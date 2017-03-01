	package org.usfirst.frc2648.robot2017.commands;

	import org.usfirst.frc2648.robot2017.Robot;
	import org.usfirst.frc2648.robot2017.RobotMap;

	import edu.wpi.first.wpilibj.command.PIDCommand;

	/**
	 *
	 */
	public class PidDriveFull extends PIDCommand {

		private double setpoint;
	   

	    public PidDriveFull(double setpoint) {
			super(1.25, 0, 0);
			// TODO Auto-generated constructor stub
			requires(Robot.driveTrain);
	    	setSetpoint(setpoint);
	    	this.setpoint = setpoint;
		}

	    protected double returnPIDInput() {
	        return Robot.driveTrain.getlEnc().getDistance();
	    }

	    protected void usePIDOutput(double output) {
	    	System.out.println(output);
	       Robot.driveTrain.arcadeDrive(output*3/4,(Robot.driveTrain.getGyro().getAngle())/7);
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
	    	setTimeout(1);
	    	//System.out.println(getSetpoint());
	    	getPIDController().setAbsoluteTolerance(.1);
	    	getPIDController().setOutputRange(-1, 1);
	    	System.out.println(getPIDController().getSetpoint());
			Robot.driveTrain.resetEnc();
	    	Robot.driveTrain.resetGyro();
	    }
	 
	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	    	//System.out.println(isTimedOut() + " " + (Robot.driveTrain.getlEnc().getDistance()-getSetpoint()));
	        return isTimedOut() && Math.abs(Robot.driveTrain.getlEnc().getDistance() - setpoint) < .1;
	    	//return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
	}


package org.usfirst.frc2648.robot2017.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearFromBesideBoiler extends CommandGroup {

    public GearFromBesideBoiler() {
        addSequential(new EncDrive(-8));
        Timer.delay(1);
        addSequential(new EncTurn(.25));
        //Timer.delay(1);
        addSequential(new EncDrive(-6));
    }
}

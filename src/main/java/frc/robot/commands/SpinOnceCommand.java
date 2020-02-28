/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Spinner;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;;

/**
 * An example command that uses an example subsystem.
 */
public class SpinOnceCommand extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    Spinner spinner;
    private long startTime = 0;
    private long currentTime = 0;

    // commands must take in a parameter of the subsystems they are using so they
    // can access their methods
    public SpinOnceCommand(Spinner spinner) {
        this.spinner = spinner;
    }

    // called once and only once when the command is called
    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        SmartDashboard.putNumber("Start Time", startTime);
    }

    // called many times over while the command is active (50hz)
    @Override
    public void execute() {
        spinner.spin();
        currentTime = System.currentTimeMillis();
        SmartDashboard.putNumber("Current Time", currentTime);

    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        spinner.minusSpins();
        spinner.stopSpin();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return currentTime - startTime >= Constants.spinOnce;
    }
}
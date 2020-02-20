/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends SubsystemBase {
    private final Victor intake;
    private DigitalInput limit = new DigitalInput(Constants.limitSensor);
    /**
     * Creates a new ExampleSubsystem.
     */
    public Intake() {
        intake = new Victor(Constants.intake);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void intake() {
        intake.set(1);
    }

    public void stop() {
        intake.set(0);
    }

    public boolean checkBall() {
        SmartDashboard.putBoolean("Value of Sensor", limit.get());
        if (!limit.get()) {
            return true;
        }
        return false;
    }
}

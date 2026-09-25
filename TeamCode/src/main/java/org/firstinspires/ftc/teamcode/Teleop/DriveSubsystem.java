package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.HardwareRobot;

public class DriveSubsystem {
    public DcMotorEx leftFront;
    public DcMotorEx leftBack;
    public DcMotorEx rightFront;
    public DcMotorEx rightBack;
    public DriveSubsystem(HardwareRobot hardwareRobot) {
        this.leftBack = hardwareRobot.leftBack;
    }
    public void driveRobotCentric(double strafe, double forward, double turn){}
}
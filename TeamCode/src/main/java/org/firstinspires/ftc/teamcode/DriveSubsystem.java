package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;

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

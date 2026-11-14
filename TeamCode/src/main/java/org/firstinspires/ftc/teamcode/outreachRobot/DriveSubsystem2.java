package org.firstinspires.ftc.teamcode.outreachRobot;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;

public class DriveSubsystem2 extends SubsystemBase {
    private final Motor leftBack;
    private final Motor leftFront;
    private final Motor rightBack;
    private final Motor rightFront;
    private final MecanumDrive controller;
    private final GoBildaPinpointDriver pinpoint;

    //this part initializes the motors
    public DriveSubsystem2(Motor leftFront, Motor rightFront, Motor leftBack, Motor rightBack, GoBildaPinpointDriver pinpoint) {
        this.leftFront = leftFront;
        this.rightFront = rightFront;
        this.leftBack = leftBack;
        this.rightBack = rightBack;
        this.pinpoint = pinpoint;
        this.controller = new MecanumDrive(leftFront, rightFront, leftBack, rightBack);
    }

    //getters are used for the robot wheel positions
    public double getLeftFrontPosition() {
        return -leftFront.getCurrentPosition();
    }

    public double getRightFrontPosition() {
        return -rightFront.getCurrentPosition();
    }

    public double getLeftBackPosition() {
        return leftBack.getCurrentPosition();
    }

    public double getRightBackPosition() {
        return -rightBack.getCurrentPosition();
    }
    public void robotCentricDrive(double strafe, double forward, double turn) {
        controller.driveRobotCentric(strafe, forward, turn);
    }

    public void fieldCentricDrive(double strafe, double forward, double turn, double gyroAngle){
        controller.driveFieldCentric(strafe,forward, turn, gyroAngle);
    }
    public void stopController(){
        controller.stop();
    }

}

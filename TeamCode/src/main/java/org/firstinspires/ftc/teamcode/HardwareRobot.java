package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class HardwareRobot {
    public final Motor leftBack;
    public final Motor leftFront;
    public final Motor rightBack;
    public final Motor rightFront;
    public final GoBildaPinpointDriver pinpoint;

    public HardwareRobot(HardwareMap hardwareMap) {
        leftFront = new Motor(hardwareMap, "lfw", Motor.GoBILDA.RPM_312);
        rightFront = new Motor(hardwareMap, "rfw", Motor.GoBILDA.RPM_312);
        leftBack = new Motor(hardwareMap, "lbw", Motor.GoBILDA.RPM_312);
        rightBack = new Motor(hardwareMap, "rbw", Motor.GoBILDA.RPM_312);

        leftFront.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftFront.setRunMode(Motor.RunMode.RawPower);
        rightFront.setRunMode(Motor.RunMode.RawPower);
        leftBack.setRunMode(Motor.RunMode.RawPower);
        rightBack.setRunMode(Motor.RunMode.RawPower);

        leftFront.setInverted(true);
        rightFront.setInverted(true);
        leftBack.setInverted(true);
        rightBack.setInverted(true);

        leftFront.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        //webcam = hardwareMap.get(WebcamName.class,  "Webcam 1");

        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");

    }
}
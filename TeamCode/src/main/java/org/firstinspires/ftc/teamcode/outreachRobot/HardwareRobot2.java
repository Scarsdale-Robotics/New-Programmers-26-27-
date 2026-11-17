package org.firstinspires.ftc.teamcode.outreachRobot;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class HardwareRobot2 {
    public final Motor leftBack;
    public final Motor leftFront;
    public final Motor rightBack;
    public final Motor rightFront;
    public final Motor arm;
    public final Motor arm2;
    public final WebcamName webcam;


    public final GoBildaPinpointDriver pinpoint;
    // TODO: update rpm
    public HardwareRobot2(HardwareMap hardwareMap) {
        leftFront = new Motor(hardwareMap, "lfw", Motor.GoBILDA.RPM_312);
        rightFront = new Motor(hardwareMap, "rfw", Motor.GoBILDA.RPM_312);
        leftBack = new Motor(hardwareMap, "lbw", Motor.GoBILDA.RPM_312);
        rightBack = new Motor(hardwareMap, "rbw", Motor.GoBILDA.RPM_312);
        arm = new Motor(hardwareMap, "arm", Motor.GoBILDA.RPM_1620);
        arm2 = new Motor(hardwareMap, "arm2", Motor.GoBILDA.RPM_1620);


        leftFront.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm2.motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm2.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setRunMode(Motor.RunMode.RawPower);
        rightFront.setRunMode(Motor.RunMode.RawPower);
        leftBack.setRunMode(Motor.RunMode.RawPower);
        rightBack.setRunMode(Motor.RunMode.RawPower);
        arm.setRunMode(Motor.RunMode.RawPower);
        arm2.setRunMode(Motor.RunMode.RawPower);


        leftFront.setInverted(true);
        rightFront.setInverted(true);
        leftBack.setInverted(true);
        rightBack.setInverted(true);
        arm.setInverted(true);
        arm2.setInverted(true);

        leftFront.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm2.motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        arm2.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        webcam = hardwareMap.get(WebcamName.class,  "Webcam 1");

        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");

    }
    public void initPinpoint() {
        pinpoint.setOffsets(5.0,0, DistanceUnit.INCH);
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.REVERSED, GoBildaPinpointDriver.EncoderDirection.REVERSED);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pinpoint.resetPosAndIMU();
    }

}

//personal note:
//stop and reset encoder means resetting internal rotations and bringing them back to 0
//run without encoder means to accept values between -1 to 1
//zero power behavior means stop when you release a joystick

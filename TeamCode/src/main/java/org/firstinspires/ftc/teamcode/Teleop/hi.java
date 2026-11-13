package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "tutorial")
public class hi extends OpMode {

    DcMotor leftBackMotor;
    DcMotor leftFrontMotor;
    DcMotor rightBackMotor;
    DcMotor rightFrontMotor;

    @Override
    public void init() {
        leftBackMotor = hardwareMap.get(DcMotor.class, "leftBackMotor");
        leftFrontMotor = hardwareMap.get(DcMotor.class, "leftFrontMotor");
        rightBackMotor = hardwareMap.get(DcMotor.class, "rightBackMotor");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "rightFrontMotor");

        telemetry.addData("Hardware:", "Initialized");

        float x = gamepad1.left_stick_x;
    }

    @Override
    public void loop() {


        if (gamepad1.a){
            leftBackMotor.setPower(0.5);
        }
        leftBackMotor.setPower(0);

        if(gamepad1.b){
            leftFrontMotor.setPower(0.5);
        }
        leftFrontMotor.setPower(0);

        if(gamepad1.back) {
            rightBackMotor.setPower(0.5);
        }
        rightBackMotor.setPower(0);

        if(gamepad1.circle) {
            rightFrontMotor.setPower(0.5);
        }
        rightFrontMotor.setPower(0);
    }
}

package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class SamuelTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        HardwareRobot hardwareRobot = new HardwareRobot(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            double turn = gamepad1.left_stick_x;
            double foward = gamepad1.right_stick_y;
            double strafe = gamepad1.right_stick_x;

        }

    }
}

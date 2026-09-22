package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp 9/22")
public class TianTeleop extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();

        while (opModeIsActive()){
            // Anything you write in here will loop until Stop is pressed.
            // Get the left joystick x position.
            double strafe = gamepad1.left_stick_x;
            // Get the inverted left joystick y position.
            double forward = -gamepad1.left_stick_y;
        }
     }
}

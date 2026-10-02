package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class SamuelTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        HardwareRobot hardwareRobot = new HardwareRobot(hardwareMap);
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareRobot.leftFront, hardwareRobot.rightFront, hardwareRobot.leftBack, hardwareRobot.rightBack)
        waitForStart();

        while (opModeIsActive()) {
            double strafe = gamepad1.left_stick_x;
            double forward = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            boolean drive =

        }

    }
}

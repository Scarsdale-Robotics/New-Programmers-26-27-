package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Teaching10/2")
public class ViirTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareRobot hardwareRobot = new HardwareRobot(hardwareMap);
        DriveSubsystem drive = new DriveSubsystem(hardwareRobot.leftFront, hardwareRobot.rightFront, hardwareRobot.leftBack, hardwareRobot.rightBack);
        waitForStart();
        while (opModeIsActive()) {
            double strafe = gamepad1.left_stick_x;
            double forward = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            drive.driveRobotCentricReal(strafe * 0.7, forward * 0.7, turn * 0.7);
            telemetry.addData("turn", turn);
            telemetry.addData("strafe", strafe);
            telemetry.addData("forward", forward);
        }
    }
}

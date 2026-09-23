package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ViirTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //init
        HardwareRobot hardwareRobot = new HardwareRobot(hardwareMap);
        DriveSubsystem drive = new DriveSubsystem(hardwareRobot);
        waitForStart();
        while (opModeIsActive()) {
            double turn = gamepad1.left_stick_x;
            double forward = -gamepad1.right_stick_y;
            double strafe = gamepad1.right_stick_x;
            drive.driveRobotCentric(strafe, forward, turn);
        }
    }
}

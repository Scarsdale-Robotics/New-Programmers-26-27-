package org.firstinspires.ftc.teamcode.Teleop.Auto;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Teleop.DriveSubsystem;

@TeleOp(name = "Outreach Field Centric", group = "Outreach")
public class OutreachBotStuff extends LinearOpMode {

    @Override
    public void runOpMode() {
        Motor leftFront = new Motor(hardwareMap, "leftFront", Motor.GoBILDA.RPM_312);
        Motor rightFront = new Motor(hardwareMap, "rightFront", Motor.GoBILDA.RPM_312);
        Motor leftBack = new Motor(hardwareMap, "leftBack", Motor.GoBILDA.RPM_312);
        Motor rightBack = new Motor(hardwareMap, "rightBack", Motor.GoBILDA.RPM_312);

        DriveSubsystem drive = new DriveSubsystem(
                leftFront,
                rightFront,
                leftBack,
                rightBack
        );

        IMU imu = hardwareMap.get(IMU.class, "imu");

        // facing forward
        IMU.Parameters imuParameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                )
        );
        imu.initialize(imuParameters);

        telemetry.addLine("ready to start ig");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        // relative to start position
        imu.resetYaw();

        boolean wasResetPressed = false;

        while (opModeIsActive()) {
            double headingDegrees = imu.getRobotYawPitchRollAngles()
                    .getYaw(AngleUnit.DEGREES);

            // Press OPTIONS to redefine the robot's current direction as forward.
            boolean resetPressed = gamepad1.options;
            if (resetPressed && !wasResetPressed) {
                imu.resetYaw();
                headingDegrees = 0.0;
            }
            wasResetPressed = resetPressed;

            double strafe = gamepad1.left_stick_x;
            double forward = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            // left bumper slow down
            double speed = gamepad1.left_bumper ? 0.35 : 1.0;

            drive.driveFieldCentricReal(
                    strafe * speed,
                    forward * speed,
                    turn * speed,
                    headingDegrees
            );

            telemetry.addData("Heading", "%.1f degrees", headingDegrees);
            telemetry.addData("Slow mode", gamepad1.left_bumper);
            telemetry.update();
        }

        drive.stopController();
    }
}
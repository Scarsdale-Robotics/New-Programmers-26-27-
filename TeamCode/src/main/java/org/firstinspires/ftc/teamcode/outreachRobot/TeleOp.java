package org.firstinspires.ftc.teamcode.outreachRobot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TeleOp extends LinearOpMode{
    public void runOpMode() throws InterruptedException {
        HardwareRobot2 hardwareRobot2 = new HardwareRobot2(hardwareMap);
        DriveSubsystem2 driveSubsystem2 = new DriveSubsystem2(hardwareRobot2.leftBack,hardwareRobot2.leftFront, hardwareRobot2.rightBack,hardwareRobot2.rightFront );
        waitForStart();
        while (opModeIsActive()){
            double strafe = gamepad1.left_stick_x;
            double forward = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            double x = hardwareRobot2.pinpoint.getPosX(DistanceUnit.INCH);
            double y = hardwareRobot2.pinpoint.getPosY(DistanceUnit.INCH);
            double yaw = hardwareRobot2.pinpoint.getHeading(AngleUnit.DEGREES);
            driveSubsystem2.fieldCentricDrive(strafe, forward, turn);
            telemetry.addLine("Turn: " + turn);
            telemetry.addLine("Strafe: " + strafe);
            telemetry.addLine("Forward: " + forward);
            telemetry.addLine("pinpoint x:" + x);
            telemetry.addLine("pinpoint y:" + y);
            telemetry.addLine("pinpoint yaw:" + yaw);
            telemetry.update();
        }
    }
}

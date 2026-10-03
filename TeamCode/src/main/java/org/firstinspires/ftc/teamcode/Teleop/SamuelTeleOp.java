package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.HardwareRobot;

@TeleOp
public class SamuelTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareRobot hardwareRobot = new HardwareRobot(hardwareMap);
        DriveSubsystem driveSubsystem = new DriveSubsystem(hardwareRobot.leftFront, hardwareRobot.rightFront, hardwareRobot.leftBack, hardwareRobot.rightBack);
        hardwareRobot.initPinpoint();
        hardwareRobot.pinpoint.setPosition(new Pose2D(DistanceUnit.INCH,0,0, AngleUnit.DEGREES, 0));
        hardwareRobot.pinpoint.recalibrateIMU();
        hardwareRobot.pinpoint.initialize();
        waitForStart();
        while (opModeIsActive()) {
            hardwareRobot.pinpoint.update();
            double strafe = gamepad1.left_stick_x;
            double forward = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            driveSubsystem.driveRobotCentricReal(strafe, forward, turn);
            double x = hardwareRobot.pinpoint.getPosX(DistanceUnit.INCH);
            double y = hardwareRobot.pinpoint.getPosY(DistanceUnit.INCH);
            double yaw = hardwareRobot.pinpoint.getHeading(AngleUnit.DEGREES);
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

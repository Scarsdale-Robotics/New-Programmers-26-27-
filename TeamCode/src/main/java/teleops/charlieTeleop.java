package teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp 9/23")
public class charlieTeleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareRobot hardwareRobot = new HardwareRobot(hardwareMap);
        org.firstinspires.ftc.teamcode.Subsystems.Drive.DriveSubsystem drive = new org.firstinspires.ftc.teamcode.Subsystems.Drive.DriveSubsystem(hardwareRobot);
        waitForStart();
        while(opModeIsActive()){
            //will loop until stop is pressed
            double turn = gamepad1.left_stick_x;
            double forward = -gamepad1.right_stick_y;
            double strafe = gamepad1.right_stick_x;
            drive.driveRobotCentric(strafe, forward, turn);
        }
    }
}

package org.firstinspires.ftc.teamcode.Teleop.Auto;


import static com.sun.tools.javac.jvm.ByteCodes.error;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.pedropathing.util.Timer;
import org.firstinspires.ftc.teamcode.Teleop.DriveConstants;

@Autonomous(name = "Test Auto")
public class SamuelAuto extends LinearOpMode {
    public Motor m;

    public static double p = 0.1;
    public static double i = 0.05;
    public static double d = 0.01;
    public static double sp = 100;
    public double lasterr = 0;
    public Timer t = new Timer();
    public double lastT = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        m = new Motor(hardwareMap, "motor", Motor.GoBILDA.RPM_312);
        waitForStart();
        while (opModeIsActive()) {
            double dist = m.getCurrentPosition() * DriveConstants.TPI;
            double err = sp - dist;
            double dt = (t.getElapsedTimeSeconds() - lastT);
            double kp = err*p;
            double kd = (err - lasterr)/(t.getElapsedTimeSeconds() - lastT);
            double ki = dt * err;
            double ut = kp + kd + ki;
            ut = Math.max(-1, Math.min(ut, 1));
            m.set(ut);
            lasterr = err;
            lastT = t.getElapsedTimeSeconds();
        }

    }
}

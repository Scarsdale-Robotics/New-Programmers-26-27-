package org.firstinspires.ftc.teamcode.Auto;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.pedropathing.util.Timer;

import teleops.DriveConstants;

@Autonomous(name = "Test Auto")
public class CharlieAutop extends LinearOpMode {
    public Motor m;
    public static double p = 0.100;
    public static double i = 0.005;
    public static double d = 0.001;
    public static double setPoint = 100;
    public double lasterr = 0;

    public Timer t = new Timer();
    public double lastT = 0;


    @Override
    public void runOpMode() throws InterruptedException{
        this.m = new Motor(hardwareMap, "motor", Motor.GoBILDA.RPM_312);
        waitForStart();
        while(opModeIsActive()){
            double dist = m.getCurrentPosition() * DriveConstants.TPI;
            double err = setPoint-dist;
            double kp = err * p;
            double dt = (t.getElapsedTimeSeconds() - lastT);
            double kd = (err - lasterr)/(t.getElapsedTimeSeconds() - lastT);
            double ki = dt * err;
            double ut = kp+kd+ki;
            ut = Math.max(-1,Math.min(ut, 1));
            m.set(ut);
            lasterr = err;
            lastT = t.getElapsedTimeSeconds();
        }
    }
}

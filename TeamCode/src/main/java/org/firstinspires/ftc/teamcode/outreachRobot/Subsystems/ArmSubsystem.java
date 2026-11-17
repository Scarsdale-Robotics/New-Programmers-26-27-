package org.firstinspires.ftc.teamcode.outreachRobot.Subsystems;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.bylazar.configurables.annotations.Configurable;

@Configurable
public class ArmSubsystem {
    public PIDController pid;
    public double p = 0.01;
    public double i = 0.0005;
    public double d = 0.1*p;
    public Motor arm;
    public Motor arm2;
    public ArmSubsystem(Motor arm, Motor arm2){
        this.arm = arm;
        this.arm2 = arm2;
        this.pid = new PIDController(p, i, d);
    }
    public void pidUpdate(double targetPosition){
        double error = getPosition() - targetPosition;
        double output = pid.calculate(error, 0);
        output = Math.max(-1, Math.min(1, output));
        arm.set(output);
        arm2.set(output);
    }
    public void setPower(double power){arm.set(power);}
    public double getVelocity(){return arm.getCorrectedVelocity();}
    public double getPosition(){return arm.getCurrentPosition();}

}



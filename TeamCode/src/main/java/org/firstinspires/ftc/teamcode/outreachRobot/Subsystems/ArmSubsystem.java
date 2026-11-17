package org.firstinspires.ftc.teamcode.outreachRobot.Subsystems;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.bylazar.configurables.annotations.Configurable;

@Configurable
public class ArmSubsystem {
    public Motor arm;
    public Motor arm2;
    public ArmSubsystem(Motor arm, Motor arm2){
        this.arm = arm;
        this.arm2 = arm2;
    }
    public void setPower(double power){arm.set(power);}
    public double getVelocity(){return arm.getCorrectedVelocity();}
    public double getPosition(){return arm.getCurrentPosition();}

}



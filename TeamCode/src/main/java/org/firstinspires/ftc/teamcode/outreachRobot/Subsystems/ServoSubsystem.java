package org.firstinspires.ftc.teamcode.outreachRobot.Subsystems;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoSubsystem{
    private Servo servoA;
    public ServoSubsystem(Servo servoA){
        this.servoA = servoA;
    }
    public int getHashCode(){
        return servoA.hashCode();
    }
    public void close(){
        servoA.close();
    }
    public void setScaleRange(double min, double max){
        servoA.scaleRange(min, max);
    }
    public void setDirect(Servo.Direction dir){
        servoA.setDirection(dir);
    }
    public String obtainDeviceName(){
        return servoA.getDeviceName();
    }
    public int getPortNum(){
        return servoA.getPortNumber();
    }
    public void setServoPos(double servoPos){
        servoA.setPosition(servoPos);
    }
    public double getServoPos(){
        return servoA.getPosition();
    }
}

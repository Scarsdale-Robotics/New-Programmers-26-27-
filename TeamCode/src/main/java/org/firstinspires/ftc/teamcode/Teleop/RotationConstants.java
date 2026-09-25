package org.firstinspires.ftc.teamcode.Teleop;


/**
 * A static class used by Rotation Movements to reference important kinematic and algorithmic tuning values.
 */
public class RotationConstants {

    /**
     *  Max angular velocity of the robot in rad/s.
     */
    public static double MAX_ANGULAR_VELOCITY = 0.65* org.firstinspires.ftc.teamcode.Utils.DriveConstants.MAX_ANGULAR_VELOCITY; //TODO: TUNE
    /**
     *  Max angular acceleration of the robot in rad/s^2.
     */
    public static double MAX_ANGULAR_ACCELERATION = 0.65* org.firstinspires.ftc.teamcode.Utils.DriveConstants.MAX_ANGULAR_ACCELERATION; //TODO: TUNE

}
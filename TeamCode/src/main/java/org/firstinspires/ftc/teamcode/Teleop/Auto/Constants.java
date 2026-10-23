package org.firstinspires.ftc.teamcode.Teleop.Auto;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@Configurable
//TODO: Tune all
public class Constants {
    public static double translationalP = 0.03;
    public static double translationalI = 0;
    public static double translationalD = 0;
    public static double translationalF = 0.015;
    public static FollowerConstants followerConstants = new FollowerConstants()

            .forwardZeroPowerAcceleration(-56.14794104552444)
            .lateralZeroPowerAcceleration(-64)
            .mass(3.63)
            .translationalPIDFCoefficients(new PIDFCoefficients(
                    translationalP,
                    translationalD,
                    translationalI,
                    translationalF
            ))
            .translationalPIDFSwitch(4)
            .secondaryTranslationalPIDFCoefficients(new PIDFCoefficients(
                    0.4,
                    0,
                    0.005,
                    0.0006
            ))
            .headingPIDFCoefficients(new PIDFCoefficients(
                    0.8,
                    0,
                    0,
                    0.01
            ))
            .secondaryHeadingPIDFCoefficients(new PIDFCoefficients(
                    2.5,
                    0,
                    0.1,
                    0.0005
            ))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(
                    0.1,
                    0,
                    0.00035,
                    0.6,
                    0.015
            ))
            .secondaryDrivePIDFCoefficients(new FilteredPIDFCoefficients(
                    0.02,
                    0,
                    0.000005,
                    0.6,
                    0.01
            ))
            .drivePIDFSwitch(15)
            .centripetalScaling(0.0005);

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1.01, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .pinpointLocalizer(localizerConstants)
                .build();
    }
    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("rfw")
            .rightRearMotorName("rbw")
            .leftRearMotorName("lbw")
            .leftFrontMotorName("lfw")
            .leftFrontMotorDirection(DcMotorEx.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorEx.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorEx.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorEx.Direction.FORWARD)
            .xVelocity(59.649696764656127)
            .yVelocity(47.17493540846457);
    //TODO: Tune
    public static PinpointConstants localizerConstants = new PinpointConstants()
            //TODO: UPDATE OFFSETS
            .forwardPodY(0)
            .strafePodX(0)
            .distanceUnit(DistanceUnit.INCH)
            .hardwareMapName("pinpoint")
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED);
}
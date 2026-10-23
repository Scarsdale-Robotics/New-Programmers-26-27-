package org.firstinspires.ftc.teamcode.Teleop.Auto;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "RCAutoJoint")
public class RedCloseZoneAutoJoint extends LinearOpMode {
    public Pose InitialStartingPointNextToRedSeesaw = new Pose(56,8,r(90));
    public Pose LeftSideFirstIntake = new Pose(12,47,r(180));
    public Pose ControlPointOneFromFirstIntakeToOppositeSideOfRedSeesaw = new Pose(43, 48);
    public Pose ControlPointTwoFromFirstIntakeToOppositeSideOfRedSeesaw = new Pose(11,110);
    public Pose OppositeSideOfRedSeesaw = new Pose(56,123, r(-90));
    public Pose ControlPointThreeFromOppositeOfRedSeesawToTopSideSecondIntake = new Pose(49,101);
    public Pose TopSideSecondIntake = new Pose(47,130, r(90));
    public Pose LeftSideRedPark = new Pose(9,120, r(0));


    public double r(double deg){return Math.toRadians(deg);}
    public int pathState = 0;
    public Timer pathTimer = new Timer();
    public PathChain FirstShootToFirstIntake;
    public PathChain FirstIntakeToSecondShoot;
    public PathChain SecondShootToSecondIntake;
    public PathChain ReturnToSecondShoot;
    public PathChain GoToPark;
    public Follower follower;
    @Override
    public void runOpMode() throws InterruptedException {
        this.pathTimer.resetTimer();
        this.follower = Constants.createFollower(hardwareMap);
        follower.update();
        buildPaths();
        setPathState(0);
        waitForStart();
        while (opModeIsActive()) {
            follower.update();
            autonomousPathUpdate();
        }
    }
    public void buildPaths() {
        this.FirstShootToFirstIntake = follower.pathBuilder()
                .addPath(new BezierLine(
                        InitialStartingPointNextToRedSeesaw,
                        LeftSideFirstIntake)
                )
                .setLinearHeadingInterpolation(
                        InitialStartingPointNextToRedSeesaw.getHeading(),
                        LeftSideFirstIntake.getHeading()
                )
                .build();
        this.FirstIntakeToSecondShoot = follower.pathBuilder()
                .addPath(new BezierCurve(
                        LeftSideFirstIntake,
                        ControlPointOneFromFirstIntakeToOppositeSideOfRedSeesaw,
                        ControlPointTwoFromFirstIntakeToOppositeSideOfRedSeesaw,
                        OppositeSideOfRedSeesaw)
                )
                .setLinearHeadingInterpolation(
                        LeftSideFirstIntake.getHeading(),
                        OppositeSideOfRedSeesaw.getHeading()
                )
                .build();
        this.SecondShootToSecondIntake = follower.pathBuilder()
                .addPath(new BezierCurve(
                        OppositeSideOfRedSeesaw,
                        ControlPointThreeFromOppositeOfRedSeesawToTopSideSecondIntake,
                        TopSideSecondIntake)
                )
                .setLinearHeadingInterpolation(
                        OppositeSideOfRedSeesaw.getHeading(),
                        TopSideSecondIntake.getHeading()
                )
                .build();
        this.ReturnToSecondShoot = follower.pathBuilder()
                .addPath(new BezierCurve(
                        TopSideSecondIntake,
                        ControlPointThreeFromOppositeOfRedSeesawToTopSideSecondIntake,
                        OppositeSideOfRedSeesaw)
                )
                .setLinearHeadingInterpolation(
                        TopSideSecondIntake.getHeading(),
                        OppositeSideOfRedSeesaw.getHeading()
                )
                .build();
        this.GoToPark = follower.pathBuilder()
                .addPath(new BezierLine(
                        OppositeSideOfRedSeesaw,
                        LeftSideRedPark)
                )
                .setLinearHeadingInterpolation(
                        OppositeSideOfRedSeesaw.getHeading(),
                        LeftSideRedPark.getHeading()
                )
                .build();
    }
    boolean pathF1 = true;
    boolean pathF2 = true;
    boolean pathF3 = true;
    boolean pathF4 = true;
    public void autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                if (!follower.isBusy()) {
                    if (follower.atPose(p.startPoseRC,3,3)) {
                        robot.shooter.shoot();
                        setPathState(1);
                    }
                }
                break;
            case 1:
                if (pathF1) {
                    follower.followPath(intakeOne);
                    pathF1 = false;
                }
                if (follower.atPose(p.intakeSideRed,3,3)) {
                    setPathState(2);
                }
                break;
            case 2:
                if (!follower.isBusy()){
                    if (pathF2){
                        //robot.intake.set(1);
                        follower.followPath(finishIntakeOne);
                        pathF2 = false;
                    }
                    if (follower.atPose(p.finishIntakeSideRed, 3,3)) {
                        //robot.intake.set(0);
                        setPathState(3);
                    }
                }
                break;
            case 3:
                if (!follower.isBusy()){
                    if (pathF3){
                        follower.followPath(goToFarTransition, true);
                        pathF3 = false;
                    }
                    if(follower.atPose(p.farTransitionRed, 3,3)) {
                        robot.shooter.shoot();
                        setPathState(5);
                    }
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    if (pathF4) {
                        follower.followPath(goToPark);
                        pathF4 = false;
                    }
                    if (follower.atPose(p.parkRed, 3,3)) {
                        setPathState(6);
                    }
                }
            case 6:
                break;
        }
    }
    public void setPathState(int pState) {
        pathState = pState;
        pathTimer.resetTimer();
    }
}
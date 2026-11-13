package org.firstinspires.ftc.teamcode.Teleop.Auto;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.pedropathing.util.Timer;
import com.sun.tools.javac.util.Constants;

import org.firstinspires.ftc.teamcode.Teleop.HardwareRobot;

//setup
@Autonomous(name = "BCAuto") //Name of the Program under Driver Station
public class PracticeAuto extends LinearOpMode {
    public HardwareRobot robot;//references for motor
    public int pathState = 0;
    public Timer pathTimer = new Timer();
    //public Pose is it defines a coordinate on the field and the
    //radians are the orientation of the robot
    public Pose startPose = new Pose(56,8,r(90));
    public Pose oppHivePose = new Pose(46,110, r(270));
    public Pose curHivePose = new Pose(56,8, r(90));
    public Pose intakeSide = new Pose(25,8, r(180));
    public Pose intakeSideControl = new Pose(24,20);
    public Pose finishIntakeSide = new Pose(10,8, r(180));
    public Pose park = new Pose(10,100, r(90));
    public Pose closeTransition = new Pose(30,40, r(90));
    public Pose farTransition = new Pose(30, 110, r(270));
    public Pose farIntakeFlower = new Pose(45,125,r(90));

    //these are path chain is what actually holds the geometric
    //trajectory that connects the Poses together.
    //later paths will be created based off these names
    public PathChain intakeOne;
    public PathChain finishIntakeOne;
    public PathChain goToFarTransition;
    public PathChain goToIntakeFlower;
    public PathChain goToPark;

    public Follower follower; //this is what calculates movement vectors
    @Override
    public void runOpMode() throws InterruptedException{
        this.robot = new RobotSystem(hardwareMap,this);
        this.pathTimer.resetTimer();
        this.follower = Constants.createFollower(hardwareMap);
        follower.setPose(startPose);
        follower.update();
        buildPaths();
        setPathState(0);
        waitForStart();
        while(opModeIsActive()) {
            follower.update();
            autonomousPathUpdate();
        }
    }
    public void buildPaths(){
        //this.name = follower.pathBuilder()
        //      .addPath(new BezierCurve(point, point, point)) or (new BezierLine(point, point))
        //      .build();
        this.intakeOne = follower.pathBuilder()
                .addPath(new BezierCurve(startPose, intakeSideControl, intakeSide))
                .setLinearHeadingInterpolation(startPose.getHeading(), intakeSide.getHeading())
                .build();
        this.finishIntakeOne = follower.pathBuilder()
                .addPath(new BezierLine(intakeSide, finishIntakeSide))
                .setLinearHeadingInterpolation(intakeSide.getHeading(), finishIntakeSide.getHeading())
                .build();
        this.goToFarTransition = follower.pathBuilder()
                .addPath(new BezierLine(finishIntakeSide, farTransition))
                .setLinearHeadingInterpolation(finishIntakeSide.getHeading(), farTransition.getHeading())
                .build();
        this.goToIntakeFlower = follower.pathBuilder()
                .addPath(new BezierLine(farTransition, farIntakeFlower))
                .setLinearHeadingInterpolation(farTransition.getHeading(), farIntakeFlower.getHeading())
                .build();
        this.goToPark = follower.pathBuilder()
                .addPath(new BezierLine(farIntakeFlower, park))
                .setLinearHeadingInterpolation(farIntakeFlower.getHeading(), park.getHeading())
                .build();

    }

    //These are just one-time requests so these paths arent spammed endlessly.
    boolean pathF1 = true;
    boolean pathF2 = true;
    boolean pathF3 = true;
    boolean pathF4 = true;
    boolean pathF5 = true;
    public void autonomousPathUpdate(){
        switch (pathState) {
            case 0: //
                if (!follower.isBusy()) {
                    if (follower.atPose(startPose,3,3)) {
                        robot.shooter.shoot();
                        setPathState(1);
                    }
                }
                break;
            case 1:
                if (pathF1){
                    follower.followPath(intakeOne);
                    pathF1 = false;
                }
                if (follower.atPose(intakeSide,3,3)) {
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
                    if (follower.atPose(finishIntakeSide, 3,3)) {
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
                    if(follower.atPose(farTransition, 3,3)) {
                        robot.shooter.shoot();
                        setPathState(4);
                    }
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    if (pathF4) {
                        follower.followPath(goToIntakeFlower);
                        pathF4 = false;
                    }
                    if (follower.atPose(farIntakeFlower, 3,3)) {
                        //robot.intake.set(1);
                        //wait
                        //robot.intake.set(0)
                        robot.shooter.shoot();
                        setPathState(5);
                    }
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    if (pathF5) {
                        follower.followPath(goToPark);
                        pathF5 = false;
                    }
                    if (follower.atPose(park, 3,3)) {
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
    public double r(double deg){return Math.toRadians(deg);} //helps you write degrees into an easier form
}





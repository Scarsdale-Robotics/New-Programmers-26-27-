package org.firstinspires.ftc.teamcode.CV;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

public class pipeline2 extends OpenCvPipeline {

    public Scalar redL = new Scalar(0,100,100);
    public Scalar redU = new Scalar(10,255,255);
    public Scalar blueL = new Scalar(100,100,50);
    public Scalar blueU = new Scalar(130,255,255);
    public Scalar greenL = new Scalar(35,80,50);
    public Scalar greenU = new Scalar(85,255,255);
    public Scalar orangeL = new Scalar(5,100,100);
    public Scalar orangeU = new Scalar(25,255,255);

    @Override
    public Mat processFrame(Mat mat) {
        Mat hsv = new Mat();
        Imgproc.cvtColor(mat, hsv, Imgproc.COLOR_RGB2HSV);
        Mat maskOrange = new Mat();
        Core.inRange(hsv, orangeL, orangeU, maskOrange);
        List<MatOfPoint> contours = new ArrayList<>();
        Mat h = new Mat();
        Imgproc.findContours(maskOrange, contours, h, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        Imgproc.drawContours(mat,contours, -1, new Scalar(255,0,0));
        return mat;
    }
}

//hi viir sood
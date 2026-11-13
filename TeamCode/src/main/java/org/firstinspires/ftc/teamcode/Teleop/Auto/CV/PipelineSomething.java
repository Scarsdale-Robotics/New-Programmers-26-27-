package org.firstinspires.ftc.teamcode.Teleop.Auto.CV;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

public class PipelineSomething extends OpenCvPipeline {
    public Scalar redL = new Scalar(0, 100, 100);
    public Scalar redU = new Scalar(10, 255, 255);
    @Override
    public Mat processFrame(Mat mat) {
        Mat hsv = new Mat();
        Imgproc.cvtColor(mat, hsv, Imgproc.COLOR_RGB2HSV);
        Mat mask = new Mat();
        Core.inRange(hsv, redL, redU, mask);
        List<MatOfPoint> contours = new ArrayList<>();
        Mat h = new Mat();
        Imgproc.findContours(mask, contours, h, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        Imgproc.drawContours(mat, contours, -1, new Scalar(0, 255, 0));
        return mat;
    }
}

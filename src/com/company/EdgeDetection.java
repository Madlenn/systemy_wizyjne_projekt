package com.company;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;

public class EdgeDetection extends ImageConverter {

    public EdgeDetection(String imagePath, int width, int height) {
        super(imagePath, width, height);
    }

    public ImageIcon edgeDetection() {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
        Mat wide = new Mat();
        Imgproc.cvtColor(srcImg, dstImg, Imgproc.COLOR_RGB2GRAY);
        Imgproc.Canny(dstImg, wide,50,150,3,false);
        wide.convertTo(dstImg, CvType.CV_8U);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }

}


package com.company;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;

public class ColorSpaceConversion extends ImageConverter {

    public ColorSpaceConversion(String path, int width, int height) {
        super(path, width, height);
    }

    public ImageIcon cc() {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
        Imgproc.cvtColor(srcImg, dstImg, Imgproc.COLOR_RGB2HSV);

        return getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)), width, height);
    }
}
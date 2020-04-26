package com.company;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;


public class GreyImageConverter extends ImageConverter {

    public ImageIcon toGrayImageIcon(String imagePath) {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
        Imgproc.cvtColor(srcImg, dstImg, Imgproc.COLOR_RGB2GRAY);

        return new ImageIcon(toBufferedImage(dstImg));
    }


}

package com.company;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;

public class Brightness extends ImageConverter {

    public ImageIcon brightness(String imagePath) {
        double alpha = 2;
        double beta = 25;
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
        srcImg.convertTo(dstImg, -1, alpha, beta);

        return new ImageIcon(toBufferedImage(dstImg));
    }


}

package com.company;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;

public class Brightness extends ImageConverter {

    public Brightness(String path, int width, int height) {
        super(path, width, height);
    }

    public ImageIcon brightness() {
        double alpha = 2;
        double beta = 25;
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
        srcImg.convertTo(dstImg, -1, alpha, beta);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }


}

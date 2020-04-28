package com.company;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;

import static org.opencv.imgproc.Imgproc.ADAPTIVE_THRESH_MEAN_C;
import static org.opencv.imgproc.Imgproc.THRESH_BINARY;


public class Thresholding extends ImageConverter {

    public Thresholding(String imagePath, int width, int height) {
        super(imagePath, width, height);
    }

    public ImageIcon thresholding() {
        Mat imgGray = new Mat();
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
       Imgproc.cvtColor(srcImg, imgGray, Imgproc.COLOR_RGB2GRAY);

        Imgproc.adaptiveThreshold(imgGray,dstImg,255,ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 15, 40);

       // Mat result;
       // Imgproc.threshold(imgGray,imgGray,255,ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 15, 40);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }


}


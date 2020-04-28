package com.company;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;


public class GreyImageConverter extends ImageConverter {

    public GreyImageConverter(String imagePath, int width, int height) {
        super(imagePath, width, height);
    }

    public ImageIcon toGrayImageIcon() {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
        Imgproc.cvtColor(srcImg, dstImg, Imgproc.COLOR_RGB2GRAY);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }


}

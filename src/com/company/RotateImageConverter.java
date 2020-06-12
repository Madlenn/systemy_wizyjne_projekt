package com.company;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;


public class RotateImageConverter extends ImageConverter {

    public RotateImageConverter(String imagePath, int width, int height) {
        super(imagePath, width, height);
    }

    public ImageIcon rotateImageIcon(double angle) {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat();

        double radians = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));

        int newWidth = (int) (srcImg.width() * cos + srcImg.height() * sin);
        int newHeight = (int) (srcImg.width() * sin + srcImg.height() * cos);

        // rotating image
        Point center = new Point(newWidth / 2, newHeight / 2);
        Mat rotMatrix = Imgproc.getRotationMatrix2D(center, angle, 0.5); //1.0 means 100 % scale

        Size size = new Size(newWidth, newHeight);
        Imgproc.warpAffine(srcImg, dstImg, rotMatrix, size);
        

        return getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)), width, height);
    }


}




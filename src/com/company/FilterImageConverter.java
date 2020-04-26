package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;


public class FilterImageConverter extends ImageConverter {

    public ImageIcon blurImageIcon(String imagePath) {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());

        Imgproc.blur(srcImg,dstImg,new Size(30,30));


        return new ImageIcon(toBufferedImage(dstImg));
    }

    public ImageIcon filter2DImageIcon(String imagePath) {
        Point anchor;
        double delta;
        int ddepth = -1;
        anchor = new Point( -1, -1);
        delta = 0.0;
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
        int kernel_size=10;
        Mat ones = Mat.ones( kernel_size, kernel_size, CvType.CV_32F );
        Mat kernel = new Mat();
        Core.multiply(ones, new Scalar(1/(double)(kernel_size*kernel_size)), kernel);
        Imgproc.filter2D(srcImg,dstImg,ddepth,kernel,anchor,delta, Core.BORDER_CONSTANT);


        return new ImageIcon(toBufferedImage(dstImg));
    }

    public ImageIcon sqrBoxFilterImageIcon(String imagePath) {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());

        Imgproc.bilateralFilter(srcImg,dstImg,50,75,75,Core.BORDER_CONSTANT);

        return new ImageIcon(toBufferedImage(dstImg));
    }
}

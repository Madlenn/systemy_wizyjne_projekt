package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;


public class Skeletonization extends ImageConverter {

    public Skeletonization(String imagePath, int width, int height) {
        super(imagePath, width, height);
    }

    public ImageIcon skeletonization() {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
//        Imgproc.cvtColor(srcImg, dstImg, Imgproc.COLOR_RGB2GRAY);


        boolean done = false;
        Mat img = srcImg.clone();


        Mat imgGray = new Mat();
        Imgproc.cvtColor(img, imgGray, Imgproc.COLOR_BGR2GRAY);

        Mat tresh = new Mat();
        double thresh = Imgproc.threshold(imgGray, tresh, 100, 255, Imgproc.THRESH_BINARY_INV | Imgproc.THRESH_OTSU);
        ;

        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size(3,3));
        Mat eroded = new Mat();
        Mat temp = new Mat();
        Mat skel = new Mat (tresh.rows(), tresh.cols(), CvType.CV_8UC1, new Scalar(0));

        int size = img.cols() * img.rows();
        int zeros = 0;

        while(!done)
        {
            Imgproc.erode(tresh, eroded, element);
            Imgproc.dilate(eroded, temp, element);
            Core.subtract(tresh, temp, temp);
            Core.bitwise_or(skel, temp, skel);
            eroded.copyTo(tresh);

            zeros = size - Core.countNonZero(tresh);
            if(zeros == size)
                done = true;
        }

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(skel)),width,height);
        //return new ImageIcon(toBufferedImage(dstImg));
    }


}




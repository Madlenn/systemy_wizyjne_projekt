package com.company;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;

public class ErosionDilation extends ImageConverter {
    public ErosionDilation(String imagePath, int width, int height) {
        super(imagePath, width, height);
    }

    public ImageIcon erosion() {
        int kernelSize=0;
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());

        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * kernelSize + 1, 2 * kernelSize + 1));

       Imgproc.erode(srcImg,dstImg,kernel);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }

    public ImageIcon dilation() {
        int kernelSize=5;
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());

        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * kernelSize + 1, 2 * kernelSize + 1));

        Imgproc.dilate(srcImg,dstImg,kernel);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }

}

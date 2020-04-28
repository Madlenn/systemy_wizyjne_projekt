package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;

public class FilterImageConverter extends ImageConverter {

    public FilterImageConverter(String imagePath, int width, int height) {
        super(imagePath, width, height);
    }

    public ImageIcon blurImageIcon() {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());

        Imgproc.blur(srcImg, dstImg, new Size(30, 30));

        return  getResizedImageIcon( new ImageIcon(toBufferedImage(dstImg)),width,height);
    }

    public ImageIcon filter2DImageIcon() {
        Point anchor;
        double delta;
        int ddepth = -1;
        anchor = new Point(-1, -1);
        delta = 0.0;
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
        int kernel_size = 10;
        Mat ones = Mat.ones(kernel_size, kernel_size, CvType.CV_32F);
        Mat kernel = new Mat();
        Core.multiply(ones, new Scalar(1 / (double) (kernel_size * kernel_size)), kernel);
        Imgproc.filter2D(srcImg, dstImg, ddepth, kernel, anchor, delta, Core.BORDER_CONSTANT);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }

    public ImageIcon sqrBoxFilterImageIcon() {
        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());

        Imgproc.bilateralFilter(srcImg, dstImg, 50, 75, 75, Core.BORDER_CONSTANT);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }

    public ImageIcon lightFilterImageIcon() {

        Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());

        Mat M = Mat.eye(33, 3, CvType.CV_32FC1);
        Point anchor;
        anchor = new Point(-1, -1);

        Imgproc.filter2D(srcImg, dstImg, CvType.CV_8U, M, anchor, 0, Core.BORDER_DEFAULT);

        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);

        /*{
        implementacja reczna
            int kernelSize = 3;
            Mat srcImg = Imgcodecs.imread(imagePath);
            Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
            Mat kernel = new Mat(kernelSize, kernelSize, CvType.CV_32F) {
                {
                    put(2, 0, -1);
                    put(0, 1, 0);
                    put(0, 2, 1);

                    put(1, 0 - 2);
                    put(1, 1, 0);
                    put(1, 2, 2);

                    put(2, 0, -1);
                    put(2, 1, 0);
                    put(2, 2, 1);
                }
            };
            Imgproc.filter2D(srcImg, dstImg, -1, kernel);

            return new ImageIcon(toBufferedImage(dstImg));
        }*/
    }
}

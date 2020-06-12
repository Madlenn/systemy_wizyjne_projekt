package com.company;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import javax.swing.*;

public class FaceDetection extends ImageConverter {


    public FaceDetection(String path, int width, int height) {
        super(path, width, height);
    }

    public ImageIcon faceDetection() {
        Mat srcImg = Imgcodecs.imread(imagePath);
        String xmlFile = "xml/lbpcascade_frontalface.xml";
        CascadeClassifier cc = new CascadeClassifier(xmlFile);

        MatOfRect faceDetection = new MatOfRect();
        cc.detectMultiScale(srcImg, faceDetection);

        for (Rect rect : faceDetection.toArray()) {
            Imgproc.rectangle(srcImg, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
        }


        return getResizedImageIcon(new ImageIcon(toBufferedImage(srcImg)), width, height);
    }


}

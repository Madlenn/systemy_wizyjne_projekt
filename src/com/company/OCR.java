package com.company;
import com.asprise.ocr.Ocr;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import javax.swing.*;

public class OCR extends ImageConverter {


    public OCR(String path, int width, int height) {
        super(path, width, height);
    }

    public ImageIcon OCR() {
Mat srcImg = Imgcodecs.imread(imagePath);
        Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());




        return  getResizedImageIcon(new ImageIcon(toBufferedImage(dstImg)),width,height);
    }


}

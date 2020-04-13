package com.company;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;


public class MyFrame extends JFrame {
    private String imagePath;
    public MyFrame() {
        super(("Not Hello world"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 1000);
        setLocation(50, 50);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton pobierz = new JButton("pobierz");
        JButton gray = new JButton("gray");
        add(pobierz);
        add(gray);
        JLabel label = new JLabel(); //labelka z oryginalnym obrazkiem
        add(label);


        JLabel label2 = new JLabel(); //labelka ze zmienionym obrazkiem
        add(label2);

        pobierz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpeg");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    imagePath = selectedFile.getAbsolutePath();
                    label.setIcon(ReasizeImage(imagePath));
                    label2.setIcon(ReasizeImage(imagePath));
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Select");
                }
            }
        });
        gray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    Mat srcImg = Imgcodecs.imread(imagePath);
                    Mat dstImg = new Mat(srcImg.rows(), srcImg.cols(), srcImg.type());
                    Imgproc.cvtColor(srcImg, dstImg, Imgproc.COLOR_RGB2GRAY);

                ImageIcon image = new ImageIcon(toBufferedImage(dstImg));
                label2.setIcon(image);



            }
        });
        setVisible(true);
    }

    public ImageIcon ReasizeImage(String ImagePath) {



        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    };
    private BufferedImage toBufferedImage(Mat m) {
        if (!m.empty()) {
            int type = BufferedImage.TYPE_BYTE_GRAY;
            if (m.channels() > 1) {
                type = BufferedImage.TYPE_3BYTE_BGR;
            }
            int bufferSize = m.channels() * m.cols() * m.rows();
            byte[] b = new byte[bufferSize];
            m.get(0, 0, b); // get all the pixels
            BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
            final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
            System.arraycopy(b, 0, targetPixels, 0, b.length);
            return image;
        }

        return null;
    }

}



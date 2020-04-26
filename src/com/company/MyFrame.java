package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JButton scale = new JButton("scale");
        JButton rotate = new JButton("rotate");
        JButton blur = new JButton("blur");
        JButton filter2D= new JButton("2D");
        JButton sqrBox= new JButton("sqrBox");
        add(pobierz);
        add(gray);
        add(scale);
        add(rotate);
        add(blur);
        add(filter2D);
        add(sqrBox);
        JLabel label = new JLabel(); //labelka z oryginalnym obrazkiem
        add(label);


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
                    label.setIcon(new ScaleImageConverter().scaleImage(imagePath,400,300));

                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Select");
                }
            }
        });
        gray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new GreyImageConverter().toGrayImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        scale.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new ScaleImageConverter().scaleImage(imagePath,100,100);
                label.setIcon(image);
            }
        });
        rotate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new RotateImageConverter().rotateImageIcon(imagePath,90);
                label.setIcon(image);
            }
        });
        blur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter().blurImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        filter2D.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter().filter2DImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        sqrBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon image = new FilterImageConverter().sqrBoxFilterImageIcon(imagePath);
                label.setIcon(image);
            }
        });
        setVisible(true);
    }

}


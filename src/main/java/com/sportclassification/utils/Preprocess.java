//package com.sportclassification.utils;
//
//import org.opencv.core.CvType;
//import org.opencv.core.Mat;
//import org.opencv.core.Size;
//
//import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferByte;
//
//import static org.opencv.imgproc.Imgproc.*;
//
//
//public class Preprocess {
//
//    int row;
//    int col;
//
//    public Preprocess(int row, int col){
//        this.row = row;
//        this.col = col;
//    }
//
//
//    public Mat imageFiltering(BufferedImage image){
//        Mat newMat = img2Mat(image);
//        Mat resizedImage = new Mat();
//        Size scaleSize = new Size(this.row, this.col);
//        resize(newMat, resizedImage, scaleSize, 0, 0, INTER_AREA);
//        return resizedImage;
//
//    }
//
//    private static BufferedImage convertTo3ByteBGRType(BufferedImage image) {
//        BufferedImage convertedImage = new BufferedImage(image.getWidth(), image.getHeight(),
//                BufferedImage.TYPE_3BYTE_BGR);
//        convertedImage.getGraphics().drawImage(image, 0, 0, null);
//        return convertedImage;
//    }
//
//    public static Mat img2Mat(BufferedImage image) {
//        image = convertTo3ByteBGRType(image);
//        byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
//        Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
//        System.out.println(image.getWidth());
//
//        mat.put(0, 0, data);
//        return mat;
//    }
//}

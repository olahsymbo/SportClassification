package com.sportclassification;

import com.sportclassification.data.DataLoader;
import org.opencv.core.Mat;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class SportClassApp {

    public static void main(String[] args) throws IOException {
        String data_path = "/src/main/java/com/sportclassification/dataset/train";
        DataLoader dl = new DataLoader(data_path);
        List<Mat> allImages = dl.loadImages();
    }

}

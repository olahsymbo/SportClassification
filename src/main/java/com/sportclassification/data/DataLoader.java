package com.sportclassification.data;

import com.sportclassification.utils.Preprocess;
import org.opencv.core.Mat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DataLoader {

    String data_path;
    Path root = Paths.get(".").normalize().toAbsolutePath();

    public DataLoader(String data_path) {
        this.data_path = root + data_path;
    }

    public String[] imageDirectories(){
        String pathName = this.data_path;
        File file = new File(pathName);
        String[] directories = file.list((dir, name) -> new File(dir, name).isDirectory());
        return directories;
    }

    public List<Mat> loadImages(){
        String[] data = imageDirectories();
        List<Mat> allImages = new ArrayList<>();
        Preprocess prc = new Preprocess(224, 224);
        for (String datum : data) {
            String fullFolderPath = this.data_path + "/" + datum;

            File folder = new File(fullFolderPath);
            File[] imageNames = folder.listFiles();
            for (File image : imageNames) {
                if (image.isFile() && (image.getName().endsWith(".jpg")) || (image.getName().endsWith(".png"))){
                    try {
                        BufferedImage img = ImageIO.read(new File(fullFolderPath + "/" + image.getName()));
                        Mat resizedImage = prc.imageFiltering(img);
                        allImages.add(resizedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return allImages;
    }
}

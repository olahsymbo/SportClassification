package com.sportclassification;

import com.sportclassification.data.DataLoader;
import com.sportclassification.models.CNNModel;
import org.nd4j.evaluation.classification.Evaluation;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class SportClassApp {

    public static void main(String[] args) throws IOException {
        String data_path = "/src/main/java/com/sportclassification/dataset/train";
        DataLoader dl = new DataLoader(data_path);
        List<BufferedImage> allTrainImages = dl.loadImages();

        String dataTestPath = "/src/main/java/com/sportclassification/dataset/test";
        DataLoader dlTest = new DataLoader(dataTestPath);
        List<BufferedImage> allTestImages = dlTest.loadImages();

        CNNModel cnnModel = new CNNModel();
        cnnModel.train(allTrainImages);
        Evaluation output = cnnModel.evaluate(allTestImages);
        System.out.println(output);
    }

}

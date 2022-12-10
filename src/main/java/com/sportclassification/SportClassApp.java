package com.sportclassification;

import com.sportclassification.data.DataLoader;
import com.sportclassification.models.CNNModel;
import org.nd4j.evaluation.classification.Evaluation;

import java.awt.image.BufferedImage;
import java.util.List;

public class SportClassApp {

    public static void main(String[] args) {
        String data_path = "/src/main/java/com/sportclassification/dataset/train";
        List<BufferedImage> allTrainImages = DataLoader.loadImages(data_path);

        String dataTestPath = "/src/main/java/com/sportclassification/dataset/test";
        List<BufferedImage> allTestImages = DataLoader.loadImages(dataTestPath);

        CNNModel cnnModel = new CNNModel();
        cnnModel.train(allTrainImages);
        Evaluation output = cnnModel.evaluate(allTestImages);
        System.out.println(output);
    }

}

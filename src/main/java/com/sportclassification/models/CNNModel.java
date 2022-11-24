//package com.sportclassification.models;
//
//import org.deeplearning4j.nn.layers.pooling.*;
//import org.deeplearning4j.nn.layers.convolution.*;
//import org.deeplearning4j.nn.api.OptimizationAlgorithm;
//import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
//import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
//import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
//
//public class CNNModel {
//
//    MultiLayerConfiguration configuration = new NeuralNetConfiguration.Builder()
//            .seed(1611)
//            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
//            .learningRate(properties.getLearningRate())
//            .regularization(true)
//            .updater(properties.getOptimizer())
//            .list()
//            .layer(0, conv5x5())
//            .layer(1, pooling2x2Stride2())
//            .layer(2, conv3x3Stride1Padding2())
//            .layer(3, pooling2x2Stride1())
//            .layer(4, conv3x3Stride1Padding1())
//            .layer(5, pooling2x2Stride1())
//            .layer(6, dense())
//            .pretrain(false)
//            .backprop(true)
//            .setInputType(dataSetService.inputType())
//            .build();
//
//    MultiLayerNetwork network = new MultiLayerNetwork(configuration);
//
//    public void train() {
//        network.init();
//        IntStream.range(1, epochsNum + 1).forEach(epoch -> {
//            network.fit(dataSetService.trainIterator());
//        });
//    }
//
//    public Evaluation evaluate() {
//        return network.evaluate(dataSetService.testIterator());
//    }
//}

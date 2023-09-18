package ex;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    int inputSize = 1;
		    int hiddenSize = 1;
		    int outputSize = 1;
		    double learningRate = 1.0;
		    int epochs = 1000;

		    NeuralNetwork neuralNetwork = new NeuralNetwork(inputSize, hiddenSize, outputSize, learningRate);

		    double[][] inputs = {{0}, {1}};
		    double[][] targets = {{0}, {0}};
		    
		    System.out.println("before training:");
		    for (double[] input : inputs) {
		        System.out.println(Arrays.toString(neuralNetwork.feedForward(input)));
		    }

		    neuralNetwork.train(inputs, targets, epochs);

		    System.out.println("after training:");
		    for (double[] input : inputs) {
		        System.out.println(Arrays.toString(neuralNetwork.feedForward(input)));
		    }
		
	}
}

package ex;
import java.util.Arrays;

public class NeuralNetwork {
    
    private double[][] weights1; // weights between input and hidden layer
    private double[][] weights2; // weights between hidden and output layer
    
    private double[][] bias1; // biases of the hidden layer
    private double[][] bias2; // biases of the output layer
    
    private double learningRate;
    
    public NeuralNetwork(int inputSize, int hiddenSize, int outputSize, double learningRate) {
        weights1 = new double[inputSize][hiddenSize];
        weights2 = new double[hiddenSize][outputSize];
        
        //setting the biases to only hidden and output layers
        bias1 = new double[1][hiddenSize];
        bias2 = new double[1][outputSize];
        
        this.learningRate = learningRate;
        
        // initialize weights and biases with random values
        
        //initializing random weights between each input layer and its hidden layer
        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < hiddenSize; j++) {
                weights1[i][j] = Math.random() ;
            }
        }
      //initializing random weights between each hidden layer and its output layer
        for (int i = 0; i < hiddenSize; i++) {
            for (int j = 0; j < outputSize; j++) {
                weights2[i][j] = Math.random() ;
            }
        }
      //initializing random bias for the hidden layer
        for (int i = 0; i < hiddenSize; i++) {
            bias1[0][i] = Math.random() ;
        }
      //initializing random bias for the output layer
        for (int i = 0; i < outputSize; i++) {
            bias2[0][i] = Math.random() ;
        }
    }
    
    public double[] feedForward(double[] inputs) {
        // calculate values of the hidden layer
        double[] hiddenValues = new double[weights1[0].length];//to save each value of the hidden layer
        for (int i = 0; i < hiddenValues.length; i++) {
            double sum = 0;
            for (int j = 0; j < inputs.length; j++) {
                sum += inputs[j] * weights1[j][i];
            }
            hiddenValues[i] = sigmoid(sum + bias1[0][i]);
        }
        
        // calculate values of the output layer
        double[] outputValues = new double[weights2[0].length];
        for (int i = 0; i < outputValues.length; i++) {
            double sum = 0;
            for (int j = 0; j < hiddenValues.length; j++) {
                sum += hiddenValues[j] * weights2[j][i];
            }
            outputValues[i] = sigmoid(sum + bias2[0][i]);
        }
        
        return outputValues;
    }
    
    public void train(double[][] inputs, double[][] targets, int epochs) {
        for (int i = 0; i < epochs; i++) {
            for (int j = 0; j < inputs.length; j++) {
                double[] output = feedForward(inputs[j]);
                double[] errorOutput = new double[output.length];
                for (int k = 0; k < output.length; k++) {
                    errorOutput[k] = output[k] - targets[j][k];
                }
                
               double[] hiddenValues = new double[weights1[0].length];
                for (int k = 0; k < hiddenValues.length; k++) {
                    double sum = 0;
                    for (int l = 0; l < output.length; l++) {
                    	 sum += errorOutput[l] * weights2[k][l];
                    }
                    hiddenValues[k] = sigmoidDerivative(hiddenValues[k]) * sum;
                }
                
                // update weights and biases
                for (int k = 0; k < weights1.length; k++) {
                    for (int l = 0; l < weights1[0].length; l++) {
                        double weightGradient = 0;
                        for (int m = 0; m < output.length; m++) {
                            weightGradient += errorOutput[m] * sigmoidDerivative(hiddenValues[l]) * inputs[j][k];
                        }
                        weights1[k][l] -= learningRate * weightGradient;
                    }
                }
                
                for (int k = 0; k < weights2.length; k++) {
                    for (int l = 0; l < weights2[0].length; l++) {
                        double weightGradient = 0;
                        for (int m = 0; m < output.length; m++) {
                            weightGradient += errorOutput[m] * sigmoidDerivative(output[m]) * hiddenValues[k];
                        }
                        weights2[k][l] -= learningRate * weightGradient;
                    }
                }
                
                for (int k = 0; k < bias1[0].length; k++) {
                    double biasGradient = 0;
                    for (int l = 0; l < output.length; l++) {
                        biasGradient += errorOutput[l] * sigmoidDerivative(hiddenValues[k]);
                    }
                    bias1[0][k] -= learningRate * biasGradient;
                }
                
                for (int k = 0; k < bias2[0].length; k++) {
                    double biasGradient = 0;
                    for (int l = 0; l < output.length; l++) {
                        biasGradient += errorOutput[l] * sigmoidDerivative(output[l]);
                    }
                    bias2[0][k] -= learningRate * biasGradient;
                }
            }}
        }

        private double sigmoid(double x) {
            return 1 / (1 + Math.exp(-x));
        }

        private double sigmoidDerivative(double x) {
            return sigmoid(x) * (1 - sigmoid(x));
        }
}       
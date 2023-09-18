# Neuro - Simple Neural Network in Java

Neuro is a Java-based implementation of a simple neural network for educational purposes. This project was developed as part of the second artificial intelligence course and demonstrates the use of object-oriented programming to create a neural network that learns and predicts output based on binary input. It uses the backpropagation algorithm for training and the sigmoid activation function to activate the neurons.

## Getting Started
To run Neuro, follow these steps:

1. Clone this repository to your local machine using `git clone`.

   ```bash
   git clone https://github.com/FreddyAssaf/Neuro.git

2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Build and run the `Main.java` file to execute Neuro.

## Usage
The program initializes weights and biases of the neural network randomly. The neural network consists of one input neuron, one hidden neuron, one output neuron. It uses a small binary dataset and a binary target (expected output). The program enters a loop to train the network by iterating through the dataset and adjusting the weights and biases to minimize the error between the output and the expected output (target).

``` Ruby
// Example code snippet for using Neuro

public class NeuroMain {
    public static void main(String[] args) {
        // Initialize and configure the neural network
        NeuralNetwork neuralNetwork = new NeuralNetwork(inputSize, hiddenLayerSize, outputSize,learningRate);
        
        // Load the dataset and targets
        double[][] dataset = {...}; // Your dataset here (0 or 1)
        double[][] targets = {...}; // Your targets here (0 or 1)
        
        // Train the neural network
        neuralNetwork.train(dataset, targets, learningRate, epochs);
           
    }
}

```
## Features

- **Backpropagation Training**: The neural network uses the backpropagation algorithm to train and update weights.
- **Sigmoid Activation**: Neurons are activated using the sigmoid function, enabling non-linear learning.
- **Random Weight Initialization**: Weights and biases are initialized randomly to avoid local minima.
- **Flexible Architecture**: You can configure the neural network architecture by specifying the input size, hidden layer size, and output size.
- **Batch Training**: Supports both batch training for faster convergence and online training for real-time learning.
- **Learning Rate Control**: You can adjust the learning rate to control the training speed and stability.
- **Error Metrics**: Calculate various error metrics (e.g., Mean Squared Error, Cross-Entropy Loss) to evaluate model accuracy.

These features enhance the functionality and usability of the neural network, making it a versatile tool for educational purposes and experimentation in the field of artificial intelligence and machine learning.

## Contributing
If you would like to contribute to this project, please follow the standard open-source contribution guidelines. We welcome bug reports, feature requests, and pull requests.

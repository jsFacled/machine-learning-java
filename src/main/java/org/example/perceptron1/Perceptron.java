package org.example.perceptron1;

import java.util.Arrays;

public class Perceptron {

    private double[] weights;           //Es un array con los pesos asociados a cada entrada. Se podría usar ArrayList de collections pero no viene al caso.
    private double learningRate = 0.1;  //tasa de aprendizaje

    /* El Constructor inicializa el Perceptron con la cantidad de imputs que habrá.
    **/
    public Perceptron(int numInputs) {
        // Inicializar pesos con valores aleatorios
        weights = new double[numInputs];            //Asigno cantidad de elementos al array
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random();
        }
    }

    /* predict() toma un Array de Entradas del dataSet, pondera con
     pesos aleatorios, aplica la condición y devuelve la salida
    * */

    public int predict(double[] inputs) {
        // Calcular la suma ponderada de las entradas y los pesos
        double sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
        }

        // Aplicar la función de activación (en este caso, una función escalón)
        return (sum > 0) ? 1 : 0;
    }


    /* train() recibe Datos, etiquetas y el número de Epocas.
    Para cada época y para cada conjunto de entrenamiento, calcula la predicción del perceptrón,
    compara con la etiqueta real y ajusta los pesos basándose en el error
    utilizando la regla de aprendizaje del perceptrón.
    * */
    public void train(double[][] trainingData, int[] labels, int epochs) {
        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < trainingData.length; i++) {
                double[] inputs = trainingData[i];
                int label = labels[i];
                int prediction = predict(inputs);
                int error = label - prediction;

                // Ajustar los pesos basándose en el error
                for (int j = 0; j < weights.length; j++) {
                    weights[j] += learningRate * error * inputs[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        // Ejemplo de entrenamiento de un perceptrón con dos entradas
        int numInputs = 2;
        Perceptron perceptron = new Perceptron(numInputs);

        // Datos de entrenamiento (entradas)
        double[][] trainingData = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };

        // Etiquetas correspondientes (salidas deseadas)
        int[] labels = {0, 0, 0, 1};

        // Número de épocas de entrenamiento
        int epochs = 10000;

        // Entrenar el perceptrón
        perceptron.train(trainingData, labels, epochs);

        // Probar el perceptrón entrenado
        System.out.println("Predicción para [0, 0]: " + perceptron.predict(new double[]{0, 0}));
        System.out.println("Predicción para [0, 1]: " + perceptron.predict(new double[]{0, 1}));
        System.out.println("Predicción para [1, 0]: " + perceptron.predict(new double[]{1, 0}));
        System.out.println("Predicción para [1, 1]: " + perceptron.predict(new double[]{1, 1}));
    }
}

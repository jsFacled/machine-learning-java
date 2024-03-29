package org.example.perceptron1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.perceptron1.PerceptronSimple1.multiplicacionEscalar;

public class MainPerceptronSimple1 {
    public static void main(String[] args) {
        //Pruebo la multiplicacion escalar
        List<Integer> vector1 = new ArrayList<>();
        vector1.add(1);
        vector1.add(2);
        vector1.add(3);

        List<Double> vector2 = new ArrayList<>();
        vector2.add(4.0);
        vector2.add(5.0);
        vector2.add(6.0);

        //Otra forma
        List<Integer> vector3 = Arrays.asList(7, 8, 9);
        List<Double> vector4 = Arrays.asList(10.0, 11.0, 12.0);
        double resultado = multiplicacionEscalar(vector1, vector2);
        System.out.println("Multiplicación Escalar: " + resultado);

        double resultado2 = multiplicacionEscalar(vector3, vector4);
        System.out.println("Multiplicación Escalar: " + resultado2);
        //Fin prueba multiplicacion escalar

        /*
              --------------------------------------
              ----  Pruebo el PerceptronSimple1  ----
              --------------------------------------
        */

// Definimos los pesos y el umbral
        List<Double> pesos = Arrays.asList(0.5, 0.2);
        //double[] pesos = {0.5, 0.2};
        double umbral = 0.5;

        // Definimos la edad y el ahorro de la persona
        int edad = 30;
        int ahorro = 10000;

        // Representamos a la persona
        List<Integer> entradas = new ArrayList<>();
        entradas.add((int) edad);
        entradas.add((int) ahorro);

        // Calculamos la salida del perceptrón
        int salida = PerceptronSimple1.activationFunction(entradas, pesos, umbral);

        // Imprimimos el resultado
        if (salida == 1) {
            System.out.println("Se le da el crédito");
        } else {
            System.out.println("No se le da el crédito");
        }

   /*
              --------------------------------------
              ----  Pruebo el PerceptronSimple1 Constructor  ----
              --------------------------------------
        */
        System.out.println("***** --------- Prueba de Constructor ------------- *******");
        PerceptronSimple1 p1=new PerceptronSimple1(vector1);
        System.out.println("El p1 tiene: "+ p1.toString());
/*
              --------------------------------------
              ----  Pruebo Entrenamiento segun Chatgpt  ----
              --------------------------------------
        */

        System.out.println("------------------ Entrenamiento Chatgpt ------------------");

        // Crear un perceptrón con un vector de entrada
        List<Integer> vectorEntrada = Arrays.asList(1, 2, 3);
        PerceptronSimple1 perceptron = new PerceptronSimple1(vectorEntrada);

        //Definir Bias y factor de entrenamiento
        perceptron.setBias(1.00);
        perceptron.setFactorAprendizaje(0.5);

        // Definir entradas de entrenamiento y resultado deseado
        List<Integer> entradasEntrenamiento = Arrays.asList(1, 2, 3);
        int resultadoDeseado = 1;

        // Imprimir pesos antes del entrenamiento
        System.out.println("Pesos antes del entrenamiento: " + perceptron.getVectorW());

        // Entrenar el perceptrón
        perceptron.entrenarSegunChatgpt(entradasEntrenamiento, resultadoDeseado);

        // Imprimir pesos después del entrenamiento
        System.out.println("Pesos después del entrenamiento: " + perceptron.getVectorW());

        // Realizar una predicción después del entrenamiento
        int prediccionDespuesEntrenamiento = perceptron.activationFunction(entradasEntrenamiento, perceptron.getVectorW(), perceptron.getBias());
        System.out.println("Predicción después del entrenamiento: " + prediccionDespuesEntrenamiento);

/*
              --------------------------------------
              ----  Pruebo Entrenamiento segun Bard  ----
              --------------------------------------
        */


        System.out.println("------------------ ------------------");
        System.out.println("------------------ Entrenamiento Bard ------------------");
        System.out.println("------------------  ------------------");
                     // Definimos los datos de entrada
                List<Integer> vectorX = new ArrayList<>();
                vectorX.add(0);
                vectorX.add(0);

                // Definimos los pesos y el sesgo
                List<Double> vectorW = new ArrayList<>();
                vectorW.add(0.5);
                vectorW.add(0.5);

                // Creamos el perceptrón
                PerceptronSimple1 perceptronBard = new PerceptronSimple1(vectorX);
        perceptronBard.setFactorAprendizaje(0.5);
       perceptronBard.setBias(1.00);

                // Definimos los datos de entrenamiento
                List<List<Integer>> datosEntrenamiento = new ArrayList<>();
                datosEntrenamiento.add(Arrays.asList(0, 0));
                datosEntrenamiento.add(Arrays.asList(0, 1));
                datosEntrenamiento.add(Arrays.asList(1, 0));
                datosEntrenamiento.add(Arrays.asList(1, 1));

                // Definimos los valores esperados
                List<Integer> vectorY = Arrays.asList(0, 1, 1, 1);

                // Entrenamos el perceptrón
        perceptronBard.entrenarSegunBard(datosEntrenamiento, vectorY);

                // Probamos el perceptrón con nuevos datos
                int salidaBard = perceptronBard.activationFunction(Arrays.asList(0, 0), vectorW, perceptron.getBias());
                System.out.println("Salida para (0, 0): " + salidaBard);

        salidaBard = perceptronBard.activationFunction(Arrays.asList(0, 1), vectorW, perceptron.getBias());
                System.out.println("Salida para (0, 1): " + salidaBard);

        salidaBard = perceptronBard.activationFunction(Arrays.asList(1, 0), vectorW, perceptron.getBias());
                System.out.println("Salida para (1, 0): " + salidaBard);

        salidaBard = perceptronBard.activationFunction(Arrays.asList(1, 1), vectorW, perceptron.getBias());
                System.out.println("Salida para (1, 1): " + salidaBard);





    }
}

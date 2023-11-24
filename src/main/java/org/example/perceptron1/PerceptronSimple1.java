package org.example.perceptron1;

import java.util.List;

public class PerceptronSimple1 {

    // Definimos atributos: datos de entrada y pesos.
    private List<Integer> vectorX;
    private List<Double> vectorW;

   // Definimos función de activación: ingresa Pesos, Entradas y Umbral y determina si es 1 o 0.

    public static int activationFunction(List<Integer> vectorX, List<Double> vectorW, Double b) {


       // Multiplicación escalar
        Double sumaPonderada = multiplicacionEscalar(vectorX, vectorW);

        // Suma del umbral, el cual no conocemos
        Double sumaPonderadaConB = sumaPonderada + b;

        //Función de umbral escalón
        if (sumaPonderadaConB >= 0) {
            return 1;
        } else {
            return 0;
        }

    }

//Defino el método multiplicación escalar
    public static double multiplicacionEscalar(List<Integer> vX, List<Double> vW) {
        //Valido que tengan la misma cantidad de elementos y que no estén vacíos
        if (vX == null || vW == null || vX.size() != vW.size()) {
            throw new IllegalArgumentException("Los vectores deben ser no nulos y tener la misma longitud");
        }

        double resultado = 0.0;
        for (int i = 0; i < vX.size(); i++) {
            resultado += vX.get(i) * vW.get(i);
        }
        return resultado;
    }

}

package org.example.perceptron1;

import java.util.List;

public class PerceptronSimple1 {
   // Definimos función de activación: ingresa Pesos, Entradas y Umbral y determina si es 1 o 0.

    public static int activationFunction(List<Double> vectorX, List<Double> vectorW, Double b) {


       // Multiplicación escalar
        Double vectorZ = multiplicacionEscalar(vectorW, vectorX);

        // Suma del umbral, el cual no conocemos
        Double resultadoConB = vectorZ + b;

        //Función de umbral
        if (resultadoConB >= 0) {
            return 1;
        } else {
            return 0;
        }

    }

//Defino el método multiplicación escalar
    public static double multiplicacionEscalar(List<Double> v1, List<Double> v2) {
        //Valido que tengan la misma cantidad de elementos y que no estén vacíos
        if (v1 == null || v2 == null || v1.size() != v2.size()) {
            throw new IllegalArgumentException("Los vectores deben ser no nulos y tener la misma longitud");
        }

        double resultado = 0.0;
        for (int i = 0; i < v1.size(); i++) {
            resultado += v1.get(i) * v2.get(i);
        }
        return resultado;
    }

}

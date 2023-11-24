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
        System.out.println("El p1 tiene: "+ p1.getClass());





    }
}

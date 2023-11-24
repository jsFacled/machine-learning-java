package org.example.perceptron1;

import java.util.ArrayList;
import java.util.List;


public class PerceptronSimple1 {

    // Definimos atributos: datos de entrada, pesos, factorAprendizaje y Bias.
    private List<Integer> vectorX;
    private List<Double> vectorW;
    private Double factorAprendizaje;
    private Double bias;

    // Definir Constructor
    public PerceptronSimple1 (List<Integer> vectorX){
        // Se crea Perceptron con vector de Entradas.
        this.vectorX=vectorX;
        // Inicializar pesos con valores aleatorios
        int cantidadX = vectorX.size();
        vectorW = new ArrayList<>(cantidadX);  //Asigno cantidad de elementos al array

        for (int i = 0; i < cantidadX; i++) {
            vectorW.add(Math.random());
        }
        System.out.println("Imprimo arrayW:   " + vectorW);
        System.out.println("El perceptrónSimple1 ha sido creado");
    }


    // Definimos función de activación: ingresa Pesos, Entradas y Umbral y determina si es 1 o 0.

    public static int activationFunction(List<Integer> vectorX, List<Double> vectorW, Double bias) {


       // Multiplicación escalar
        Double sumaPonderada = multiplicacionEscalar(vectorX, vectorW);

        // Suma del umbral, el cual no conocemos
        Double sumaPonderadaConB = sumaPonderada + bias;

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

/*
----------------------  Entrenadores ----------------------
==========================================================
 */
public void entrenarSegunChatgpt(List<Integer> entradas, int resultadoDeseado) {
    // Lógica de entrenamiento básica: ajustar los pesos si la predicción es incorrecta
    int prediccion = activationFunction(entradas, vectorW, bias);

    if (prediccion != resultadoDeseado) {
        // Ajustar pesos y bias según la lógica de entrenamiento
        for (int i = 0; i < vectorW.size(); i++) {
            double nuevoPeso = vectorW.get(i) + factorAprendizaje * (resultadoDeseado - prediccion) * entradas.get(i);
            vectorW.set(i, nuevoPeso);
        }
        // Ajustar el bias
        bias = bias + factorAprendizaje * (resultadoDeseado - prediccion);
    }
}

    public void entrenarSegunBard(List<List<Integer>> datosEntrenamiento, List<Integer> vectorY) {
        // Repite el proceso de entrenamiento para un número determinado de épocas
        for (int epoca = 0; epoca < 100; epoca++) {
            // Itera sobre cada dato de entrenamiento
            for (int i = 0; i < datosEntrenamiento.size(); i++) {
                List<Integer> vectorX = datosEntrenamiento.get(i);
                int salidaEsperada = vectorY.get(i);

                // Calcula la salida actual
                int salidaActual = activationFunction(vectorX, vectorW, bias);

                // Calcula el error
                int error = salidaEsperada - salidaActual;

                // Actualiza los pesos
                for (int j = 0; j < vectorW.size(); j++) {
                    vectorW.set(j, vectorW.get(j) + error * factorAprendizaje * vectorX.get(j));
                }

                // Actualiza el sesgo
                Double delta = error * factorAprendizaje;
                Double nuevoBias = bias + delta;
                setBias(nuevoBias);
            }
        }
    }



    /*
    ---------------------------------------------------
    --------------    getters y setters   -------------
    ---------------------------------------------------
     */

    public List<Integer> getVectorX() {
        return vectorX;
    }

    public void setVectorX(List<Integer> vectorX) {
        this.vectorX = vectorX;
    }

    public List<Double> getVectorW() {
        return vectorW;
    }

    public void setVectorW(List<Double> vectorW) {
        this.vectorW = vectorW;
    }

    public Double getFactorAprendizaje() {
        return factorAprendizaje;
    }

    public void setFactorAprendizaje(Double factorAprendizaje) {
        this.factorAprendizaje = factorAprendizaje;
    }

    public Double getBias() {
        return bias;
    }

    public void setBias(Double bias) {
        this.bias = bias;
    }

    @Override
    public String toString() {
        return "PerceptronSimple1{" +
                "vectorX=" + vectorX +
                ", vectorW=" + vectorW +
                ", factorAprendizaje=" + factorAprendizaje +
                ", bias=" + bias +
                '}';
    }
}

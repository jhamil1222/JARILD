package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //new capas_neuronales(12,13, null);
        //mul.impMat(new double[][]{new error().restaVect(new double[]{2,3,4},new double[]{1,2})});
        //System.out.println(inclusion.mediaVect( inclusion.restaVect(new double[]{4,5,6},new double[]{1,2,3})));
        //double [] vanal=inclusion.powVect(new double[]{2,2,2},2);
        //mul.impMat(new double[][]{vanal});
        double[][] x = {{0.05, 0.10,0.99}};

        double[][][] w = {{{0.15, 0.20},{0.8,0.9}, {0.25, 0.30}}, {{0.40, 0.45},{0.7,0.6}, {0.50, 0.55}}};
        //existe un problema con lso arrays por ello no recomiendo trabajar con arrays en una misma funcion por que esto es lo que pasa ya que se contamina la memoria
        double[][][] cusito = new double[][][]{w[0], w[1]};
        //por ello existe una mejor forma de hacer una copia de un array
        // por lo que se ve la unica forma es crear un contenedor de variables que dependa del rendimiento
        //asignarle a una matriz otra matriz da lugar a lo que yo llamo desastre estatico ya que la
        //matriz se parece a un conjunto de variables estaticas en una clase no se asigna directo sino de uno en uno


        //nota seguir de serca x que tuene una contaminacion de meoria mouy importante
        double[][][] yugo = MatJa.memoriaFantasma(new double[][][]{x});
        double[][] b = {{0.35, 0.60,0.8}};
        double[][] y = {{0.01, 0.99,0.9,0.8}};
        /*Verificar que esta parte sea viable por varias razones estoy hablando de h
         *
         * */
        int numeroNeur=2;
        int numeroCon=y[0].length;
        b=randMat.random(1,numeroNeur,-1,1,false);
        //mejorar este lado
        w=new double[][][]{randMat.random(numeroCon,numeroNeur,-1,1,false),randMat.random(numeroCon,numeroNeur,-1,1,false)};
        cusito = MatJa.memoriaFantasma(w);

        double ratio = 0.5;
        double salidas[][][] = new double[w.length][x.length][x.length];
        double capaact[][][] = new double[w.length][x.length][x.length];
        /*con este for separamos las salidas de las capas y las salidas de
        las neuronas son la variable capaact tenemos las salidas neuronales de funcion de activacion
        y la
        variable salidas tiene como resultado las salidas neuronales
         */

        for (int ge = 0; ge < 10000; ge++) {
        for (int gato = 0; gato < w.length; gato++) {
            x = MatJa.SumVectno(MatJa.result(x, MatJa.matTi(w[gato])), b[0][gato]);
            salidas[gato] = x;

            x = funcion_Act.sigm(x)[0];
            capaact[gato] = x;


        }
        //aqui estamos evaluando las ultimas capas obteniendo el error desde la ultima capa
        //famoso backpropagetion
        //error total de toda la red

        //aqui usamos los datos de la ultima capa de activacion que en todo caso sera dado por las capa de act
        //System.out.println(capaact[0][0][0]);
        int numerito = capaact.length - 1;
        //se evalua la ultima capa por ende tambien evaluaremos a w6
        double erri = 0;
        double[] erro = new double[capaact.length];
        int oli = 0;
        double errorW = 0;
        double put = 0;
        int sopas = 0;
        double[][] err = new double[capaact.length][capaact[0].length];
        double[] wu = new double[w.length * w[0].length];

        double pol = 0;
        double pio = 0;
        double bugx = 0;
        double g = 0;
        double polill = 0;
        double[][] poli;
        double pico = 0;
        double kuma = 0;
        double li = 0;


            //con este for evaluamos la ultima capa o capa de salida y todos sus valores
            sopas=0;
            for (int gat = 0; gat < capaact.length; gat++) {

                for (oli = 0; oli < w[gat][0].length; oli++) {
                    //aqui tenemos el error total evaluado en la ultima capa
                    erri = error.errCua(y, capaact[numerito])[0][0][0];
                    //System.out.println(erri);
                    //derivada del error total en base a la salida final
                    erro[gat] = -(error.errCua(y, capaact[numerito])[1][0][gat]);

                    //derivada de la activacion en base a la salida como tenemos 2 vectores no nos
                    //perocuparemos por los demas solo sabemos que serviran
                    //y2Fin*(1-y2Fin)
                    wu[sopas] = erro[gat];
                    err = MatJa.mulTiGran(capaact[numerito], (MatJa.restonVect(MatJa.ingresEnt(capaact[numerito], 1), capaact[numerito])));
                    //hacemos la famosa chein rool
                    //MatJa.impMat(capaact[numerito]);
                    //System.out.println(erro*error[0][0]);
                    //calculamos el error que viene dado a w5

                    errorW = erro[gat] * err[0][gat] * capaact[0][0][gat];
                    //System.out.println(error[0][gat] );
                    //nota aqui modificar esta variable ya que estamos usando el valor de capaact
                    put = w[1][gat][oli];

                    //calculamos el peso actualizado
                    //reemplazar gat y oli por razones de optimizacion ya que solo estan dadas a dos valores
                    w[1][gat][oli] = put - (ratio * errorW);

                    sopas++;
                }
            }
            /*aqui evaluaremos las capas ocultas pero eso si hay que modificar algunas cosas ya que estamos trabajando con
             *las demas capas restantes y en este caso ya no habria que tomar solo una capa
             */

            for (int gat = 0; gat < capaact[1][0].length; gat++) {
                for (oli = 0; oli < w[0][gat].length; oli++) {
                    //backpropagetion capas ocultas
                    pio = 2 * (1.0 / 2.0) * (y[0][0] - capaact[capaact.length - 2][0][gat]) * (-1) * err[0][0];
                    pol = 2 * (1.0 / 2.0) * (y[0][1] - capaact[capaact.length - 2][0][gat]) * (-1) * err[0][1];

                    bugx = pio * cusito[1][0][0];
                    g = pol * cusito[1][1][0];
                    polill = bugx + g;
                    poli = MatJa.mulTiGran(capaact[0], (MatJa.restonVect(MatJa.ingresEnt(capaact[0], 1), capaact[0])));
                    // MatJa.impMat(poli);
                    pico = yugo[0][0][0];
                    kuma = polill * poli[0][0] * pico;
                    //MatJa.impMat(capaact[0]);
                    //aqui usamos w por que nesecitamos contaminar la memoria pero
                    //cuando nesecitemos una copia de la varible tendremos que recurrir a memoria fantasma
                    li = w[0][gat][oli] - (ratio * kuma);
                    w[0][gat][oli] = li;
                    sopas++;
                }
            }
            //MatJa.impMat( h[1]);
            //MatJa.impMat(h);
            //double[][] poli=MatJa.SumVectno(h,b);

           // System.out.printf("tu error es de %.9f",erri);
        }
        System.out.println("salidas de la neurona");
        MatJa.impMat(capaact[1]);
        System.out.printf("%.6f",error.errCua(y, capaact[1])[0][0][0]);
    }

    }

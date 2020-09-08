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
        double[][] x = {{0.05, 0.10}};
        double[][][] w = {{{0.15, 0.20}, {0.25, 0.30}}, {{0.40, 0.45}, {0.50, 0.55}}};
        double[][] b = {{0.35, 0.60}};
        double[][] y = {{0.01, 0.99}};
        /*Verificar que esta parte sea viable por varias razones estoy hablando de h
         *
         * */
        double ratio = 0.5;
        double salidas[][][] = new double[w.length ][x.length][x.length];
        double capaact[][][] = new double[w.length ][x.length][x.length];
        /*con este for separamos las salidas de las capas y las salidas de
        las neuronas son la variable capaact tenemos las salidas neuronales de funcion de activacion
        y la
        variable salidas tiene como resultado las salidas neuronales
         */
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
        int numerito=capaact.length-1;
        //se evalua la ultima capa por ende tambien evaluaremos a w6
        double erri=0;
        double []erro=new double[capaact.length];
        int oli=0;
        int gat=0;
        int sopas=0;
        double[] wu=new double[w.length*w[0].length];
        for(gat=0; gat<capaact.length;gat++) {
            System.out.println(gat);
          for(oli=0; oli<w[gat][0].length; oli++) {
              erri = error.errCua(y, capaact[numerito])[0][0][0];
              //derivada del error total en base a la salida final
              erro[gat] = -(error.errCua(y, capaact[numerito])[1][0][0]);
              MatJa.impMat(capaact[0]);
              //derivada de la activacion en base a la salida como tenemos 2 vectores no nos
              //perocuparemos por los demas solo sabemos que serviran
              double[][] error = MatJa.result(capaact[numerito], (MatJa.restonVect(MatJa.ingresEnt(capaact[numerito], 1), capaact[numerito])));
              //hacemos la famosa chein rool
              //MatJa.impMat(capaact[numerito]);
              //System.out.println(erro*error[0][0]);
              //calculamos el error que viene dado a w5
              double errorw5 = erro[gat] * error[0][gat] * capaact[0][0][gat];

              double gato = w[1][0][oli];

              //calculamos el peso actualizado
              wu[sopas] = gato - ratio * errorw5;
                sopas++;
          }
        }
        System.out.println(wu[2]);

        //matT.impMat(capa[1]);
        //MatJa.impMat( h[1]);
        //MatJa.impMat(h);
        //double[][] poli=MatJa.SumVectno(h,b);
    }


    }

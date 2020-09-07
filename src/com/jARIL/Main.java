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
        double [][]x={{0.05,0.10}};
        double [][][]w={{{0.15,0.20},{0.25,0.30}},{{0.40,0.45},{0.50,0.55}}};
        double [][]b={{0.35,0.60}};
        double[][]y={{0.01,0.99}};
        /*Verificar que esta parte sea viable por varias razones estoy hablando de h
        *
        * */
        double salidas[][][]=new double [w.length+1][x.length][x.length];
        double capaact [][][]=new double [w.length+1][x.length][x.length];
        /*con este for separamos las salidas de las capas y las salidas de
        las neuronas son la variable capaact tenemos las salidas neuronales de funcion de activacion
        y la
        variable salidas tiene como resultado las salidas neuronales
         */
        for(int gato=0; gato<w.length; gato++){
           x = MatJa.SumVectno(MatJa.result(x, MatJa.matTi(w[gato])),b[0][gato]);
           salidas[gato]=x;

           x=funcion_Act.sigm(x)[0];
           capaact[gato]=x;


        }
        double erri=error.errCua(y,capaact[1])[0][0][0];


        //matT.impMat(capa[1]);
        //MatJa.impMat( h[1]);
        //MatJa.impMat(h);
        //double[][] poli=MatJa.SumVectno(h,b);
    }


    }

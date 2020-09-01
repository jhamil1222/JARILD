package com.jARIL;

public class Main {

    public static void main(String[] args) {
      //new capas_neuronales(12,13, null);
        //mul.impMat(new double[][]{new error().restaVect(new double[]{2,3,4},new double[]{1,2})});
       //System.out.println(inclusion.mediaVect( inclusion.restaVect(new double[]{4,5,6},new double[]{1,2,3})));
       //double [] vanal=inclusion.powVect(new double[]{2,2,2},2);
       //mul.impMat(new double[][]{vanal});
        double[][] X = {{2,2,1,2}, {1,2,2,2, 1},{0,2,2,0,1,0}};
        int numeroCon = X.length, numeroNeur =X[0].length;
        double W[][] = randMat.random(numeroCon, numeroNeur, -1, 1, false);
        double[][] b = randMat.random(numeroCon, numeroNeur, -1, 1, false);
        double[][] z;
        double[][][] polilla=null;
        for(int qui=0;qui<50000; qui++) {

          z= MatJa.SumVect(MatJa.result(W, X), b);
            //MatJa.impMat(error.errCua(funcion_Act.sigm(z)[0], X)[0]);
            polilla = error.errCua(funcion_Act.sigm(z)[0], X);

            //MatJa.impMat(MatJa.restonVect(W, MatJa.result(MatJa.ingresEnt(W, 0.001), polilla[1])));


            MatJa.impMat(z);
            W=MatJa.restonVect(W, MatJa.result(MatJa.ingresEnt(W, 0.01), polilla[1]));
            b=MatJa.restonVect(b, MatJa.result(MatJa.ingresEnt(b, 0.01), polilla[1]));
        }
        System.out.println("error");

        MatJa.impMat(polilla[0]);
        MatJa.impMat(W);

    }

}
package com.jARIL;

import java.util.ArrayList;

public class backprop {
    public static double[][] ultimaCapa(double[][] actiUl,double[][] resultEntre,double[][] actCapaAnt){
        double[][][]poli=new double[actiUl[actiUl.length-1].length][][];
        poli[0]=error.errCua(resultEntre,actiUl)[1];
        ArrayList<double[][]>pul=new ArrayList<>();
        pul.add(funcion_Act.sigm(actiUl)[1]);
        double[][] poi=MatJa.memoriaFantasma(actCapaAnt);

return null;

    }
}

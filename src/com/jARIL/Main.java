package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
    proceso pi=new proceso();
    //nota no podras establecer neuronas de entrada mayores a las salidas
        double[][]x=new double[][]{{1,1},{1,0},{1,0}};

        double[][]r=new double[][]{{4,2,3},{1,2,3}};
        double [][]y=new double[][]{{1}};
        //MatJa.impMat(MatJa.result(x,w));
    //MatJa.impMat(MatJa.inse1(x,1));
       //MatJa.impMat (MatJa.ingre1(x,3));
        /*recordar que hay que establecer una fucnion de activacion por neurona por ello
        la nueva cadena de arrays no tendra que ser mayor a los enteros que representan el numero de
         neuronas por capa*/
        /* la primera capa tiene que ser igual al numero de columnas de la entrada*/
        pi.train(new int[]{2,1,1,4,2,8},new String[]{"sigm","sigm","sigm","sigm","sigm","sigm"},x,y,true,0.001);

        //MatJa.impMat(MatJa.result(x,w));
        //MatJa.impMat(MatJa.MAX(MatJa.ingresEnt(x,0),x));
        //MatJa.impMat(funcion_Act.relu(x)[0]);
		//MatJa.impMat(MatJa.result(po,pil));
    
    }
}

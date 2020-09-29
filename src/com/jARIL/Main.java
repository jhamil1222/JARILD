package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
    modificacion pi=new modificacion();
    //nota no podras establecer neuronas de entrada mayores a las salidas
        double[][]x=new double[][]{{0.05,0.10}};

        double[][]r=new double[][]{{0.75136507,0.772928465}};
		double[][]o=new double[][]{{4,2,3},{1,2,3}};
        double [][]y=new double[][]{{ 0.01,0.99}};
		//MatJa.impMat( MatJa.result(o,r));
       // MatJa.impMat( funcion_Act.sigm(y)[1]);
        //MatJa.impMat(error.errCua(r,y)[0]);
      
           // MatJa.impMat(MatJa.restonVect(y,r));
        //MatJa.impMat(MatJa.result(x,w));
    //MatJa.impMat(MatJa.inse1(x,1));
       //MatJa.impMat (MatJa.ingre1(x,3));
        /*recordar que hay que establecer una fucnion de activacion por neurona por ello
        la nueva cadena de arrays no tendra que ser mayor a los enteros que representan el numero de
         neuronas por capa*/
        /* la primera capa tiene que ser igual al numero de columnas de la entrada*/
        pi.train(new int[]{2,2,2},new String[]{"sigm","sigm","sigm","sigm","sigm","sigm"},x,y,true,0.001);

        //MatJa.impMat(MatJa.result(x,w));
        //MatJa.impMat(MatJa.MAX(MatJa.ingresEnt(x,0),x));
        //MatJa.impMat(funcion_Act.relu(x)[0]);
		//MatJa.impMat(MatJa.result(po,pil));
    
    }
}

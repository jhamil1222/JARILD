package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;
//import MatJa.MatJa;
public class Main {
       
    public static void main(String[] args) {
   
    modificacion pi=new modificacion();
    //nota no podras establecer neuronas de entrada mayores a las salidas
        double[][]x=new double[][]{{0.05,0.10},{1,2}};
        /*Nota aqui la entrada solo podra ser definida por una fila no se puede establecer una buen configuracion*/
        double[][]r=new double[][]{{6},{3},{1},{2}};
		double[][]o=new double[][]{{2,4}};
        double [][]y=new double[][]{{ 0.01,0.99}};
        modificacion pul=new modificacion();
        
        pul.train(new int[]{4,4,2},new String[]{"relu","relu","relu"},x,y,true,0.01);
       
    }
}

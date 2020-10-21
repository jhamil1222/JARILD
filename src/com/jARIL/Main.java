package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;
//import MatJa.MatJa;
public class Main {
       
    public static void main(String[] args) {
   
    //modificacion pi=new modificacion();
    //nota no podras establecer neuronas de entrada mayores a las salidas
        double[][]x=new double[][]{{1,0}};
        /*Nota aqui la entrada solo podra ser definida por una fila no se puede establecer una buen configuracion*/
        double[][]r=new double[][]{{1},{1},{1},{1}};
		double[][]o=new double[][]{{2}};
        double [][]y=new double[][]{{1}};
        modificacion pul=new modificacion(x,new int[]{4,4,1});
        double [][] poro=new double[0][0];
        //MatJa.impMat(MatJa.SumVect(r, o));
        for (int po=0; po<=50000000; po++){
            if(po%500==0){
                System.out.println("iteracion"+po);
            }
        pul.train(new String[]{"sigm","sigm","sigm"},y,true,0.01);
        }
        poro=pul.train(new String[]{"sigm","sigm","sigm"},y,false,0.01);
        MatJa.impMat(poro);
       
        
    
        //MatJa.powVectM(1, , true)
       //MatJa.impMat(MatJa.result(o,r));
    }}


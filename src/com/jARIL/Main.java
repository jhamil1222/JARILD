package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;
//import MatJa.MatJa;
public class Main {
       
    public static void main(String[] args) {
   
    //modificacion pi=new modificacion();
    //nota no podras establecer neuronas de entrada mayores a las salidas
        double[][]x=new double[][]{{1,0},{0,1}};
        /*Nota aqui la entrada solo podra ser definida por una fila no se puede establecer una buen configuracion*/
        double[][]r=new double[][]{{1},{1},{1},{1}};
		double[][]o=new double[][]{{0,0},{1,0}};
        double [][]y=new double[][]{{1},{0}};
        RedNeur pul=new RedNeur(x,new int[]{4,4,1});
        double [][] poro=new double[0][0];
        //MatJa.impMat(MatJa.SumVect(r, o));
        for (int po=0; po<=50000; po++){
            if(po%500==0){
                System.out.println("iteracion"+po);
            }
        pul.train(new String[]{"sigm","sigm","sigm"},y,true,0.01);
        }
        poro=pul.train(new String[]{"sigm","sigm","sigm"},y,false,0.01);
        System.out.println("se entreno");
        MatJa.impMat(poro);
        System.out.println("pruebas");
   
        MatJa.impMat(pul.run(o));
        
    
        //MatJa.powVectM(1, , true)
       //MatJa.impMat(MatJa.result(o,r));
    }}


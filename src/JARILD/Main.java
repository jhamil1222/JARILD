/*
 * NOTA ESTE TEXTO ES SOLO PARA PRUEBAS Y MUESTRA DE EJMPLO DE COMO FUNCIONA 
 */
package JARILD;


import Funciones_Acti.*;
import java.security.SecureRandom;
import java.util.Random;
//import MatJa.MatJa;
import JARILD.NeuralNetwork;
import JARILD.funcion_Act;
public class Main {
       public static boolean iteracion=false;
       
    public static void main(String[] args) {
   
    //modificacion pi=new modificacion();
    //nota no podras establecer neuronas de entrada mayores a las salidas
        double[][]x=new double[][]{{1,0},{0,1}};
        /*Nota aqui la entrada solo podra ser definida por una fila no se puede establecer una buen configuracion*/
        double[][]r=new double[][]{{1},{1},{1},{1}};
		double[][]o=new double[][]{{0,1},{1,0}};
        double [][]y=new double[][]{{1},{0}};
        NeuralNetwork pul=new NeuralNetwork();
        
        double [][] poro=new double[0][0];
        //MatJa.impMat(MatJa.SumVect(r, o));
        /*x,new int[]{4,4,1}
        new String[]{"sigm","sigm","sigm"},y,false,0.01
        */
        pul.iteracion=true;
        pul.MostrarEr=true;
        //pul.MostrarEr=true;
        pul.Neurona(new funcion_Act[]{new sigm(), new relu(),new sigm(),new sigm()},x,y, new int[]{4,4,1}, 0.4,20000);
        
        System.out.println("pruebas");
        
       /*
        for(gatito poli:pul.UPentre){
            MatJa.impMat(poli.peso);
        }*/
        MatJa.impMat(pul.run(o));
       
        
    
        //MatJa.powVectM(1, , true)
       //MatJa.impMat(MatJa.result(o,r));
    }}

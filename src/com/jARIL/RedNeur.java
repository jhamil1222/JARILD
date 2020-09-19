package com.jARIL;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class RedNeur {
    /**despues de un largo tiempo mejore una clase que tiene lo que nesecita una red neuronal pero
     * multicapa para poder hacer las convulacionales o otras se mejorara esta clase con opciones mejore
     * @autor jhamil
     * @version 0.1-Beta
     * **/
    public double[][] pesos;
    public double[][] umbral;
    public String[] funcionA;
    /*primero que nada inicializaremos la neurona con valores aleatorios para ello neurna
    *como tenemos un cierto numero de conexiones entonces pondre varibles para las conexiones como tambien
    * la funcion inicializara valores aleatorios*/
    /*para evitar problemas con la inicializacion del azar osea un mismo valor usare un valor aparte*/
    public RedNeur neurna(int numeroCon, int numeroNeur, String []funcionA){
        pesos=new double[1][1];
        umbral=new double[1][1];
    //casi siempre el valor de las conexiones por neurona biene dadopor el area de la matriz que manejaremos
        pesos=MatJa.random(numeroCon,numeroNeur,-1,1);
        //como el umbral biene dado por neurona entonces daremos un paremotro solo por neurona
        umbral=MatJa.random(1,numeroNeur,-1,1);




        this.funcionA=funcionA;
        return this;

    }

}
class capita{
    //lo estableci a un array list por la comodidad pero se puede haber hecho una matriz del objeto

    public ArrayList<RedNeur> capa(int []topo, String act [])
    {
        RedNeur[] poli=new RedNeur[topo.length];
        ArrayList <RedNeur> polilla= new ArrayList<>();


        int nu=0;

        while(nu<topo.length-1){

            //nota mental no olvidarse inicialisar nueva memoria con la que se trabaja ya que
            //hacerlo directo da problemas o bugs
            poli[nu]=new RedNeur();
            polilla.add(poli[nu].neurna(topo[nu],topo[nu+1],act));



            nu++;
        }



      return polilla;
    }

}
class proceso
{
   public void train(int[] topo,String [] act,double [][]x,double[][]y, boolean train){
       capita poli=new capita();
       double [][]a=new double[topo[topo.length-1]][topo.length];
        //el proceso es el siguiente las neuronas bienen dadas el numero de neuronas que existen en la siguiente capa
       //tendras un numero de conexiones lo otro es que tendras que definir el numero de conexiones
       //en torno al numero de neuronas

       ArrayList<RedNeur> pil=poli.capa(topo,act);
        ArrayList<double[][]> funciAct=new ArrayList<>();
	   for(int pio=0; pio<topo.length-1; pio++){

       double[][]z=MatJa.SumVect(MatJa.result(x,pil.get(pio).pesos),pil.get(pio).umbral);
       /**aun experimental es switch de abajo falta mejorar relu y la capacidad de la red pero lo dejare como beta*/
        switch(act[pio]){
            case "sigm":
                a=funcion_Act.sigm(z)[0];
                break;
            case "relu":
                a=funcion_Act.relu(z)[0];
                break;
           }


       funciAct.add(a);
           //MatJa.impMat(z);
        //depues de depurar alrededor de 2 dias si se pudo corregir tanto result como red neur
           //cualquier problema de claculo es culpa de MatJa.result corregir en depuracion

	   x=a;


       }
	   MatJa.impMat(error.errCua(y,funciAct.get(funciAct.size()-1))[0]);

	   if(train){

       }








   }









}

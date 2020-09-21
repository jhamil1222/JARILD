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











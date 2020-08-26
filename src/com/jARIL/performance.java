package com.jARIL;

import java.util.ArrayList;
/*toda esta clase esta en calidad de demo si deseas puedes mejorarlo pero
* eso si funcionara desacomodando o desordenando las filas y causndo un desorden pero eso si
* funciona lo unico que hay que mejorar es que no debuelve nada uno dos mejorar
* la imprecion extendiendo de mul y usando el metodo getimpRe() una cosa muy importante para la impresion de la matriz resultante
 */
public class performance extends Thread{
    private double [][] dividido;
    private double [][] segunda;
    mul poli=new mul();
    public performance(double [] [] dividido,double [][]seunda){
       this.dividido=dividido;
       this.segunda=seunda;
    }
    public void run(){

        poli.result(dividido,segunda);
        poli.getimpRe();
    }

}

class peror{
private double[][] arr;
public double[][] perfor(double[][]divid,double [][]divo) {
    int pio = divid.length / 2, poli = divid[1].length / 2;

    ArrayList <double[][]> papit=new ArrayList<double[][]>();

    int polita = divo.length / 2, polilla = divo[1].length / 2;
    arr=new double[pio-1][poli];


    for(int numero =0; numero<divid.length; numero++){
    papit.add(new double[][] {divid[numero]});

    }



    performance []aguila;
    aguila=new performance[divid.length];
    for (int gato=0; gato<divid.length; gato++){
    aguila[gato]=new performance(papit.get(gato),divo);/*
    pichon=new performance(ola,divo);
    puebla=new performance(pioru,divo);*/
    }
    int numro=0;
    int gato=0;
    //while (numro<divid.length){

    for (gato=0; gato< divid.length; gato++){
    aguila[gato].start();
    }
    //numro++;
    //}

    /*pichon.start();
    puebla.start();*/

   return arr;
}
}
class tipos{
    public String pato(int poli) {
        String poi=Integer.toString(poli);
        return poi;
    }
    public static String poli(float[][]polio){
        String avejita="";
        int salto=0;
        for(float avis[]:polio){
            salto=0;
            for (float poli:avis){

                avejita+=Float.toString(poli)+" "+((salto== avis.length-1)?"\n":"");

                salto++;
            }

            //salto++;


        }
        return avejita;
    }
}



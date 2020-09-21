package com.jARIL;
import com.jARIL.*;

import java.util.ArrayList;

public class proceso{

        public void train(int[] topo,String [] act,double [][]x,double[][]y, boolean train){
            capita poli=new capita();
            double [][]a=new double[topo[topo.length-1]][topo.length];
            //el proceso es el siguiente las neuronas bienen dadas el numero de neuronas que existen en la siguiente capa
            //tendras un numero de conexiones lo otro es que tendras que definir el numero de conexiones
            //en torno al numero de neuronas

            ArrayList<RedNeur> pil=poli.capa(topo,act);
            ArrayList<double[][]> funciAct=new ArrayList<>();
            for(int pio=0; pio<topo.length-1; pio++){

                double[][]z= MatJa.SumVect(MatJa.result(x,pil.get(pio).pesos),pil.get(pio).umbral);
                /**aun experimental es switch de abajo falta mejorar relu y la capacidad de la red pero lo dejare como beta*/
                switch(act[pio]){
                    case "sigm":
                        a= funcion_Act.sigm(z)[0];
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



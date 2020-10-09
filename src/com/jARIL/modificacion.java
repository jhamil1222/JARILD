package com.jARIL;

import java.util.ArrayList;

public class modificacion {

        public void train(int[] topo,String [] act,double [][]x,double[][]y, boolean train,double lr){

            double [][]a=new double[topo[topo.length-1]][topo.length];
            //el proceso es el siguiente las neuronas bienen dadas el numero de neuronas que existen en la siguiente capa
            //tendras un numero de conexiones lo otro es que tendras que definir el numero de conexiones
            //en torno al numero de neuronas
            ArrayList<double[][]> polilla=new ArrayList<>();
            ArrayList<double[][]> funciAct=new ArrayList<>();
            double [][]r=new double[topo[topo.length-1]][topo.length];
           gatito[] ponds=multicap(x,topo);
			
           // MatJa.impMat(ponds.multicap(x,new int[]{2,3,5,7})[3].b);
           //cada fila de w es para cada neurona
            ArrayList <double [][]> polu=new ArrayList<>();
            polu.add(MatJa.memoriaFantasma(x));
			int pio=0;
            for(gatito pul:ponds){

                double[][]z= MatJa.SumVect(MatJa.result(polu.get(pio),pul.peso),pul.b);
                /*aun experimental es switch de abajo falta mejorar relu y la capacidad de la red pero lo dejare como beta*/
                switch(act[pio]){
                    case "sigm":
                        a= funcion_Act.sigm(z)[0];
                        r=funcion_Act.sigm(a)[1];
                        break;
                    case "relu":
                        a=funcion_Act.relu(z)[0];
                        r=funcion_Act.relu(a)[1];
                        break;
                }

                polu.add(a);
                //pos=new double[][][]{x,a};
                funciAct.add(a);


                polilla.add(r);
                //MatJa.impMat(MatJa.result(polu.get(pio),ponds[pio].peso));
                //depues de depurar alrededor de 2 dias si se pudo corregir tanto result como red neur
                //cualquier problema de claculo es culpa de MatJa.result corregir en depuracion

                //x=a;
				pio++;

            }
            if(train){
                ArrayList <double[][]> delta=new ArrayList<>();
                /*aqui nos encargaremos de procesar la neurona hacia atras en
                un sentido aqui incluiremos el pase atras*/
                /*nota para eliminar aqui tengo una duda pero creo que la resolvere
                en todo caso iterare en el tamaño de */
                double[][] _w=new double[0][0];
                for(int numeri=funciAct.size()-1; numeri>=0; numeri--){
                    if(numeri==funciAct.size()-1){
                        /*hubo un error muy grabe con multigran y x ya que estos permitian la multiplicacion
                        normal entre estos dos vectores
                        *lo de abajao es facilmente interpretable como la multiplicacion de los deltas de la
                        ultima capa*/
                        //lo malo no me permite solo una capa oculta tendre que mejorar eso
                        //deltaU.add(0,MatJa.mulTiGran(MatJa.mulTiGran(MatJa.mulTiGran(funciAct.get(funciAct.size()-2),error.errCua(funciAct.get(funciAct.size()-1),y)[1]),funciAct.get(funciAct.size()-1)),MatJa.restonVect(MatJa.ingresEnt(funciAct.get(funciAct.size()-1),1),funciAct.get(funciAct.size()-1))));
                        delta.add(0,MatJa.mulTiGran(MatJa.mulTiGran(funciAct.get(funciAct.size()-2),error.errCua(funciAct.get(funciAct.size()-1),y)[1]),polilla.get(polilla.size()-1)));

                        //MatJa.impMat(MatJa.mulTiGran(MatJa.mulTiGran(funciAct.get(funciAct.size()-2),MatJa.restonVect(funciAct.get(funciAct.size()-1),y)),funciAct.get(funciAct.size()-1)));
						
                    }
				    else{
						//MatJa.impMat(ponds[numeri].peso);
						delta.add(0,MatJa.result(delta.get(0),MatJa.memoriaFantasma(ponds[numeri].peso)));
						MatJa.impMat(delta.get(0));
					}
                    //corregir else
                   /* else {

                        delta.add(0,MatJa.result(delta.get(0),MatJa.matTi(_w)));
                    }

                    _w=MatJa.memoriaFantasma(ponds[numeri-1].peso);
					*/
                }
            }



	




        }
        //arreglar despues sospechas de salida pero no preocuparse
        public gatito [] multicap(double [][]entrada,int [] CapOc){
            /**por ser multicapa este solo registra capas ocultas sin reditrara capa de entrada
             * */
            //gatito fue estableciso como la columna de CapOc por que aumentamos 1 a la entrada con
            //la operacion de abajo que toma perro[0]
            gatito [] perro =new gatito[CapOc.length];
            /*permiteme explicarte novato como funciona esto perro[0]contendra la neurona que
            viene dada por pesos dados por la entrada y la primera capa oculta*/
            int modif=entrada[0].length,lo=CapOc[0];
            perro[0]=new gatito();
            perro[0].Cap(lo,modif,0,1,false);
            //te preguntaras por que -2 muy facil no incluimos la capa de entrada como una capa
            //solo como una posible entrada
            
            for(int movimiento=0,pol=1; movimiento<=CapOc.length-2;movimiento++){
                modif=CapOc[pol];
				if(pol==1)
				{
					lo=CapOc[0];
				}
                
                perro[pol]=new gatito();
                perro[pol].Cap(modif,lo,0,1,false);
				//MatJa.impMat(perro[pol].peso);
                //el -2 de arriba viene dado por esta calculada de aqui
                lo=CapOc[movimiento+1];
                pol++;
            }


            return perro;

        }

}

class gatito{
    public double [][]peso, b;
    public void Cap(int neur,int con,double emp, double fin,boolean signo){
        peso=MatJa.random(con,neur,emp,fin);
        b=MatJa.random(1,neur,emp,fin);
    }
}


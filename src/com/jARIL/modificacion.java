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
            double [][]nue=new double[1][1],uji=new double[1][1],ajo=new double[1][1];

            if(train){
                ajo=funciAct.get(funciAct.size()-1);
                /*problemilla con este lado por que tengo que utilizar la anterior capa a
                esta esto incluye trabajar con capas ocultas mayores a 1 */
                if(funciAct.size()-1!=1) {
                    uji = funciAct.get(funciAct.size() - 2);
                }
                MatJa.impMat(polilla.get(polilla.size()-1));
                MatJa.impMat(MatJa.mulTiGran(error.errCua(ajo,y)[1],polilla.get(polilla.size()-1)));

            }
           // MatJa.impMat(error.errCua(funciAct.get(funciAct.size()-1),y)[0]);

            //double [][]_w=new double[pil.get(0).pesos.length][pil.get(0).pesos[0].length];
            /*double [][]al;

            ArrayList<double[][]> perla=new ArrayList<>();

            if(train){

                //primero evaluamos la ultima capa

                for(int reverso=funciAct.size()-1; reverso>=0; reverso--){

                    al=funciAct.get(reverso);


                    if(reverso==funciAct.size()-1){

                        perla.add(0,MatJa.mulTiGran(error.errCua(al,y)[1],polilla.get(reverso)));

                    }
                    else {


                        //MatJa.impMat(perla.get(0));
                        //perla.add(MatJa.mulTiGran(MatJa.result(perla.get(0),MatJa.matTi(_w)),polilla.get(reverso)));

                        perla.add(0,MatJa.x(MatJa.result(perla.get(0),MatJa.matTi(_w)),polilla.get(reverso)));


                    }
                    _w=MatJa.memoriaFantasma(pil.get(reverso).pesos);
                    //MatJa.GranmediaVect(new double[][]{{9,2,3},{2,2,7},{4,2,2}} );
                    //MatJa.impMat(pil.get(reverso).pesos);
                    //MatJa.impMat(_w);

                /*RedNeur pli=new RedNeur();
                pli.umbral =MatJa.restonVect(pil.get(reverso).umbral,MatJa.result(lr,MatJa.GranmediaVect(perla.get(0))));
                pli.pesos =MatJa.restonVect(pil.get(reverso).pesos,MatJa.result(MatJa.matTi(funciAct.get(reverso)),MatJa.result(lr,perla.get(0))));

                pil.set(reverso,pli);
                MatJa.impMat(pil.get(reverso).pesos);
            }


            }*/



	




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
        peso=MatJa.random(con,neur,emp,fin,signo);
        b=MatJa.random(1,neur,emp,fin,signo);
    }
}


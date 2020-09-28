package com.jARIL;

import java.util.ArrayList;

public class proceso{

        public void train(int[] topo,String [] act,double [][]x,double[][]y, boolean train,double lr){
            capita poli=new capita();
            double [][]a=new double[topo[topo.length-1]][topo.length];
            //el proceso es el siguiente las neuronas bienen dadas el numero de neuronas que existen en la siguiente capa
            //tendras un numero de conexiones lo otro es que tendras que definir el numero de conexiones
            //en torno al numero de neuronas
            ArrayList<double[][]> polilla=new ArrayList<>();
            ArrayList<RedNeur> pil=poli.capa(topo,act);
            ArrayList<double[][]> funciAct=new ArrayList<>();
            double [][]r=new double[topo[topo.length-1]][topo.length];


            for(int pio=0; pio<pil.size(); pio++){

                double[][]z= MatJa.SumVect(MatJa.result(x,pil.get(pio).pesos),pil.get(pio).umbral);
                /*aun experimental es switch de abajo falta mejorar relu y la capacidad de la red pero lo dejare como beta*/
                switch(act[pio]){
                    case "sigm":
                        a= funcion_Act.sigm(z)[0];
                        r=funcion_Act.sigm(z)[1];
                        break;
                    case "relu":
                        a=funcion_Act.relu(z)[0];
                        r=funcion_Act.relu(z)[1];
                        break;
                }


                funciAct.add(a);


                polilla.add(r);
                //MatJa.impMat(z);
                //depues de depurar alrededor de 2 dias si se pudo corregir tanto result como red neur
                //cualquier problema de claculo es culpa de MatJa.result corregir en depuracion

                x=a;


            }

            //MatJa.impMat(error.errCua(y,funciAct.get(funciAct.size()-1))[0]);
            double [][]_w=new double[pil.get(0).pesos.length][pil.get(0).pesos[0].length];
            double [][]al;

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
                MatJa.impMat(pil.get(reverso).pesos);*/
            }


            }








        }
}



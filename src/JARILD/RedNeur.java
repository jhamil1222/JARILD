package JARILD;

import java.util.ArrayList;

public class RedNeur {
        /**este es el train de modificacion se puede ingresar cualquier matriz en x pero eso si la topologia en la ultima capa tiene que tener
         * el mismo tamaño de filas que la salida que es y que quiero decir si tenemos y=array(1,2) entonces topo estara con el valor {2} por ser ultimo*/
    public gatito[] ponds;   
    
    private double[][]x;
    private int [] topo;
    private String [] acti;
    public RedNeur(double [][]x,int []topo){
        this.x=x;
        this.topo=topo;
    ponds=multicap(x,topo);
    
}
public double[][] run(double [][] input){
    
    double [][]a=new double[topo[topo.length-1]][topo.length];
    //el proceso es el siguiente las neuronas bienen dadas el numero de neuronas que existen en la siguiente capa
    //tendras un numero de conexiones lo otro es que tendras que definir el numero de conexiones
    //en torno al numero de neuronas
    ArrayList<double[][]> funciAct=new ArrayList<>();

    // MatJa.impMat(ponds.multicap(x,new int[]{2,3,5,7})[3].b);
    //cada fila de w es para cada neurona
    ArrayList <double [][]> polu=new ArrayList<>();
    polu.add(MatJa.memoriaFantasma(input));
    int pio=0;
  
    for(gatito pul:ponds){
        /*MatJa.impMat(pul.peso);
        System.out.println("perro tu segunda ");
        MatJa.impMat(polu.get(pio));
        */
        
        double[][]z= MatJa.SumVect(MatJa.result(polu.get(pio),pul.peso),pul.b);
        /*aun experimental es switch de abajo falta mejorar relu y la capacidad de la red pero lo dejare como beta*/
        
        switch(acti[pio]){
            case "sigm":
                a= funcion_Act.sigm(z)[0];

                break;
            case "relu":
                a=funcion_Act.relu(z)[0];

                break;
        }
        /*System.out.println("tu resultado perro");
        MatJa.impMat(z);
        System.out.println("tu activacion perro");
        MatJa.impMat(a);
        System.out.println("feen");*/
        polu.add(a);
        //pos=new double[][][]{x,a};
        funciAct.add(a);
        // MatJa.impMat(polu.get(pio));
        //MatJa.impMat(ponds[pio].peso);



        //depues de depurar alrededor de 2 dias si se pudo corregir tanto result como red neur
        //cualquier problema de claculo es culpa de MatJa.result corregir en depuracion

        //x=a;
        pio++;

    }
    return funciAct.get(funciAct.size()-1);

}
    public double[][] train(String [] act,double[][]y, boolean train,double lr){
            acti=act;
            double [][]a=new double[topo[topo.length-1]][topo.length];
            //el proceso es el siguiente las neuronas bienen dadas el numero de neuronas que existen en la siguiente capa
            //tendras un numero de conexiones lo otro es que tendras que definir el numero de conexiones
            //en torno al numero de neuronas
            ArrayList<double[][]> polilla=new ArrayList<>();
            ArrayList<double[][]> funciAct=new ArrayList<>();
            double [][]r=new double[topo[topo.length-1]][topo.length];
            
           
           
			boolean ejecut=true;
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

                 //MatJa.impMat(pul.b);
                polu.add(a);
                //pos=new double[][][]{x,a};
                funciAct.add(a);
              // MatJa.impMat(polu.get(pio));
               //MatJa.impMat(ponds[pio].peso);
                  
                polilla.add(r);
                
                //depues de depurar alrededor de 2 dias si se pudo corregir tanto result como red neur
                //cualquier problema de claculo es culpa de MatJa.result corregir en depuracion

                //x=a;
				pio++;

            }
            
            if(train){
                ArrayList <double[][]> deltaw=new ArrayList<>();
                ArrayList <double[][]> deltab=new ArrayList<>();
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
                        /**lo que se quiere hacer con esta parte es obtener el algorithmo de retropropagation por ello se toma la activacion de la penultima capa por
                         *la diferencia de la activacion de la ultima capa y el resultado esperado y a todo eso se le multiplica la derivada de la activacion de la ultima capa */
                        //derivada de la activacion por la derivada del error 
                      //puse el false por que no quiero que se evalue el error en plena operacion 
                        deltaw.add(0,MatJa.mulTiGran(/*derivada del error*/error.errCua(funciAct.get(numeri),y,false)[1],/*aqui se ingresa la derivada activacion*/polilla.get(numeri)));
                        //MatJa.impMat(funciAct.get(numeri));
                        //MatJa.impMat(y);
                        //MatJa.impMat(error.errCua(funciAct.get(funciAct.size()-1),y)[1]);
                        //MatJa.impMat(polilla.get(polilla.size()-1));
                        
//deltab.add(0,MatJa.mulTiGran(error.errCua(funciAct.get(funciAct.size()-2),y)[1],/*aqui se ingresa la derivada activacion*/polilla.get(polilla.size()-1)));
                        //MatJa.impMat(MatJa.mulTiGran(MatJa.mulTiGran(funciAct.get(funciAct.size()-2),MatJa.restonVect(funciAct.get(funciAct.size()-1),y)),funciAct.get(funciAct.size()-1)));
			
                    }
                    /*Matja.multigran es peligroso no usar mucho problemas muy serios con las multiplicaciones arreglar y proble,as faltantes por resolver no muy resueltos*/
                    else{
                        
                        //deltaw.add(0,MatJa.mulTiGran(polilla.get(numeri),MatJa.result(deltaw.get(0),MatJa.matTi(_w))));
                         //MatJa.impMat(MatJa.matTi(polilla.get(numeri)));
                       /*despues de sufrir tanto descubri el hierro la gran respuesta de este descubrimiento de mi cabeza es la 
                         siguiente afirmacion que tenemos que multiplicar matricialmente el resultado de la primera operacion por la matriz transpuesta de 
                         w que biene dado a ser el w de ahora osea si tienes 4 neuronas el peso 3*/
                     deltaw.add(0,MatJa.mulTiGran(polilla.get(numeri),MatJa.result(deltaw.get(0),MatJa.matTi(_w))));
                     // MatJa.impMat(MatJa.mulTiGran(MatJa.matTi(_w),polilla.get(numeri)));
                      //MatJa.impMat(_w);
                      //MatJa.impMat(polilla.get(numeri));
                       //2,1
                     //MatJa.impMat(polilla.get(numeri));
                        //MatJa.impMat(MatJa.matTi(_w));
                     
                    //deltaw.add(0,_w);
                    
                     //MatJa.impMat(deltaw.get(0));
                    
                    
                      //MatJa.impMat(ponds[numeri].peso);
                    }
                    /*funciAct.add(funciAct.size()-1,x);*/
                    _w=MatJa.memoriaFantasma(ponds[numeri].peso);
                    
                    
                    
                    
                    //MatJa.impMat(_w);
                    //MatJa.impMat(deltaw.get(0));
                    //System.out.println("segundo rrrrrrrrrr");
                    //MatJa.impMat(_w);
                     
                    /* MatJa.impMat(_w);*/
                    
                    ponds[numeri].b=MatJa.restonVect(ponds[numeri].b,MatJa.mulTiGran(MatJa.GranmediaVect(deltaw.get(0)),new double [][]{{lr}}));
                    if(ejecut){
                        ejecut=false;
                        funciAct.add(0,x);
                    }
                    //agregamos x al pricipio por que cuenta como activacion
                    ponds[numeri].peso=MatJa.restonVect(ponds[numeri].peso,MatJa.mulTiGran(MatJa.result(MatJa.matTi(funciAct.get(numeri)),deltaw.get(0)),new double [][]{{lr}}));
                    
                    
                    //ponds[numeri].peso=MatJa.restonVect(ponds[numeri].peso,MatJa.mulTiGran(MatJa.result(MatJa.matTi(funciAct.get(numeri)),deltaw.get(0)),new double [][]{{lr}}));
                    //olvide algo muy importante y es un rompecabezas literal la pieza fundamental X de la primera capa
                    
                    //MatJa.impMat(ponds[numeri].peso);
                    //MatJa.impMat(MatJa.mulTiGran(MatJa.result(MatJa.matTi(funciAct.get(numeri)),deltaw.get(0)),new double [][]{{lr}}));
                    //ponds[numeri].peso=MatJa.restonVect(ponds[numeri].peso,MatJa.mulTiGran(MatJa.result(MatJa.matTi(funciAct.get(numeri)),deltaw.get(0)),new double [][]{{lr}}));
                    //ponds[numeri].peso=MatJa.restonVect(ponds[numeri].peso, );
                    
                      //MatJa.impMat(funciAct.get(numeri-1));
                     //MatJa.impMat(funciAct.get(numeri));
                    //ponds[numeri].peso=MatJa.restonVect(ponds[numeri].peso,MatJa.mulTiGran(MatJa.result(MatJa.matTi(funciAct.get(numeri)),deltaw.get(0)),new double [][]{{lr}}));
                            
                    
					
                
                }

               // MatJa.impMat(error.errCua(funciAct.get(funciAct.size()-1), y, true)[0]);
            }


            return funciAct.get(funciAct.size()-1);
	




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
        
        peso=MatJa.random(con,neur,emp,fin,true);
        
        b=MatJa.random(1,neur,emp,fin,true);
    }
}


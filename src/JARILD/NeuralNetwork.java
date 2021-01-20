package JARILD;

public  class NeuralNetwork {
     /**variable para poder ver la iteracion en plena ejecucion*/
     public boolean iteracion=false;
     
     public RedNeur guarda;
     /**variable que contiene los pesos entrenados y umbrales que se pueden usar pero despues de haber entrenado la red neruonal*/
    public gatito[] UPentre;
    /**variable para poder ver el error de la salida entrenada en pleno proceso
     *tiene que ser establecido antes que Neurona*/
     public boolean MostrarErPro=false;
      /**variable para poder ver el error de la salida entrenada despues del proceso
       *tiene que ser establecido antes que Neurona**/
     public boolean MostrarEr=false;
     /**la funcion Neurona tiene que ser establecida antes que run tambien la ultima capa 
      *de la topologia tiene que si o si ser igual a las columnas de la salida para entrenar*/
    public void Neurona(funcion_Act [] activaciones,double[][] input,double [][] output,int[] topologia,double learningrate,int iteraciones){
        
        if(activaciones.length!=topologia.length+1){
            throw new IllegalArgumentException("tu neurona no es viable ya que las activaciones que definiste no son iguales a tu topologia");
        }
        int conta=0;
        int[] copito=new int[topologia.length+1];
        for(int topi: topologia){
            copito[conta]=topi;
            
                    conta++;
        }
       
        copito[topologia.length]=output[0].length;
      //System.out.println(copito[topologia.length]);
        topologia=copito;
        guarda=new RedNeur(input,topologia);
        double [] [] salida=new double[3][3];
        for (int po=0; po<=iteraciones; po++){
            if(po%500==0&&iteracion){
                System.out.println("iteracion"+po);
            }
        salida=guarda.train(activaciones,output,true,0.01);
        if(MostrarErPro){
            MatJa.impMat(error.errCua(salida,output , true)[0]);
        }
        }
        if(MostrarEr){
            MatJa.impMat(error.errCua(salida,output , true)[0]);
        }
        UPentre=guarda.ponds;
        
    }
    
    /**funcion para evaluar entradas con los pesos ya entrenados*/
    public double[][] run(double [][]x){
        
        return MatJa.memoriaFantasma(guarda.run(x));
    }
     
     
}
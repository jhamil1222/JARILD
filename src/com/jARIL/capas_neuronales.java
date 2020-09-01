package com.jARIL;

class dataset{
    public dataset(double [][]X,int po) {

    }
        }
public class capas_neuronales {
    /**clase de capa neuronas espero mejorar esta clase mas adelante pos data no esperen mucho
     * 4:20 mejoras 2020ras XD
     * @author JhamilRoldanLopez
     * @version 0.0.1*/
    private double []w[],x[],y[];
    public funcion_Act funcionact;
    private int numer;
    public double [][]W;
    public double [][] b;

    int n=500;
     int p=2;
    // cambiar funcionact no estoy muy seguro
    public capas_neuronales(int numeroCon,int numeroNeur,funcion_Act funcionact){
    this.funcionact=funcionact;
    this.b=randMat.random(1,numeroNeur,-1,1,false);
    this.W=randMat.random(numeroCon,numeroNeur,-1,1,false);
    mul.impMat(W);
    }
}

    class create_nn{


    public capas_neuronales[] createnn(int [] topology,funcion_Act pan){
        capas_neuronales []polu=new capas_neuronales[topology.length];
     for (int lo=0; lo<topology.length-1; lo++){
         polu[lo]=new capas_neuronales(topology[lo],topology[lo+1],pan);
     }
     return polu;
    }

}
//error cuadratico medio

class error {

    public static double [][][]  errCua(double[][] Yp,double[] []Yr){
        //error cuadratico medio
        double [][] cero=MatJa.powVectM(MatJa.restonVect(Yp,Yr),MatJa.ingresEnt(Yp,2),false);
        double [][] uno=MatJa.restonVect(Yp,Yr);
        return new double[][][]{cero,uno};
    }

}

//entrenamiento a la red neuronal
class entrenador{
    public static void train(capas_neuronales neural_net,double[][] X,double[][] Y,double[][]l2_cost,double lr,boolean train){
    lr=0.5;
    train=true;

    double[][]z=MatJa.SumVect(MatJa.result(neural_net.W,X),neural_net.b);
        error.errCua(funcion_Act.sigm(z)[0],MatJa.random(z.length,z[0].length));

    }


}



/* guardado en caso de prueba y es un ejemplo un tanto rustico
double [][]gato={{1,2,3},
                         {3,4,5},
                         {4,8,9}};
        double [][]perro={{5,6,8},
                          {7,8,9},
                          {6,7,8}};

        randMat pio=new randMat();
        //mul abuelita=new mul();
        mul polu =new mul();
        //abuelita.result(pio.random(4200,5500,1,3),pio.random(5500,4250,1,3));
        //pio.getimpRe();
        //abuelita.getimpRe();
        //peror polu=new peror();
        //polu.perfor(gato,perro);
        //polu.result(pio.random(3,2,2,6),pio.random(2,1,2,8));
        entero pan=new entero();
        //polu.impMat(pio.random(2,1));
        //double [][]pol=pio.random(12,13,69,65);
        matT pios=new matT();
        peror gat=new peror();
        unos pl=new unos();
        pl.insert(perro,2);
        pl.getimpRe();
        //pios.matTi(pol);
        //pios.getimpRe();
*/
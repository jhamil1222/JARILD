package com.jARIL;

public class funcion_Act {
    //reemplazar aqui todas la mul.result por perfor por tema de rendimiento
    /**funcion de activacion */
    //sigmoide la columna 0 esta definida como la funcion sigmoide y su derivada en 1
    public static double  [][][]sigm(double [][]x){

        double[][] sha= MatJa.DIVect(MatJa.ingresEnt(x,1),MatJa.SumVect(MatJa.ingresEnt(x,1),MatJa.powVectM(MatJa.E(x.length,x[0].length),x,true)));
        //arreaglar restonVect errores no deseados
        //qui no agregar result por varias razones entre ellas que result es para operaciones dot
        double [][] seg= MatJa.x(x,MatJa.restonVect(MatJa.ingresEnt(x,1),x));

        return new double[][][]{sha,seg};
        //return new double []{1/(1+Math.pow(Math.E,-x)),x*(1-x)};
    }
    //relu la columna 0 esta definida como la funcion relu y su derivada en 1
    public static double [][] []relu(double[][] x){
        return new double[][][] {MatJa.MAX(MatJa.ingresEnt(x,0),x),MatJa.DIVect(MatJa.ingresEnt(x,1),MatJa.SumVect(MatJa.ingresEnt(x,1),MatJa.powVectM(MatJa.E(x.length, x[0].length),x,true)))};
        //return new double []{Math.max(0,x),1/(1+Math.pow(Math.E,-x))};
    }


}
class error {

    public static double [][] [] errCua(double[][] Yp,double[] []Yr){
        //error cuadratico medio
        //aqui use result por que puse una multiplicacion por un escalar
        double  cero=  MatJa.sumatoriaV(MatJa.result(0.5,MatJa.powVectM(MatJa.restonVect(Yp,Yr),MatJa.ingresEnt(Yp,2),false)));
        double [][] uno=MatJa.restonVect(Yp,Yr);
        return new double[][][]{{{cero}},uno};
    }

}
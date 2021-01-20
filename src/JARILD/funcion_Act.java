package JARILD;

import MatJa.MatJa;

/**
 *
 * @author jhamilroldan
 */
public interface funcion_Act {
    
    //reemplazar aqui todas la mul.result por perfor por tema de rendimiento
    //posdata aqui no agregare las funciones default esta decicion es mas por diseño ya que quiero que sea compatible con java 7 como con el 8
    /**funcion de activacion esta fucnionseactualizo comointerface para que se pueda obtener funcionavilidad extrema y no asi mplementar todoel rato una nueva case al switch X
    */
    //sigmoide la columna 0 esta definida como la funcion sigmoide y su derivada en 1
    double[][] operation(double[][] z);
    double[][] derivada(double[][]a);
   
}

class error {

    public static double [][] [] errCua(double[][] Yp,double[] []Yr,boolean errorPerron){
        //error cuadratico medio
        //aqui use result por que puse una multiplicacion por un escalar
        double  cero=0;
        if(errorPerron){
        cero=  MatJa.sumatoriaV(MatJa.result(0.5,MatJa.powVectM(MatJa.restonVect(Yp,Yr),MatJa.ingresEnt(Yp,2),false)));
        }
        double [][] uno=MatJa.restonVect(Yp,Yr);
        
        return new double[][][]{{{cero}},uno};
    }

}
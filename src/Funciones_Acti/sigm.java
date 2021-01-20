/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones_Acti;

import JARILD.MatJa;
import JARILD.funcion_Act;

/**
 *
 * @author jhamilroldan
 */
public class sigm implements funcion_Act {
//return new double []{1/(1+Math.pow(Math.E,-x)),x*(1-x)};
    @Override
    public double[][] operation(double[][] z) {
    return MatJa.DIVect(MatJa.ingresEnt(z,1),MatJa.SumVect(MatJa.ingresEnt(z,1),MatJa.powVectM(MatJa.E(z.length,z[0].length),z,true)));
       
    }

    @Override
    public double[][] derivada(double[][] a) {
    return MatJa.x(a,MatJa.restonVect(MatJa.ingresEnt(a,1),a));
    
    }
    
}

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
public class relu implements funcion_Act
{
//return new double []{Math.max(0,x),1/(1+Math.pow(Math.E,-x))};
    @Override
    public double[][] operation(double[][] z) {
   return MatJa.MAX(MatJa.ingresEnt(z,0),z);    
    }

    @Override
    public double[][] derivada(double[][] a) {
    return MatJa.DIVect(MatJa.ingresEnt(a,1),MatJa.SumVect(MatJa.ingresEnt(a,1),MatJa.powVectM(MatJa.E(a.length, a[0].length),a,true)));   
    }
    
    
}

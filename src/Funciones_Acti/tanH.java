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
public class tanH implements funcion_Act{

    @Override
    public double[][] operation(double[][] z) {
    return MatJa.DIVect( MatJa.restonVect(MatJa.powVectM(MatJa.E(z.length,z[0].length),z,false),MatJa.powVectM(MatJa.E(z.length,z[0].length),z,true)),MatJa.SumVect(MatJa.powVectM(MatJa.E(z.length,z[0].length),z,false),MatJa.powVectM(MatJa.E(z.length,z[0].length),z,true)));    
    }

    @Override
    public double[][] derivada(double[][] a) {
    return MatJa.powVectM(MatJa.DIVect(MatJa.ingresEnt(a,1), MatJa.DIVect( MatJa.SumVect (MatJa.powVectM(MatJa.E(a.length,a[0].length),a,false),MatJa.powVectM(MatJa.E(a.length,a[0].length),a,true)),MatJa.ingresEnt(a,2))),MatJa.ingresEnt(a,2),false);
		
    }
    
}

package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
    proceso pi=new proceso();
    //nota no podras establecer neuronas de entrada mayores a las salidas
        double[][]x=new double[][]{{1,2,3},{1,2,3}};
        double [][]w=new double[][]{{1,2,3,6,9,8}};
        //MatJa.impMat(MatJa.result(x,w));
    //MatJa.impMat(MatJa.inse1(x,1));
       //MatJa.impMat (MatJa.ingre1(x,3));
        pi.train(new int[]{3,8,1},"sigm",x);
        //MatJa.impMat(MatJa.result(x,w));


		//MatJa.impMat(MatJa.result(po,pil));
    
    }
}

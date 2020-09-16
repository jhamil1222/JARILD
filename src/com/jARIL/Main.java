package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
    proceso pi=new proceso();
    //nota no podras establecer neuronas de entrada mayores a las salidas
    //pio.train(new int[]{5,9,1},"sigm",new double[][]{{1,2,3}});
        double[][]po={{1,1,1,1}};
        double[][]pil={{1,1,1,1},{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2}};
    MatJa.impMat(MatJa.result(pil,po));
    }
}

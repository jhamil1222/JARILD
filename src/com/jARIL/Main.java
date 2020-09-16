package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
    proceso pi=new proceso();
    //nota no podras establecer neuronas de entrada mayores a las salidas
    //pio.train(new int[]{5,9,1},"sigm",new double[][]{{1,2,3}});
        int []po={4,3,5,1};
        double[][]pu={{1,0.45,1,0.45}};
        pi.train(po,"sigm",pu);
    }
}

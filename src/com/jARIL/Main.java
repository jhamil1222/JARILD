package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
    modificacion pi=new modificacion();
    //nota no podras establecer neuronas de entrada mayores a las salidas
        double[][]x=new double[][]{{0.05,0.10},{0,1}};

        double[][]r=new double[][]{{2}};
		double[][]o=new double[][]{{2,4,3,5}};
        double [][]y=new double[][]{{ 0.01,0.99}};
        modificacion pul=new modificacion();
        pul.train(new int[]{1,2,1,1},new String[]{"relu","relu","relu","sigm"},x,y,true,0.01);

    }
}

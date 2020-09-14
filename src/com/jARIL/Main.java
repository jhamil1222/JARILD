package com.jARIL;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
      RedNeur gato=new RedNeur();
      gato.neurna(2,3,new SecureRandom(),"sigm");
    }
}
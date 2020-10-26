
package com.jARIL;

public class MatJa extends inclusion{
    /**@author jhamil*/
   
    public static double sumatoriaV(double[][]op){

        double pan=0;
        for(double[] i:op){
            for(double po:i){
                pan+=po;

            }

        }
        return pan;
    }
     public static void comprobarDoMatriz(double [][] prim,double [][]seg){
        if(prim.length>1){
            if(prim[0].length!=prim[1].length){
                throw new ArrayIndexOutOfBoundsException("Cometes un error muy grabe en el primer array comprueba que sea cuadratico");
                
            }
        }
        if(seg.length>1){
            if(seg[0].length!=seg[1].length){
                throw new ArrayIndexOutOfBoundsException("Cometes un error muy grabe en el segundo array comprueba que sea cuadratico");
                
            }
        } 
        
    }
    /** funcion que sirve para la suma de matrices */
    public static double[][] SumVect(double[][] prim,double[][]seg){
         MatJa.comprobarDoMatriz(prim, seg);
        double[][] pabl;
       
        int movi=0;
        double [] [] pirata=new double[prim.length][seg[0].length];
        if(prim[0].length==1&&seg.length==1){
           
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     pirata[tos][movi]= prim[tos][0]+seg[0][movi];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return pirata;
        }
        double[][] poro=MatJa.memoriaFantasma(prim);
        prim=MatJa.memoriaFantasma(seg);
        seg=poro;
        double [] [] piraña=new double[prim.length][seg[0].length];
 if(prim[0].length==1&&seg.length==1){
            
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     piraña[tos][movi]= seg[0][movi]+prim[tos][0];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return piraña;
        }
               
        if(((((prim[0].length==1&&prim.length==1)||(seg[0].length==1&&seg.length==1))|| prim[0].length==seg[0].length)&((prim.length<=1&seg.length>=1)||(seg.length<=1&prim.length>=1)))||(seg.length==prim.length&&seg[0].length==prim[0].length)){
           if(seg.length>prim.length||seg[0].length>prim[0].length) {
               
               pabl = new double[seg.length][seg[0].length];
           }
           else {
               
               pabl = new double[prim.length][prim[0].length];
           }
           
          
        int conta=0;
           int co=0;
           int colus=0;
           int pilo=0;

            int tamaño=prim[0].length,taman=prim.length;
           
            if(prim.length==1){
               
                tamaño=seg[0].length;
                taman=seg.length;
            }

        for(int conti=0; conti<taman;  conti++ ){
            pilo=0;
            colus=0;

            for (int contu=0; contu< tamaño; contu++){
                //fue jodido si pero casi se logra
                if(prim.length==1&&prim[0].length==1){

                    conta=0;
                    pilo=0;
                }
                if(seg.length==1&& seg[0].length==1){
                    co=0;
                    colus=0;
                }
                if(prim.length==1){
                    conta=0;
                }
                if(seg.length==1){
                    co=0;
                }

                pabl[conti][contu]=seg[co][colus]+prim[conta][pilo];

                colus++;
                pilo++;
            }
            co++;
            conta++;

        }





        }
        else{
            System.out.println("error por favor corrige uno de estos");

            System.out.println("primero");
            MatJa.impMat(prim);
            System.out.println("segundo ");
            MatJa.impMat(seg);

            System.out.println("error por favor modifica una de tus doubles que ingresaste");

            throw new ArrayIndexOutOfBoundsException("error por favor corrige prim o sec");

        }
        return pabl;
        }
    /*Suma de una matriz por un escalar esta en beta todavia en desarrollo errores notables */
    public static double[][] SumVectno(double[][] prim,double seg){
        int columna=0;
        int fila=0;
        double [][]mov=new double[prim.length][prim[0].length];
        for(double []poit: prim){
            fila=0;
            for(double pan : poit){
                mov[columna][fila]=pan+seg;
                //System.out.println(mov[columna][fila]+" columna "+columna+" fila "+fila);

                fila++;
            }

            columna++;}

        //System.out.println(mov[columna][fila]);

        return mov;
    }
    /**divicion matricialtodabia en beta puede contener bugs*/
    public static double[][] DIVect(double[][] prim,double[][]seg){
        MatJa.comprobarDoMatriz(prim, seg);
       double[][] pabl;
       
        int movi=0;
        double [] [] pirata=new double[prim.length][seg[0].length];
        if(prim[0].length==1&&seg.length==1){
           
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     pirata[tos][movi]= prim[tos][0]/seg[0][movi];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return pirata;
        }
        double[][] poro=MatJa.memoriaFantasma(prim);
        prim=MatJa.memoriaFantasma(seg);
        seg=poro;
        double [] [] piraña=new double[prim.length][seg[0].length];
 if(prim[0].length==1&&seg.length==1){
            
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     piraña[tos][movi]= seg[0][movi]/prim[tos][0];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return piraña;
        }
               
        if(((((prim[0].length==1&&prim.length==1)||(seg[0].length==1&&seg.length==1))|| prim[0].length==seg[0].length)&((prim.length<=1&seg.length>=1)||(seg.length<=1&prim.length>=1)))||(seg.length==prim.length&&seg[0].length==prim[0].length)){
           if(seg.length>prim.length||seg[0].length>prim[0].length) {
               
               pabl = new double[seg.length][seg[0].length];
           }
           else {
               
               pabl = new double[prim.length][prim[0].length];
           }
           
          
        int conta=0;
           int co=0;
           int colus=0;
           int pilo=0;

            int tamaño=prim[0].length,taman=prim.length;
         
            if(prim.length==1){
               
                tamaño=seg[0].length;
                taman=seg.length;
            }

        for(int conti=0; conti<taman;  conti++ ){
            pilo=0;
            colus=0;

            for (int contu=0; contu< tamaño; contu++){
                //fue jodido si pero casi se logra
                if(prim.length==1&&prim[0].length==1){

                    conta=0;
                    pilo=0;
                }
                if(seg.length==1&& seg[0].length==1){
                    co=0;
                    colus=0;
                }
                if(prim.length==1){
                    conta=0;
                }
                if(seg.length==1){
                    co=0;
                }

                pabl[conti][contu]=seg[co][colus]/prim[conta][pilo];

                colus++;
                pilo++;
            }
            co++;
            conta++;

        }





        }
        else{
            System.out.println("error por favor corrige uno de estos");

            System.out.println("primero");
            MatJa.impMat(prim);
            System.out.println("segundo ");
            MatJa.impMat(seg);

            System.out.println("error por favor modifica una de tus doubles que ingresaste");

            throw new ArrayIndexOutOfBoundsException("error por favor corrige prim o sec");

        }
        return pabl;

    }
    /*multiplicacion vectorial todavia en beta puede contener bugs*/
    public static double[][] mulTiGran(double[][] prim,double[][]seg){
        MatJa.comprobarDoMatriz(prim, seg);
         double[][] pabl;
       
        int movi=0;
        double [] [] pirata=new double[prim.length][seg[0].length];
        if(prim[0].length==1&&seg.length==1){
           
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     pirata[tos][movi]= prim[tos][0]*seg[0][movi];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return pirata;
        }
        double[][] poro=MatJa.memoriaFantasma(prim);
        prim=MatJa.memoriaFantasma(seg);
        seg=poro;
        double [] [] piraña=new double[prim.length][seg[0].length];
 if(prim[0].length==1&&seg.length==1){
            
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     piraña[tos][movi]= seg[0][movi]*prim[tos][0];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return piraña;
        }
               
        if(((((prim[0].length==1&&prim.length==1)||(seg[0].length==1&&seg.length==1))|| prim[0].length==seg[0].length)&((prim.length<=1&seg.length>=1)||(seg.length<=1&prim.length>=1)))||(seg.length==prim.length&&seg[0].length==prim[0].length)){
           if(seg.length>prim.length||seg[0].length>prim[0].length) {
               
               pabl = new double[seg.length][seg[0].length];
           }
           else {
               
               pabl = new double[prim.length][prim[0].length];
           }
           
          
        int conta=0;
           int co=0;
           int colus=0;
           int pilo=0;

            int tamaño=prim[0].length,taman=prim.length;
            //System.out.println(tamaño);
            //System.out.println(taman); 
            if(prim.length==1){
               
                tamaño=seg[0].length;
                taman=seg.length;
            }

        for(int conti=0; conti<taman;  conti++ ){
            pilo=0;
            colus=0;

            for (int contu=0; contu< tamaño; contu++){
                //fue jodido si pero casi se logra
                if(prim.length==1&&prim[0].length==1){

                    conta=0;
                    pilo=0;
                }
                if(seg.length==1&& seg[0].length==1){
                    co=0;
                    colus=0;
                }
                if(prim.length==1){
                    conta=0;
                }
                if(seg.length==1){
                    co=0;
                }

                pabl[conti][contu]=seg[co][colus]*prim[conta][pilo];

                colus++;
                pilo++;
            }
            co++;
            conta++;

        }





        }
        else{
            System.out.println("error por favor corrige uno de estos");

            System.out.println("primero");
            MatJa.impMat(prim);
            System.out.println("segundo ");
            MatJa.impMat(seg);

            System.out.println("error por favor modifica una de tus doubles que ingresaste");

            throw new ArrayIndexOutOfBoundsException("error por favor corrige prim o sec");

        }
        return pabl;
    }
    /**reemplaza toda la matriz por un numero puede ser entero o double*/
    public static double [][]ingresEnt(double [] []prim,double numero){
        if(prim.length>1){
            if(prim[0].length!=prim[1].length){
                throw new ArrayIndexOutOfBoundsException("Cometes un error muy grabe en el primer array comprueba que sea cuadratico");
                
            }
        } 
        int numi=0,gato=0;
        double[][]jaula=new double[prim.length][prim[0].length];
        for(double [] paso:prim) {
            numi=0;
            for (double ga : paso) {
                jaula[gato][numi] = numero;

                numi++;
            }
            gato++;
        }
        return jaula;

    }
    /**se crea una matriz con un numero con fila y columna*/
    public static double [][]ingresEnt(int fila, int columna,double numero){
        int numi=0,gato=0;
        double[][]jaula=new double[fila][columna];
        for(double [] paso:jaula) {
            numi=0;
            for (double ga : paso) {
                jaula[gato][numi] = numero;

                numi++;
            }
            gato++;
        }
        return jaula;

    }

    /**se obtiene la matriz maxima de las dos matrices*/
    public static double[][] MAX(double[][] prim,double[][] seg){
        if(prim.length!=seg.length&&prim[0].length!=seg[0].length){
           throw new ArrayIndexOutOfBoundsException("no son asimetricos por ende la comparacion de numeros no se puede hacer con esta funcion");
        }
        MatJa.comprobarDoMatriz(prim, seg);
        int numi=0,gato=0;
        double[][]jaula=new double[seg.length][seg[0].length];
        for(double [] paso:prim) {
            numi=0;
            for (double ga : paso) {
                jaula[gato][numi] = Math.max(ga, seg[gato][numi]);

                numi++;
            }
            gato++;
        }
        return jaula;

    }
    //aqui restaurare restonVect
    /**resta de matrices*/
    public static double[][] restonVect(double[][] prim,double[][]seg){
        MatJa.comprobarDoMatriz(prim, seg);
        double[][] pabl;
       
        int movi=0;
        double [] [] pirata=new double[prim.length][seg[0].length];
        if(prim[0].length==1&&seg.length==1){
           
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     pirata[tos][movi]= prim[tos][0]-seg[0][movi];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return pirata;
        }
        double[][] poro=MatJa.memoriaFantasma(prim);
        prim=MatJa.memoriaFantasma(seg);
        seg=poro;
        double [] [] piraña=new double[prim.length][seg[0].length];
 if(prim[0].length==1&&seg.length==1){
            
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     piraña[tos][movi]= seg[0][movi]-prim[tos][0];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return piraña;
        }
               
        if(((((prim[0].length==1&&prim.length==1)||(seg[0].length==1&&seg.length==1))|| prim[0].length==seg[0].length)&((prim.length<=1&seg.length>=1)||(seg.length<=1&prim.length>=1)))||(seg.length==prim.length&&seg[0].length==prim[0].length)){
           if(seg.length>prim.length||seg[0].length>prim[0].length) {
               
               pabl = new double[seg.length][seg[0].length];
           }
           else {
               
               pabl = new double[prim.length][prim[0].length];
           }
           
          
        int conta=0;
           int co=0;
           int colus=0;
           int pilo=0;

            int tamaño=prim[0].length,taman=prim.length;
            //System.out.println(tamaño);
            //System.out.println(taman); 
            if(prim.length==1){
               
                tamaño=seg[0].length;
                taman=seg.length;
            }

        for(int conti=0; conti<taman;  conti++ ){
            pilo=0;
            colus=0;

            for (int contu=0; contu< tamaño; contu++){
                //fue jodido si pero casi se logra
                if(prim.length==1&&prim[0].length==1){

                    conta=0;
                    pilo=0;
                }
                if(seg.length==1&& seg[0].length==1){
                    co=0;
                    colus=0;
                }
                if(prim.length==1){
                    conta=0;
                }
                if(seg.length==1){
                    co=0;
                }

                pabl[conti][contu]=seg[co][colus]-prim[conta][pilo];

                colus++;
                pilo++;
            }
            co++;
            conta++;

        }





        }
        else{
            System.out.println("error por favor corrige uno de estos");

            System.out.println("primero");
            MatJa.impMat(prim);
            System.out.println("segundo ");
            MatJa.impMat(seg);

            System.out.println("error por favor modifica una de tus doubles que ingresaste");

            throw new ArrayIndexOutOfBoundsException("error por favor corrige prim o sec");

        }
        return pabl;
    }
    /**se crea una matriz con numero euler de filas y columnas asignadas*/
    public static double[][] E(int filas,int columnas){
        int columna=0;
        int fila=0;
        double solo=0;
        //System.out.println("filas"+filas+"columnas"+columnas);
        double [][] matriz=new double[filas][columnas];
        double [][]mov=new double[matriz.length][matriz[0].length];
        for(double []poit: matriz){
            fila=0;
            for(double pan : poit){
                solo=poy.nextDouble();
                mov[columna][fila]= Math.E;
                //System.out.println(mov[columna][fila]+" columna "+columna+" fila "+fila);
                //aqui modifique algo

                fila++;
            }

            //aqui igual

            columna++;}

        polilla=mov;
        return mov;
    }
    /**esta funcion nace como sulicion al problema de guardar matrices evitaras tener que guardar 
     * la matriz en una variable ya que esta trae problemas esta funcion es para tres dimenciones*/
    public static double [][][]memoriaFantasma(double[][][] errore) {
        int gato = 0;
        int pol = 0;
        int pio = 0;
        double[][][] polilla = new double[errore.length][errore[0].length][errore[0][0].length];
        for (double[][] poli : errore) {
            pol=0;

            for (double[] pu : poli) {
                gato=0;

                for (double pis : pu) {
                    polilla[pio][pol][gato]=pis;

                    gato++;
                }
                pol++;
            }
            pio++;


        }
        return polilla;
    }
    /**alamcenar una matriz de dos diemnciones arregla muchos problemas relacionados a 
     *asignacion de una variable con una matriz */
    public static double [][]memoriaFantasma(double[][] errore) {
        int gato = 0;
        int pol = 0;
        double[][] polilla = new double[errore.length][errore[0].length];


            for (double[] pu : errore) {
                gato=0;

                for (double pis : pu) {
                    polilla[pol][gato]=pis;

                    gato++;
                }
                pol++;
            }




        return polilla;
    }
    /**ingresa un numero a la primera columa de la matriz*/
    public static double [][]inse1(double [] []prim,double numero){
        int numi=0,gato=0;
        double pel=0;
        double[][]jaula=new double[prim.length][prim[0].length+1];
        int py=1;
        for(double [] paso:jaula) {
            numi=0;
            py=0;
            for (double ga : paso) {
                if(numi==0){
                    jaula[gato][numi] = numero;
                }
                else {
                    jaula[gato][numi] = prim[gato][py-1];

                }
                py++;
                numi++;
            }

            gato++;
        }
        return jaula;

    }
    /**multiplicacion vectorial comprobar muy bien tiene errores*/
    public static double[][] x(double[][] prim,double[][]seg){
       MatJa.comprobarDoMatriz(prim, seg);
        double[][] pabl;
       
        int movi=0;
        double [] [] pirata=new double[prim.length][seg[0].length];
        if(prim[0].length==1&&seg.length==1){
           
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     pirata[tos][movi]= prim[tos][0]*seg[0][movi];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return pirata;
        }
        double[][] poro=MatJa.memoriaFantasma(prim);
        prim=MatJa.memoriaFantasma(seg);
        seg=poro;
        double [] [] piraña=new double[prim.length][seg[0].length];
 if(prim[0].length==1&&seg.length==1){
            
           for(double [] puo: seg){
               
               for(int tos=0; tos<prim.length; tos++){
                  movi=0;
                   for(double pito: puo){
                  
                     piraña[tos][movi]= seg[0][movi]*prim[tos][0];
                     //System.out.print(seg[0][movi]);
                     //System.out.print(prim[mueve][0]);
                     
                     movi++;
                   }
                  
                
               }
               
               
           }
           return piraña;
        }
               
        if(((((prim[0].length==1&&prim.length==1)||(seg[0].length==1&&seg.length==1))|| prim[0].length==seg[0].length)&((prim.length<=1&seg.length>=1)||(seg.length<=1&prim.length>=1)))||(seg.length==prim.length&&seg[0].length==prim[0].length)){
           if(seg.length>prim.length||seg[0].length>prim[0].length) {
               
               pabl = new double[seg.length][seg[0].length];
           }
           else {
               
               pabl = new double[prim.length][prim[0].length];
           }
           
          
        int conta=0;
           int co=0;
           int colus=0;
           int pilo=0;

            int tamaño=prim[0].length,taman=prim.length;
            //System.out.println(tamaño);
            //System.out.println(taman); 
            if(prim.length==1){
               
                tamaño=seg[0].length;
                taman=seg.length;
            }

        for(int conti=0; conti<taman;  conti++ ){
            pilo=0;
            colus=0;

            for (int contu=0; contu< tamaño; contu++){
                //fue jodido si pero casi se logra
                if(prim.length==1&&prim[0].length==1){

                    conta=0;
                    pilo=0;
                }
                if(seg.length==1&& seg[0].length==1){
                    co=0;
                    colus=0;
                }
                if(prim.length==1){
                    conta=0;
                }
                if(seg.length==1){
                    co=0;
                }

                pabl[conti][contu]=seg[co][colus]*prim[conta][pilo];

                colus++;
                pilo++;
            }
            co++;
            conta++;

        }





        }
        else{
            System.out.println("error por favor corrige uno de estos");

            System.out.println("primero");
            MatJa.impMat(prim);
            System.out.println("segundo ");
            MatJa.impMat(seg);

            System.out.println("error por favor modifica una de tus doubles que ingresaste");

            throw new ArrayIndexOutOfBoundsException("error por favor corrige prim o sec");

        }
        return pabl;
    }
    //me di cuenta de algo muy importante y que da problemas al evaluar el sesgo
       /**
        * funcion para sumar el sesgo esta en fase beta no usar*/
    public static double [][]SumaSesgada(double [][] gato,double[] sesgo){
 
        double [][]matr=new double[gato.length][gato[0].length];
        int polio=0;
        int para=0;
        for(double []paradox:gato){
            para=0;
            for(double poli:paradox){
                matr[polio][para]=sesgo[para]+poli;

                para++;
            }
            polio++;
        }
        return  matr;
    }
}

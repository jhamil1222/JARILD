package com.jARIL;

public class MatJa extends inclusion{
    public static double sumatoriaV(double[][]op){

        double pan=0;
        for(double[] i:op){
            for(double po:i){
                pan+=po;

            }

        }
        return pan;
    }
    /** funcion que conecta todas estas clases para poder generar una libreria biable */
    public static double[][] SumVect(double[][] prim,double[][]seg){
        int numi=0,gato=0;
        double[][]jaula=new double[seg.length][seg[0].length];
        boolean sota=true;

        double[][] se;
        if(seg[0].length==1|| prim[0].length==1&&seg.length==1|prim.length==1){
            //jaula=new double[prim.length][seg.length];
            se=seg;
            seg=prim;
            if(prim[0].length==1){
                seg=se;
                se=prim;

            }
            jaula=new double[seg.length][seg[0].length];




            for(double[]poli:seg){
                numi=0;
                for(double pio:poli){
                    jaula[gato][numi]=se[0][0]+pio;
                    numi++;
                }
                gato++;
            }

            sota=false;
            return jaula;

        }
        if(seg.length!=1&prim.length!=1||seg.length==prim.length&&sota){

            for(double [] paso:prim) {
                numi=0;
                for (double ga : paso) {

                    jaula[gato][numi] = ga + seg[gato][numi];

                    numi++;
                }
                gato++;
            }

        }
        else{
            int puerquito=0;
            int pollito=0;
            int puito=0;
            double[][]resultado=new double[prim.length][prim[0].length];
            if(seg.length==1){
                for(double[]poli:prim){
                    pollito=0;
                    puito=0;

                    for(double pio:poli){
                        resultado[puerquito][pollito]=seg[0][puito]+pio;
                        if(puito<seg[0].length-1){
                            puito++;
                        }
                        pollito++;
                    }
                    puerquito++;
                }

                return resultado;

            }
            resultado=new double[seg.length][prim[0].length];
            if(prim.length==1){
                for(double[]poli:seg){
                    pollito=0;
                    for(double pio:poli){
                        resultado[puerquito][pollito]=prim[0][pollito]+pio;
                        pollito++;
                    }
                    puerquito++;
                }

                return resultado;
            }
        }

        return jaula;
    }
    /*este es un error grabe pero no se tomara en cuenta a vectorno */
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
    public static double[][] DIVect(double[][] prim,double[][]seg){
        int numi=0,gato=0;
        double[][]jaula=new double[seg.length][seg[0].length];
        for(double [] paso:prim) {
            numi=0;
            for (double ga : paso) {
                jaula[gato][numi] = ga / seg[gato][numi];

                numi++;
            }
            gato++;
        }
        return jaula;
    }
    public static double[][] mulTiGran(double[][] prim,double[][]seg){
        double[][] pabl;

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
            if(prim.length==1&&prim[0].length==1){

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

                    pabl[conti][contu]=prim[conta][pilo]*seg[co][colus];

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
    public static double [][]ingresEnt(double [] []prim,double numero){
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


    public static double[][] MAX(double[][] prim,double[][] seg){
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
    public static double[][] restonVect(double[][] prim,double[][]seg){
        double[][] pabl;

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
            if(prim.length==1&&prim[0].length==1){

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

                pabl[conti][contu]=prim[conta][pilo]-seg[co][colus];

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
    public static double[][] x(double[][] prim,double[][]seg){
        double[][] pabl;

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
            if(prim.length==1&&prim[0].length==1){

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

                    pabl[conti][contu]=prim[conta][pilo]*seg[co][colus];

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

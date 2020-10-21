package com.jARIL;

public class pruebaCapas {
    private double[][] b=new double[1][1];
    private double[][][] w=new double[2][1][1];
    public pruebaCapas( int numeroNeur,int numeroCon){
        w=new double[2][numeroCon][numeroNeur];
        b=new double[1][numeroNeur];
        this.b=randMat.random(1,numeroNeur,-1,1,false);
        //asignador multi w

        this.w=new double[][][]{randMat.random(numeroCon,numeroNeur,-1,1,false),randMat.random(numeroCon,numeroNeur,-1,1,false)};
    }
    public void train(){
        //new capas_neuronales(12,13, null);
        //mul.impMat(new double[][]{new error().restaVect(new double[]{2,3,4},new double[]{1,2})});
        //System.out.println(inclusion.mediaVect( inclusion.restaVect(new double[]{4,5,6},new double[]{1,2,3})));
        //double [] vanal=inclusion.powVect(new double[]{2,2,2},2);
        //mul.impMat(new double[][]{vanal});

        double [][][]w=this.w;

        double[][] x = {{0,1}};
        int a=0;

        //existe un problema con lso arrays por ello no recomiendo trabajar con arrays en una misma funcion por que esto es lo que pasa ya que se contamina la memoria
        double[][][] cusito = new double[][][]{w[0], w[1]};
        //por ello existe una mejor forma de hacer una copia de un array
        // por lo que se ve la unica forma es crear un contenedor de variables que dependa del rendimiento
        //asignarle a una matriz otra matriz da lugar a lo que yo llamo desastre estatico ya que la
        //matriz se parece a un conjunto de variables estaticas en una clase no se asigna directo sino de uno en uno


        //nota seguir de serca x que tuene una contaminacion de meoria mouy importante
        double[][][] yugo = MatJa.memoriaFantasma(new double[][][]{x});
        double[][] b = this.b;
        double[][] y = {{1,0}};
        /*Verificar que esta parte sea viable por varias razones estoy hablando de h
         *
         * */


        //mejorar este lado

        cusito = MatJa.memoriaFantasma(w);

        double ratio = 1;
        double salidas[][][] = new double[w.length][x.length][x.length];
        double capaact[][][] = new double[w.length][x.length][x.length];
        /*con este for separamos las salidas de las capas y las salidas de
        las neuronas son la variable capaact tenemos las salidas neuronales de funcion de activacion
        y la
        variable salidas tiene como resultado las salidas neuronales
         */
        int kp=0;
        int ans=2000;
        System.out.print("cargando[");
        for (int ge = 0; ge < ans; ge++) {
            for (int gato = 0; gato < w.length; gato++) {
                x = MatJa.SumVectno(MatJa.result(x, MatJa.matTi(w[gato])), b[0][gato]);
                salidas[gato] = x;

                x = funcion_Act.sigm(x)[0];
                capaact[gato] = x;


            }
            //aqui estamos evaluando las ultimas capas obteniendo el error desde la ultima capa
            //famoso backpropagetion
            //error total de toda la red

            //aqui usamos los datos de la ultima capa de activacion que en todo caso sera dado por las capa de act
            //System.out.println(capaact[0][0][0]);
            int numerito = capaact.length - 1;
            a=numerito;
            //se evalua la ultima capa por ende tambien evaluaremos a w6
            double erri = 0;
            double[] erro = new double[capaact.length];
            int oli = 0;
            double errorW = 0;
            double put = 0;
            int sopas = 0;
            double[][] err = new double[capaact.length][capaact[0].length];
            double[] wu = new double[w.length * w[0].length];

            //solucion lineal se resolvera lo de y
            double [] pio = new  double[y[0].length];
            double bugx = 0;
            double g = 0;
            double polill = 0;
            double[][] poli;
            double pico = 0;
            double kuma = 0;
            double li = 0;


            //con este for evaluamos la ultima capa o capa de salida y todos sus valores
            sopas=0;
            for (int gat = 0; gat < capaact.length; gat++) {

                for (oli = 0; oli < w[gat][0].length; oli++) {
                    //aqui tenemos el error total evaluado en la ultima capa

                    erri = error.errCua(y, capaact[numerito],true)[0][0][0];

                    //System.out.println(erri);
                    //derivada del error total en base a la salida final
                    erro[gat] = -(error.errCua(y, capaact[numerito],true)[1][0][gat]);

                    //derivada de la activacion en base a la salida como tenemos 2 vectores no nos
                    //perocuparemos por los demas solo sabemos que serviran
                    //y2Fin*(1-y2Fin)
                    wu[sopas] = erro[gat];
                    err = MatJa.mulTiGran(capaact[numerito], (MatJa.restonVect(MatJa.ingresEnt(capaact[numerito], 1), capaact[numerito])));
                    //hacemos la famosa chein rool
                    //MatJa.impMat(capaact[numerito]);
                    //System.out.println(erro*error[0][0]);
                    //calculamos el error que viene dado a w5

                    errorW = erro[gat] * err[0][gat] * capaact[0][0][gat];
                    //System.out.println(error[0][gat] );
                    //nota aqui modificar esta variable ya que estamos usando el valor de capaact
                    put = w[1][gat][oli];

                    //calculamos el peso actualizado
                    //reemplazar gat y oli por razones de optimizacion ya que solo estan dadas a dos valores
                    w[1][gat][oli] = put - (ratio * errorW);

                    sopas++;
                }
            }
            /*aqui evaluaremos las capas ocultas pero eso si hay que modificar algunas cosas ya que estamos trabajando con
             *las demas capas restantes y en este caso ya no habria que tomar solo una capa
             */

            for (int gat = 0; gat < capaact[1][0].length; gat++) {
                for (oli = 0; oli < w[0][gat].length; oli++) {
                    //backpropagetion capas ocultas
                    //iterar estos :V
                    //aqui se agrego un for para mas fucnionabilidad
                    //si y es lineal se aplicara esta solucion mas adelante cuando esta solucion sea aplicada
                    //sera corregido

                    for(int repetidor=0; repetidor<y[0].length-1; repetidor++) {
                        pio[repetidor] = 2 * (1.0 / 2.0) * (y[0][repetidor] - capaact[capaact.length - 2][0][gat]) * (-1) * err[0][0];
                        /**revisar estas lineas posible causa de fallos**/
                        bugx = pio [repetidor]* cusito[1][0][0];
                        g = pio[repetidor] * cusito[1][1][0];
                    }

                    polill = bugx + g;
                    poli = MatJa.mulTiGran(capaact[0], (MatJa.restonVect(MatJa.ingresEnt(capaact[0], 1), capaact[0])));
                    // MatJa.impMat(poli);
                    pico = yugo[0][0][0];
                    kuma = polill * poli[0][0] * pico;
                    //MatJa.impMat(capaact[0]);
                    //aqui usamos w por que nesecitamos contaminar la memoria pero
                    //cuando nesecitemos una copia de la varible tendremos que recurrir a memoria fantasma
                    li = w[0][gat][oli] - (ratio * kuma);
                    w[0][gat][oli] = li;
                    sopas++;
                }
            }

            //MatJa.impMat( h[1]);
            //MatJa.impMat(h);
            //double[][] poli=MatJa.SumVectno(h,b);
            if(kp==ans/10){
                System.out.print("/");
                kp=0;
            }
            kp++;
            // System.out.printf("tu error es de %.9f",erri);
        }
        System.out.print("]");
        System.out.println("salidas de la neurona");
        MatJa.impMat(capaact[1]);
        /*aqui estableci un control mucho mas riguroso de la salida esta bien que se entrene y todo pero al obtener
         *una salida de las capas sigmoidiales estas estan dadas por la cantidad de entradas y por ende el numero de
         * entradas genera lo que yo llamo entradas raras*/
        System.out.printf("%.10f",error.errCua(y, capaact[a])[0][0][0]);


    }
}

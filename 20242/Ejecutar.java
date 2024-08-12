public class Ejecutar {
    public static void main(String[] args){
        System.out.println("Programacion Oientada a Objetos");
        //COMENTARIOS DE UNA SOLA LINEA
        /*
         * comentario de
         * varias
         * lineas
         */
        //java la asignacion es con el = (igual)
        //a=5 
        //b= 10
        /*
         * Tipos de datos en java
         * numericos--> int, log, float y double
         * booleanos --> logicos
         * cadena --> char y string 
         */
         //ejericio 1

         int b = 2; 
         int areacuadrado = b * b;
         System.out.println("Area del cuadrado = "+ areacuadrado);
         // Para encontrar texto con variables se utiliza el signo
         /* solucion ejercicio 2
          * radio, pi
          areacirculo= pi(r*r)
          areacirculo

          */
          double r= 0.0; //variable
          final double PI= 3.1416; 
          r = 3;
          double areacirculo = Math.PI * Math.pow(r,2);
          System.out.println("el area del circulo es: " + areacirculo);
          //ejecicio 3 
          double c = 0.0;
          double f = 0.0;
           c = 1;
           f = 1;
          double gradoscelsius = (c*9/5)+32;
          double gradosfarenheit = (f-32)/1.8;
          System.out.println(c  +" Grados celsious a farenheit es: "+ gradoscelsius);
          System.out.println(f + " Grados farenheit a celsius es: "+ gradosfarenheit);

    }
}
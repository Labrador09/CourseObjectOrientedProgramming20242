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

        // Ejercicio 4
        double salarioneto = 0.0;
        double salariobruto = 0.0;
        double deducciones = 0.0;
        double comision = 0.0;
        salariobruto = 1300000;
        deducciones = salariobruto * 0.08;
        comision = 150000;
        double salarioneto1 = (salariobruto-deducciones) + comision; 
        System.out.println( salarioneto1 + " Es el salario del empleado");
        //Ejercicio 5
        double d = 0;
        double e = 0;
        double p = 0;
        p = 5000;
        e = 0.00023;
        d = 0.00025;
        double Pesosaeuros = p * e;
        double Pesosadolares = p * d;
        System.out.println(p + " Pesos colombianos a euros son: " + Pesosaeuros);
        System.out.println(p + " Pesos colombianos a dolares son: " + Pesosadolares);
        double H = 5;
        double v = 2000;
        double i = 0;
        i = (H * v) * 0.2;
        double pago = (H * v) + i;
        double total = H*v;
        System.out.println("El total de horas fueron: " + H + "Significa que total de pago sin iva es de: "+ total + "Con iva y el total a pagar es de :"+ pago);




    }
}
package Composicion;

import Herencia.Trabajador;

public class Nomina {
    public static void main(String[] args) {
        Trabajo[] Trabajos = new Trabajo[3];
        Trabajos[0]= new Operario("BADBUNNY", 20, "15524514", "Operario", 0, 20, 5);
        Trabajos[1]= new Analista("Arcangel", 34, "12514154", "Analista", 0, 0);
        Trabajos[2]= new Consultor("S3NDOCABRON", 25, "12113233", "Consultor", 0, 50000);
        
        double totalsalario = 0.0;
        for (Trabajo trabajo : Trabajos){
            totalsalario += trabajo.salario();
        }
        for (Trabajo trabajo : Trabajos){
            System.out.println(trabajo.getNombre() + " "+ trabajo.salario());
        }
        
}
}

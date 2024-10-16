package Composicion;

public class Analista extends Trabajo {
    

    private double sueldointegral = 1600000;

    public Analista(String nombre, int edad, String id, String cargo, double salario, double sueldointegral) {
        super(nombre, edad, id, cargo, salario);
    }

    public double getSueldointegral() {
        return sueldointegral;
    }

    public double salario(){
        return sueldointegral;
    }

}
    

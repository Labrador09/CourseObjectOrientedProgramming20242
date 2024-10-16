package Composicion;

public class Consultor extends Trabajo {
    
    private final double salariobasico = 1600000;
    private double comision; 

    public Consultor(String nombre, int edad, String id, String cargo, double salario, double comision) {
        super(nombre, edad, id, cargo, salario);
        this.comision = comision;
    }

    public double getSalariobasico() {
        return salariobasico;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    public double salario(){
        return salariobasico + (comision);
    }
    
}

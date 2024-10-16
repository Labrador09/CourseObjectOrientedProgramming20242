package Composicion;

public class Operario extends Trabajo {

    
    private final double salariobasico = 1500000;
    private int valorhoras = 40000;
    private int horas_extras;

    public Operario(String nombre, int edad, String id, String cargo, double salario, int horas, int horas_extras) {
        super(nombre, edad, id, cargo, salario);
        this.valorhoras = horas;
        this.horas_extras = horas_extras;
    }

    public double getSalariobasico() {
        return salariobasico;
    }

    public int getHoras() {
        return valorhoras;
    }

    public void setHoras(int horas) {
        this.valorhoras = horas;
    }
    
    public double salario() {
        return salariobasico + ((valorhoras) * horas_extras);
        
    }
}

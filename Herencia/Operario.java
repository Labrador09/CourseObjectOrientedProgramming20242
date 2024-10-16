package Herencia;

public class Operario extends Trabajador {
    private double horas = 5.4;
    public final double SALARIO_HORA = 60000.0;

    public Operario (String nombre, String area, int id, double horas) {
        super(id, area, nombre);
        this.horas = horas;
    }
    
    public double getHoras() {
        return horas;
    }

    public double salario (){
        return SALARIO_HORA * horas;
    }
}

package Herencia;

public class Vendedor  extends Trabajador {
    public final double VENTAS = 120000.0;
    private double comision;
    
    public Vendedor(int id, String nombre, String area, double comision) {
        super(id, nombre, area);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }
    public double salario(){
        return (VENTAS * (comision/100)) + comision ;
    }

}

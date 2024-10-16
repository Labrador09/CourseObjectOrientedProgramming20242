package Herencia;

public class EjecutarHerencia {
    public static void main(String[] args) {
        Trabajador objTrabajador1 = new Vendedor (1, "hazard", "computacion", 20.0);
        Trabajador objTrabajador2 = new Vendedor (2, "NGolo", "Programacion", 10.0);

        Trabajador objTrabajador3 = new Operario("Pedrito", "Electrodomesticos", 3, 100);
        Trabajador objTrabajador4 = new Operario("Travis Scott", "aseo", 4, 150);

        System.out.println("Salario del vendedor: "+ objTrabajador1.salario());
        System.out.println("Salario del Operiario: "+ objTrabajador3.salario());

        System.out.println(objTrabajador1 instanceof Vendedor);
        System.out.println(objTrabajador1 instanceof Trabajador);

        Trabajador[] t = new Trabajador[4];
        t[0] = objTrabajador1;
        t[1] = objTrabajador2;
        t[2] = objTrabajador3;
        t[3] = objTrabajador4;

        for (int i = 0; i < t.length; i++){
            System.out.println(t[i].getClass() + " - "+ t[i].getNombre() + " - "+ t[i].salario());
        }
    }
}

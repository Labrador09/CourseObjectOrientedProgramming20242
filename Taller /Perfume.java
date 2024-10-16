import java.util.Scanner;

public class Perfume {
    
    private String nombre;
    private String marca;
    private double capacidad;
    private double precio;
    private Scanner scanner = new Scanner(System.in);

    public Perfume (String nombre, String marca, double capacidad, double precio){

        this.nombre = nombre;
        this.marca = marca;
        this.capacidad = capacidad;
        this.precio = precio;

    }

    public void aplicarPerfume() {
        System.out.print("Ingrese la cantidad de perfume a aplicar (en ml): ");
        double cantidad = scanner.nextDouble();

        if (cantidad > 0) {
            if (cantidad <= capacidad) {
                capacidad -= cantidad;
                System.out.println("Te aplicaste: " + cantidad + " ml de " + nombre);
                System.out.println("Capacidad restante: " + capacidad + " ml");
            } else {
                System.out.println("No hay suficiente perfume. Capacidad restante: " + capacidad + " ml");
            }
        } else {
            System.out.println("La cantidad debe ser mayor a 0");
        }

    }
}

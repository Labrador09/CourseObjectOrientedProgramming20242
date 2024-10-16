package Herencia.Persona;

public class Estudiante extends Persona {
    private String carrera;

    public Estudiante(String nombre, int edad, String id, String email, String telefono, String carrera) {
        super(nombre, edad, id, email, telefono);
        this.carrera = carrera;
    }

    // Getter para carrera
    public String getCarrera() {
        return carrera;
    }
}
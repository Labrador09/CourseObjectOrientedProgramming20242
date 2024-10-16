package Herencia.Persona;

public class Profesor extends Persona {
    private String materia;

    public Profesor(String nombre, int edad, String id, String email, String telefono, String materia) {
        super(nombre, edad, id, email, telefono);
        this.materia = materia;
    }

    // Getter para materia
    public String getMateria() {
        return materia;
    }
}

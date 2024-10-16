package Herencia.Persona;

public class Persona {
    private String nombre;
    private int edad;
    private String id;
    private String email;
    private String telefono;

    public Persona(String nombre, int edad, String id, String email, String telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    } 
    
}

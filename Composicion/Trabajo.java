package Composicion;

public class Trabajo {
    
    private String nombre;
    private int edad;
    private String id;
    private String cargo;
    private double salario;

    public Trabajo(String nombre, int edad, String id, String cargo, double salario){
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
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

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "trabajo [nombre=" + nombre + ", edad=" + edad + ", id=" + id + ", cargo=" + cargo + ", salario="
                + salario + "]";
    }
    public double salario() {
        salario = 0;
        return salario;
    }

    }
    



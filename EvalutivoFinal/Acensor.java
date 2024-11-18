package EvalutivoFinal;

public class Acensor {
    private int pisoActual;
    private String direccion; // "subir" o "bajar"
    private boolean puertasAbiertas;
    private boolean enMovimiento;

    public Acensor(int pisoInicial) {
        this.pisoActual = pisoInicial;
        this.puertasAbiertas = false;
        this.enMovimiento = true;
    }

    public void mover(int pisoDestino) { // Metodo para el movimiento del Ascensor
        if (!enMovimiento) {
            System.out.println("Ascensor detenido por emergencia.");
            return;
        }

        if (pisoDestino > pisoActual) { // Si es mayor Sube
            direccion = "subiendo";
        } else if (pisoDestino < pisoActual) { //Si es menor baja 
            direccion = "bajando";
        }
        pisoActual = pisoDestino;
        System.out.println("Ascensor movido al piso " + pisoActual);
    }

    public void abrirPuertas() { // Metodo para poder abrir las puertas del ascensor
        puertasAbiertas = true;
        System.out.println("Puertas abiertas en el piso " + pisoActual);
    }

    public void cerrarPuertas() { // Metodo para poder cerrar las puertas del ascensor
        puertasAbiertas = false;
        System.out.println("Puertas cerradas en el piso " + pisoActual);
    }

    public void detenerAscensor() { // Metodo para detener el acensor en lugar de emergencia
        puertasAbiertas = false;
        enMovimiento = false;
        abrirPuertas();
        System.out.println("Ascensor detenido en el piso " + pisoActual + " por activación de emergencia.");
    }
    public void reanudarMovimiento() { //Metodo para renudar el movimiento despues de una emergencia o error
        enMovimiento = true;
        System.out.println("Ascensor reanudado.");
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public boolean isPuertasAbiertas() {
        return puertasAbiertas;
    }

     
}
    
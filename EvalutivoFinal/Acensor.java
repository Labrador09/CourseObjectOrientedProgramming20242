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

    public void mover(int pisoDestino) {
        if (!enMovimiento) {
            System.out.println("Ascensor detenido por emergencia.");
            return;
        }

        if (pisoDestino > pisoActual) {
            direccion = "subiendo";
        } else if (pisoDestino < pisoActual) {
            direccion = "bajando";
        }
        pisoActual = pisoDestino;
        System.out.println("Ascensor movido al piso " + pisoActual);
    }

    public void abrirPuertas() {
        puertasAbiertas = true;
        System.out.println("Puertas abiertas en el piso " + pisoActual);
    }

    public void cerrarPuertas() {
        puertasAbiertas = false;
        System.out.println("Puertas cerradas en el piso " + pisoActual);
    }

    public void detenerAscensor() {
        puertasAbiertas = false;
        enMovimiento = false;
        abrirPuertas();
        System.out.println("Ascensor detenido en el piso " + pisoActual + " por activación de emergencia.");
    }
    public void reanudarMovimiento() {
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
    
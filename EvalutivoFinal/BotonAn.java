package EvalutivoFinal;

public class BotonAn {
    private String tipo; // "subida", "bajada", o "seleccion de piso"
    private boolean iluminado;

    public BotonAn(String tipo) {
        this.tipo = tipo;
        this.iluminado = false;
    }

    public void presionar() {
        iluminado = true;
        System.out.println("Botón de " + tipo + " presionado\n=== iluminado y Produce un sonido ===");

    }
    public void desactivar() {
        iluminado = false;
        System.out.println("Indicador del botón de " + tipo + " desactivado.");
    }

    public boolean isIluminado() {
        return iluminado;
    }
    public void cambiarTipo(String nuevoTipo) {
        this.tipo = nuevoTipo;
    }
}
    

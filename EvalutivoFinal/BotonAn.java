package EvalutivoFinal;

public class BotonAn {
    private String tipo; // "subida", "bajada", o "seleccion de piso"
    private boolean iluminado;

    public BotonAn(String tipo) {
        this.tipo = tipo;
        this.iluminado = false;
    }

    // Método para simular que el botón ha sido presionado
    public void presionar() {
        iluminado = true; // Cambia el estado a iluminado
        System.out.println("Botón de " + tipo + " presionado\n=== iluminado y Produce un sonido ===");
    }

    // Método para desactivar el estado iluminado del botón
    public void desactivar() {
        iluminado = false; // Cambia el estado a no iluminado
        System.out.println("Indicador del botón de " + tipo + " desactivado.");
    }

    // Método para verificar si el botón está iluminado
    public boolean isIluminado() {
        return iluminado; // Devuelve el estado actual del botón
    }

    // Método para cambiar el tipo del botón en caso de ser necesario
    public void cambiarTipo(String nuevoTipo) {
        this.tipo = nuevoTipo; // Actualiza el tipo del botón
    }
}

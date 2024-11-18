package EvalutivoFinal;

public class Piso {
    
    private int numero;
    protected BotonAn botonSubida;
    protected BotonAn botonBajada;
    

    public Piso(int numero) {
        this.numero = numero;
        this.botonSubida = new BotonAn("Subida");
        this.botonBajada = new BotonAn("Bajada");
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BotonAn getBotonSubida() {
        return botonSubida;
    }

    public void setBotonSubida(BotonAn botonSubida) {
        this.botonSubida = botonSubida;
    }

    public BotonAn getBotonBajada() {
        return botonBajada;
    }

    public void setBotonBajada(BotonAn botonBajada) {
        this.botonBajada = botonBajada;
    }
    
    
    

}

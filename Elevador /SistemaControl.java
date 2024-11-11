import java.util.ArrayList;
import java.util.List;

public class SistemaControl {
    private Ascensor ascensor;
    private List<Piso> pisos;
    private List<Integer> solicitudes;
    private boolean obstaculoDetectado = false;
    private boolean botonEmergencia = false;
    private boolean puertasAbiertas = false;
    private Boton boton = new Boton("piso");
    private Boton botonsub = new Boton("subida");
    private Boton botonbaj = new Boton("bajada");

    public SistemaControl(int numPisos, int pisoInicial) {
        ascensor = new Ascensor(pisoInicial);
        pisos = new ArrayList<>();
        for (int i = 1; i <= numPisos; i++) {
            pisos.add(new Piso(i));
        }
        solicitudes = new ArrayList<>();
    }
    
}

   

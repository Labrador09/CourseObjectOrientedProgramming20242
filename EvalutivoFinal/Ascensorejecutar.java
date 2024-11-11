package EvalutivoFinal;

public class Ascensorejecutar {
    
    public static void main(String[] args) {
        
        SistemaControl sistemaControl = new SistemaControl(10, 1, 1);
        
        sistemaControl.estadoAscensor();

        sistemaControl.solicitarLlamada(5, 10, "Subir");
        sistemaControl.solicitarLlamada(8, 10, "Subir");
        
        sistemaControl.detectarObstaculo(true);
        sistemaControl.detectarObstaculo(false);

        sistemaControl.procesarSolicitudes();

        sistemaControl.solicitarLlamada(7, 3, "Bajar");
        sistemaControl.manejarFalla("falla la puerta");

        

        sistemaControl.estadoAscensor();

        sistemaControl.moverAscensor(1);

        }
        
}

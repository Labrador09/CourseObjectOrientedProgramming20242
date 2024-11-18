package EvalutivoFinal;

import java.util.ArrayList;

public class SistemaControl {

    // Atributos principales del sistema
    private BotonAn boton; // Botón principal del sistema
    private Acensor acensor; // Instancia del ascensor
    private Puerta puerta; // Instancia de las puertas del ascensor
    private BotonAn botonsub = new BotonAn("subida"); // Botón para indicar subida
    private BotonAn botonbaj = new BotonAn("bajada"); // Botón para indicar bajada
    private boolean botonEmergencia = false; // Indica si el botón de emergencia está activo
    private boolean obstaculoDetectado = false; // Indica si se detecta un obstáculo en las puertas
    private boolean puertasAbiertas = false; // Indica si las puertas están abiertas
    private final int PISO_MAXIMO; // Piso máximo permitido por el sistema
    private final int PISO_MINIMO; // Piso mínimo permitido por el sistema
    private int pisoActual; // Piso actual donde se encuentra el ascensor

    private ArrayList<SolicitudLlamada> solicitudesLlamada = new ArrayList<>(); // Lista de solicitudes de llamada al ascensor

    // Clase interna para representar solicitudes de llamada al ascensor
    private static class SolicitudLlamada {
        int piso; // Piso donde se realiza la llamada
        int pisoDestino; 
        String direccion; // Dirección de la llamada (subida/bajada)
        boolean obstaculo; 
        
        // Constructor para inicializar las solicitudes de llamada
        SolicitudLlamada(int piso, int pisoDestino, String direccion) {
            this.piso = piso;
            this.pisoDestino = pisoDestino;
            this.direccion = direccion;
        }
    }

    // Método para reanudar el movimiento del ascensor
    public void reanudarMovimiento(boolean enMovimiento) {
        enMovimiento = true;
        System.out.println("Ascensor reanudado.");
    }

    // Método para activar el botón de emergencia
    public void activarBotonEmergencia() {
        botonEmergencia = true; // Activa el estado de emergencia
        acensor.detenerAscensor(); // Detiene el ascensor
        acensor.abrirPuertas(); // Abre las puertas
        puertasAbiertas = true; // Actualiza el estado de las puertas
        System.out.println("Botón de emergencia activado. El ascensor se detiene y las puertas se abren.");
    }

    // Método para desactivar el botón de emergencia
    public void desactivarBotonEmergencia() {
        botonEmergencia = false; // Desactiva el estado de emergencia
        puertasAbiertas = false; // Cierra las puertas
        acensor.cerrarPuertas();
        System.out.println("Botón de emergencia desactivado. El ascensor se reanuda.");
    }

    // Método para manejar fallas en componentes del ascensor
    public void manejarFalla(String componente) {
        System.out.println("-------ALERTA------- \nFalla detectada en el componente " + componente);
        acensor.abrirPuertas();
        System.out.println("Enviando alerta al equipo de mantenimiento..., al piso " + pisoActual);
        try {
            Thread.sleep(8000); // Simula el tiempo de reparación
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("/////El Ascensor ha sido arreglado. El Ascensor vuelve en movimiento :)////");
        acensor.reanudarMovimiento(); // Reanuda el movimiento del ascensor
        acensor.cerrarPuertas(); // Cierra las puertas y renueva el moviemiento
    }

    // Método para detectar y manejar obstáculos en las puertas
    public void detectarObstaculo(boolean obstaculo) {
        obstaculoDetectado = obstaculo;
        if (obstaculoDetectado) {
            puertasAbiertas = true;
            System.out.println("Obstáculo detectado. Las puertas permanecerán abiertas hasta que se elimine el obstáculo.");
            acensor.abrirPuertas();
        } else {
            puertasAbiertas = false;
            System.out.println("Obstáculo eliminado. Las puertas se cierran.");
            acensor.cerrarPuertas();
        }
    }

    // Método para registrar solicitudes de llamada al ascensor
    public void solicitarLlamada(int piso, int pisoDestino, String direccion) {
        if (piso < PISO_MINIMO || piso > PISO_MAXIMO || pisoDestino < PISO_MINIMO || pisoDestino > PISO_MAXIMO) {
            System.out.println("Solicitud de " + direccion + " en el piso " + piso + "  NO fue registrada. \n ---------ESTE PISO SE ENCUENTRA FUERA DE RANGO--------");
            return;
        }
        solicitudesLlamada.add(new SolicitudLlamada(piso, pisoDestino, direccion));
        System.out.println("El ascensor se solicitó en el piso " + piso);
        System.out.println("Solicitud de " + direccion + " en el piso " + piso + " registrada.");
    }

    // Constructor de la clase SistemaControl
    public SistemaControl(int max, int min, int pisoInicial) {
        PISO_MAXIMO = max;
        PISO_MINIMO = min;
        pisoActual = pisoInicial; // Piso inicial donde empieza el ascensor
        acensor = new Acensor(pisoInicial); // Inicialización del ascensor
        puerta = new Puerta(); // Inicialización de las puertas
        boton = new BotonAn(""); // Inicialización del botón genérico
    }

    // Método para mover el ascensor a un piso específico
    public void moverAscensor(int pisoDestino) {
        if (botonEmergencia) {
            activarBotonEmergencia();
            System.out.println("Emergencia activada, no se puede mover el ascensor.");
            return;
        }

        if (acensor.isPuertasAbiertas()) {
            System.out.println("Error: Las puertas están abiertas. No se puede mover el ascensor.");
            return; // Detiene la operación
        }

        if (pisoDestino <= PISO_MAXIMO && pisoDestino >= PISO_MINIMO) {
            if (pisoActual != pisoDestino) {
                if (pisoDestino > pisoActual) {
                    botonsub.presionar();
                    boton.cambiarTipo("Subir");
                    acensor.setDireccion("Subiendo");
                    while (pisoActual < pisoDestino) {
                        pisoActual++;
                        acensor.setPisoActual(pisoActual);
                        System.out.println("Subiendo al piso " + pisoActual);
                    }
                } else {
                    botonbaj.presionar();
                    boton.cambiarTipo("Bajar");
                    acensor.setDireccion("Bajando");
                    while (pisoActual > pisoDestino) {
                        pisoActual--;
                        acensor.setPisoActual(pisoActual);
                        System.out.println("Bajando al piso " + pisoActual);
                    }
                }
                acensor.abrirPuertas();
                acensor.cerrarPuertas();
                boton.desactivar();
            } else {
                System.out.println("Ya estás en el piso seleccionado.");
            }
        } else {
            System.out.println("No existe el piso seleccionado.");
        }
    }

    // Procesa las solicitudes de llamada pendientes
    public void procesarSolicitudes() {
        for (SolicitudLlamada solicitud : solicitudesLlamada) {
            System.out.println("Atendiendo solicitud de " + solicitud.direccion + " en el piso " + solicitud.piso);
            mover(solicitud.piso);
            if (solicitud.obstaculo) {
                System.out.println("Obstáculo detectado en el piso " + solicitud.piso + ". Procesando obstáculo.");
                detectarObstaculo(true);
                detectarObstaculo(false);
            }
            System.out.println("Trasladando al piso destino " + solicitud.pisoDestino);
            moverAscensor(solicitud.pisoDestino);
        }
        solicitudesLlamada.clear(); // Limpiar solicitudes una vez atendidas
    }

    // Método para mostrar el estado actual del ascensor
    public void estadoAscensor() {
        acensor.getPisoActual();
        System.out.println("El ascensor se encuentra en el piso " + pisoActual);
    }

    // Método auxiliar para mover el ascensor a un piso
    public void mover(int piso) {
        if (botonEmergencia) {
            activarBotonEmergencia();
            System.out.println("Emergencia activada, no se puede mover el ascensor.");
            return;
        }

        if (acensor.isPuertasAbiertas()) {
            System.out.println("Error: Las puertas están abiertas. No se puede mover el ascensor.");
            return;
        }

        if (piso <= PISO_MAXIMO && piso >= PISO_MINIMO) {
            if (pisoActual != piso) {
                if (piso > pisoActual) {
                    acensor.setDireccion("Subiendo");
                    while (pisoActual < piso) {
                        pisoActual++;
                        acensor.setPisoActual(pisoActual);
                        System.out.println("Subiendo al piso " + pisoActual);
                    }
                } else {
                    acensor.setDireccion("Bajando");
                    while (pisoActual > piso) {
                        pisoActual--;
                        acensor.setPisoActual(pisoActual);
                        System.out.println("Bajando al piso " + pisoActual);
                    }
                }
                acensor.abrirPuertas();
                acensor.cerrarPuertas();
            } else {
                System.out.println("Ya estás en el piso seleccionado.");
            }
        } else {
            System.out.println("No existe el piso seleccionado.");
        }
    }
}
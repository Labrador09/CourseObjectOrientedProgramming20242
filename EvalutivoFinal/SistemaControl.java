package EvalutivoFinal;

import java.util.ArrayList;

public class SistemaControl {

    private BotonAn boton;
    private Acensor acensor;
    private Puerta puerta;
    private BotonAn botonsub = new BotonAn("subida");
    private BotonAn botonbaj = new BotonAn("bajada");
    private boolean botonEmergencia = false;
    private boolean obstaculoDetectado = false;
    private boolean puertasAbiertas = false;
    private final int PISO_MAXIMO;
    private final int PISO_MINIMO;
    private int pisoActual;

    private ArrayList<SolicitudLlamada> solicitudesLlamada = new ArrayList<>();

    // Clase interna para representar solicitudes de llamada
    private static class SolicitudLlamada {
        int piso;
        int pisoDestino;
        String direccion;
        boolean obstaculo;

        SolicitudLlamada(int piso, int pisoDestino, String direccion) {
            this.piso = piso;
            this.pisoDestino = pisoDestino;
            this.direccion = direccion;
        }
    }
    public void reanudarMovimiento(boolean enMovimiento) {
        enMovimiento = true;
        System.out.println("Ascensor reanudado.");
    }
    public void activarBotonEmergencia() {
        botonEmergencia = true;
        acensor.detenerAscensor();
        acensor.abrirPuertas();
        puertasAbiertas = true;
        System.out.println("Botón de emergencia activado. El ascensor se detiene y las puertas se abren.");
    }

    public void desactivarBotonEmergencia() {
        botonEmergencia = false;
        puertasAbiertas = false;
        acensor.cerrarPuertas();
        System.out.println("Botón de emergencia desactivado. El ascensor se reanuda.");
    }
    public void manejarFalla(String componente) {
        System.out.println("-------ALERTA------- \nFalla detectada en el componente " + componente);
        // Enviar alerta al equipo de mantenimiento
        System.out.println("Enviando alerta al equipo de mantenimiento...");
        try {
            Thread.sleep(8000); // Espera 1 segundo antes de verificar nuevamente
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("/////El Ascensor ha sido arreglado. El Ascensor vuelve en moviento :)////");
        // Detener el ascensor en el piso más cercano
        
        acensor.reanudarMovimiento();
        acensor.abrirPuertas();
    }

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

    public void solicitarLlamada(int piso, int pisoDestino, String direccion) {
        if (piso < PISO_MINIMO || piso > PISO_MAXIMO || pisoDestino < PISO_MINIMO || pisoDestino > PISO_MAXIMO) {

            System.out.println("Solicitud de " + direccion + " en el piso " + piso + "  NO fue registrada. \n ---------ESTE PISO SE ENCUENTRA FUERA DE RANGO--------");
          
            return;
        }
        solicitudesLlamada.add(new SolicitudLlamada(piso, pisoDestino, direccion));
        System.out.println("El ascensor se solicitó en el piso " + piso);
        System.out.println("Solicitud de " + direccion + " en el piso " + piso + " registrada.");
    }

    public SistemaControl(int max, int min, int pisoInicial) {
        PISO_MAXIMO = max;
        PISO_MINIMO = min;
        pisoActual = pisoInicial; // Asignamos el piso inicial directamente aquí
        acensor = new Acensor(pisoInicial); // Inicializamos el ascensor con el piso inicial correcto
        puerta = new Puerta();
        boton = new BotonAn("");
    }

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

    public void procesarSolicitudes() {
        for (SolicitudLlamada solicitud : solicitudesLlamada) {
            System.out.println("Atendiendo solicitud de " + solicitud.direccion + " en el piso " + solicitud.piso);
            mover(solicitud.piso);
            if (solicitud.obstaculo) {
                System.out.println("Obstáculo detectado en el piso" + solicitud.piso +  "Procesando obstáculo.");
                detectarObstaculo(true);
                detectarObstaculo(false);
            }
            System.out.println("Trasladando al piso destino " + solicitud.pisoDestino);
            moverAscensor(solicitud.pisoDestino);
        }
        solicitudesLlamada.clear(); // Limpiar solicitudes de llamada una vez atendidas
    }

    public void estadoAscensor() {
        acensor.getPisoActual();
        System.out.println("El ascensor se encuentra en el piso " + pisoActual);
    }

    public void mover(int piso) {
        if (botonEmergencia) {
            activarBotonEmergencia();
            System.out.println("Emergencia activada, no se puede mover el ascensor.");
            return;
        }

        if (acensor.isPuertasAbiertas()) {
            System.out.println("Error: Las puertas están abiertas. No se puede mover el ascensor.");
            return; // Detiene la operación
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
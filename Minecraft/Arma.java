package Minecraft;
import java.util.Random;
import java.util.Scanner;

public class Arma {
     private String nombre;
     private int maxDaño;
     private int minDaño;

    public Arma(String nombre, int maxDaño, int minDaño) {
        this.nombre = nombre;
        this.maxDaño = maxDaño;
        this.minDaño = minDaño;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int causarDaño(){
        Random rand = new Random();
        return rand.nextInt((maxDaño - minDaño) + 1) + minDaño;
    }  
}
    class Personaje {
        
        private String nombre;
        private int puntosDeVida;
        private Arma arma;

        public Personaje(String nombre, int puntosDeVida, Arma arma) {
            this.nombre = nombre;
            this.puntosDeVida = 100;
            this.arma = arma;
        }
        
        public void atacar(Personaje oponente) {
            int daño = arma.causarDaño();
            oponente.recibirDaño(daño);
            System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + daño + "puntos de dano");
        }

        public void recibirDaño(int daño){
            this.puntosDeVida -= daño;
            if (this.puntosDeVida < 0) {
                this.puntosDeVida = 0;
            }
        }
          
        
        public boolean estaVivo(){
            return this.puntosDeVida > 0;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPuntosDeVida() {
            return puntosDeVida;
        }

        public Arma getArma() {
            return arma;
        }

        class Minecraft {

            private Personaje jugador1;
            private Personaje jugador2;

            public Minecraft(Personaje jugador1, Personaje jugador2) {
                jugador1 = jugador1;
                jugador2 = jugador2;
            }
            public void iniciarPelea() {
                System.out.println("La pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "...");
        
                while (jugador1.estaVivo() && jugador2.estaVivo()) {
                    turno(jugador1, jugador2);
                    if (jugador2.estaVivo()) {
                        turno(jugador2, jugador1);
                    }
                }
        
                if (jugador1.estaVivo()) {
                    System.out.println(jugador1.getNombre() + " ha ganado la pelea.");
                } else {
                    System.out.println(jugador2.getNombre() + " ha ganado la pelea.");
                }
            }
            private void turno(Personaje atacante, Personaje defensor) {
                System.out.println("Turno de " + atacante.getNombre() + " (arma: " + atacante.getArma().getNombre() + "). Puntos de vida de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
                atacante.atacar(defensor);
                System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.");
            }
        

            
         
        }
        
    }
        
        
    


        

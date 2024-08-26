package Classobjetos;

public class Marcado {

    private String nombre;
    private String color;
    private double diametro;
    private boolean esborrable;

    public Marcado (String nombre,String color, double diametro, boolean esborrable ) {
        this.nombre = nombre;
        this.color = color;
        this.diametro = diametro;
        this.esborrable = esborrable;
    }
    public void rayar(){
        System.out.println("Marcador rayando");

    }
    public String recargar(double cantidad){
        return "El marcado se recargo con " + cantidad + "ml";

    }
    public String toString(){
        return"{Marcador : Nombre: "+ nombre + "Color: "+ color + "Diametro: "+ diametro + "esBorrable: "+esborrable+"}";
    }
    
}

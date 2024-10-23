import java.util.ArrayList;
import java.util.List;

public class Impresion extends Producto {
    private String color;
    private ArrayList<Foto> fotos;

    public Impresion(int numero, String color, List<Foto> fotos) {
        super(numero);
        this.color = color;
        this.fotos = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

    @Override
    public String toString() {
        return "Impresion [color=" + color + ", fotos=" + fotos + "]";
    }


    
}
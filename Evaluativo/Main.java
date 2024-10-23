import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    ArrayList<Pedido> pedidos = new ArrayList<>();

    Cliente cliente1 = new Cliente("1213234324", "James Rodriguez");
    
    Foto foto1 = new Foto("Foto1.jpg");
    Foto foto2 = new Foto("Foto2.jpg");

    List<Foto> fotos = new ArrayList<>();
    fotos.add(foto1);
    fotos.add(foto2);

    Producto impresion = new Impresion(1, "Negro y Blanco", fotos);
    

    Producto camaras1 = new Camara(101, "Sony", "X90");
  
  
    List<Producto> productos1 = new ArrayList<>();
    productos1.add(impresion);
    productos1.add(camaras1);
    
    Pedido pedido = new Pedido(cliente1, (ArrayList<Producto>)productos1, new Date() , 1213234324 );
    
    System.out.println(" Cliente: "+ pedido.getCliente().getNombre());
    System.out.println(" Cedula: "+ pedido.getCliente().getCedula());

    System.out.println(" -Productos: ");
    for(Producto producto : pedido.getProductos()) {
      if(producto instanceof Impresion){
        Impresion imp = (Impresion) producto;
        System.out.println(" Impresion (numero: "+ imp.getNumero() + " color: "+ imp.getColor() + ")");
        } else if (producto instanceof Camara){
          Camara cam = (Camara) producto;
          System.out.println(" Camara : Numero = "+ cam.getNumero() + " Marca: "+ cam.getMarca() + "Modelo: "+ cam.getModelo());
        }
      }
      for (Foto foto : fotos){
        System.out.println(foto);
    }
}
}

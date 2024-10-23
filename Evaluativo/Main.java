import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    ArrayList<Pedido> pedidos = new ArrayList<>();

    Cliente cliente1 = new Cliente("1213234324", "James Rodriguez");
    Cliente cliente2 = new Cliente("1123332323", "Jhon Duran");
    Cliente cliente3 = new Cliente("2123123233", "Luiz Diaz");
    
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
    //pedidos.add(new Pedido(cliente1, new Date(), 1213234324, camarasCliente1));
    //pedidos.add(new Pedido(cliente2, new Date(), 1123332323, camarasCliente2));
    //pedidos.add(new Pedido(cliente3, new Date(), 2123123233, camarasCliente3));

    //for (Pedido pedido : pedidos) {
      // Crear una impresión con fotos
      //Impresion impresion = crearImpresion(pedidos.indexOf(pedido) + 101, "Negro y Blanco");
      //agregarFoto(impresion, "foto1.jpg");
      //agregarFoto(impresion, "foto2.jpg");
      //agregarProducto(pedido, impresion);
    //}

    //for (Pedido pedido : pedidos) {
      //mostrarPedido(pedido);
    //}
  //}



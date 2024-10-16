import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    ArrayList<Pedido> pedidos = new ArrayList<>();

    Cliente cliente1 = crearCliente("1213234324", "James Rodriguez");
    Cliente cliente2 = crearCliente("1123332323", "Juan Pérez");
    Cliente cliente3 = crearCliente("2123123233", "María López");

    List<Camara> camarasCliente1 = new ArrayList<>();

    camarasCliente1.add(crearCamara(102, "Logitech", "502"));

    List<Camara> camarasCliente2 = new ArrayList<>();
    camarasCliente2.add(crearCamara(103, "Canon", "D50"));

    List<Camara> camarasCliente3 = new ArrayList<>();
    camarasCliente3.add(crearCamara(104, "Nikon", "Z5"));

    pedidos.add(new Pedido(cliente1, new Date(), 1213234324, camarasCliente1));
    pedidos.add(new Pedido(cliente2, new Date(), 1123332323, camarasCliente2));
    pedidos.add(new Pedido(cliente3, new Date(), 2123123233, camarasCliente3));

    for (Pedido pedido : pedidos) {
      // Crear una impresión con fotos
      Impresion impresion = crearImpresion(pedidos.indexOf(pedido) + 101, "Color");
      agregarFoto(impresion, "foto1.jpg");
      agregarFoto(impresion, "foto2.jpg");
      agregarProducto(pedido, impresion);
    }

    for (Pedido pedido : pedidos) {
      mostrarPedido(pedido);
    }
  }

  public static Cliente crearCliente(String cedula, String nombre) {
    Cliente Cliente = new Cliente(cedula, nombre);
    return Cliente;
  }

  public static Impresion crearImpresion(int numero, String color) {
    Impresion impresion = new Impresion(numero, color);
    return impresion;
  }

  public static Camara crearCamara(int numero, String marca, String modelo) {
    Camara camara = new Camara(numero, marca, modelo);
    return camara;
  }

  public static void agregarProducto(Pedido pedido, Producto producto) {
    pedido.addProducto(producto);

  }

  public static void agregarFoto(Impresion impresion, String fichero) {
    Foto foto = new Foto(fichero);
    impresion.addFoto(foto);

  }

  public static void mostrarPedido(Pedido pedido) {
    System.out.println("\nMostrar el Pedido:");
    System.out.println("Cliente: " + pedido.getCliente().getNombre());
    System.out.println("Fecha: " + pedido.getFecha());
    System.out.println("Número de tarjeta de crédito: " + pedido.getNumeroTarjetaCredito());
    System.out.println("Productos en el pedido:");

    for (Camara camara : pedido.getCamaras()) {
      System.out.println("- Marca: " + camara.getMarca() + ", Modelo: " + camara.getModelo());
    }
    for (Producto producto : pedido.getProductos()) {
      if (producto instanceof Impresion) {
        Impresion impresion = (Impresion) producto;
        System.out.println("- Impresión (Número: " + impresion.getNumero() + ", Color: " + impresion.getColor() + ")");
        for (Foto foto : impresion.getFotos()) {
          System.out.println("   Foto: " + foto);
        }

      }
    }
  }
}

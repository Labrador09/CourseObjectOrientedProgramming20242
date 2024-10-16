public class Ejercicio3 {
    
    public static void main(String[] args) {
      TiendaVirtual  producto1 = new TiendaVirtual (" Sneakers Nike ", "535341233", 20, 250);
      TiendaVirtual  producto2 = new TiendaVirtual (" Sneakers Adidas ", "664342323", 14, 120); 
      TiendaVirtual  producto3 = new TiendaVirtual (" Sneakers New balance ", "4345345325", 26,150);
      
       producto1.calcularValorInventario();
       producto2.calcularValorInventario();
       producto3.calcularValorInventario();

      producto1.anañadirStock(20);
    
      producto1.calcularValorInventario();

      int totali = producto1.valorTotal() + producto2.valorTotal() + producto3.valorTotal();
      System.out.println("El valor del inventario es: "+ totali);
    }
}



public class TiendaVirtual {
    
    private String producto;
    private String codigo;
    private int stock;
    private int precio;
    private double precio1;

    public TiendaVirtual (String producto, String codigo, int stock, double precio){
        this.producto = producto;
        this.codigo = codigo;
        this.stock = stock;
        this.precio = (int) precio;
    }
      

    public void anañadirStock(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
            System.out.println("Se han añadido al  invetario: "+ stock + ""+producto);
            
        } else {
            System.out.println("La cantidad debe ser mayo que cero");
        }
    }
        public void reducirStock(int cantidad) {
            if (cantidad > 0) {
                stock -= cantidad;
                System.out.println("Se han reducido el invetario: "+ stock + ""+producto);
                
            } else {
                System.out.println("La cantidad debe ser mayo que cero");
            }
    }
        public void calcularValorInventario() {
             precio1 = this.stock * this.precio;
            System.out.println("El precio es: "+ precio1);
        }
        public int valorTotal() {
            int total = stock * precio;
            return total;
        }
}

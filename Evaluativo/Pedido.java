
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private Date fecha;
    private int numeroTargetaCredito;
    private List<Camara> camaras;

    public Pedido(Cliente cliente, Date fecha, int numeroTargetaCredito, List<Camara> camaras) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.numeroTargetaCredito = numeroTargetaCredito;
        this.productos = new ArrayList<>();
        this.camaras = camaras;
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public List<Camara> getCamaras() {
        return camaras;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroTarjetaCredito() {
        return numeroTargetaCredito;
    }

    public void setNumeroTarjetaCredito(int numeroTargetaCredito) {
        this.numeroTargetaCredito = numeroTargetaCredito;
    }

    public int getNumeroTargetaCredito() {
        return numeroTargetaCredito;
    }


    
    
    
}

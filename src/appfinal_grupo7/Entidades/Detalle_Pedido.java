package appfinal_grupo7.Entidades;

/**
 *
 * @author bruno
 */
public class Detalle_Pedido {
    
    private int id_detalle;
    private Producto producto;
    private int cantidad;

    public Detalle_Pedido() {
    }

    public Detalle_Pedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Detalle_Pedido(int id_detalle, Producto producto, int cantidad) {
        this.id_detalle = id_detalle;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        return "" + producto.getNombre() + cantidad + " unidades";
    }
}
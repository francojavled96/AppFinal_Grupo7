package appfinal_grupo7.Entidades;

/**
 *
 * @author Franquito Ledesma
 */
public class Producto {
    
    private int id_producto;
    private int nombre;
    private double precio_unitario;

    public Producto() {
    }

    public Producto(int nombre, double precio_unitario) {
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
    }

    public Producto(int id_producto, int nombre, double precio_unitario) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

        
    @Override
    public String toString(){
        return "" + nombre;
    }
}
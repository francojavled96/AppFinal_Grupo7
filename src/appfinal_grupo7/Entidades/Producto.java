package appfinal_grupo7.Entidades;
import java.util.Objects;


/**
 *
 * @author Franquito Ledesma
 */
public class Producto {
    
    private int id_producto;
    private String nombre;
    private double precio_unitario;

    public Producto() {
    }

    public Producto(String nombre, double precio_unitario) {
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
    }

    public Producto(int id_producto, String nombre, double precio_unitario) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Double.compare(producto.precio_unitario, precio_unitario) == 0 && Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio_unitario);
    }
}
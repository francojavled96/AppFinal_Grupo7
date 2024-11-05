package appfinal_grupo7.Entidades;

/**
 *
 * @author Franquito Ledesma
 */
public class Mesero {
    
    private int id_mesero;
    private String nombre;
    private String apellido;
    private boolean estado;

    public Mesero() {
    }

    public Mesero(String nombre, String apellido, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Mesero(int id_mesero, String nombre, String apellido, boolean estado) {
        this.id_mesero = id_mesero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public int getId_mesero() {
        return id_mesero;
    }

    public void setId_mesero(int id_mesero) {
        this.id_mesero = id_mesero;
    }

    public String getNombre_mesero() {
        return nombre;
    }

    public void setNombre_mesero(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_mesero() {
        return apellido;
    }

    public void setApellido_mesero(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return "" + id_mesero + " - " + nombre + apellido;
    }
}
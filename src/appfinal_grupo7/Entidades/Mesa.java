package appfinal_grupo7.Entidades;

/**
 *
 * @author Franquito Ledesma
 */
    public class Mesa {
    
    private int id_mesa;
    private int numero;
    private int capacidad;
    private int estado;

    public Mesa() {
    }

    public Mesa(int numero, int capacidad, int estado) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Mesa(int id_mesa, int numero, int capacidad, int estado) {
        this.id_mesa = id_mesa;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString(){
        return "Mesa n°: " + id_mesa;
    }
}
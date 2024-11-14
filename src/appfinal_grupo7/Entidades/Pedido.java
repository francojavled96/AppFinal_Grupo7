package appfinal_grupo7.Entidades;

import java.time.LocalDate;

/**
 *
 * @author Franquito Ledesma
 */
public class Pedido {
    
    private int id_pedido;
    private Mesa mesa;
    private Mesero mesero;
    private int estado; //según la consigna son 3 estados, evaluaría hacerlo con 2
    private LocalDate fecha;

    public Pedido() {
    }

    public Pedido(Mesa mesa, Mesero mesero, int estado, LocalDate fecha) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Pedido(int id_pedido, Mesa mesa, Mesero mesero, int estado, LocalDate fecha) {
        this.id_pedido = id_pedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString(){
        return "Pedido " + id_pedido;
    }    
}
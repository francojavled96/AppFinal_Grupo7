/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfinal_grupo7;

/**
 *
 * @author Franquito Ledesma
 */
public class Mesa {
    
 
    private int numero;
    private int capacidad;
    private Reserva reserva;

    public Mesa() {
    }
    
    

    public Mesa(int numero, int capacidad, Reserva reserva, boolean estado) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.reserva = reserva;
        this.estado = estado;
    }
    private boolean estado;

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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  numero + " " + capacidad + " " + reserva;
    }
    
    
    
}

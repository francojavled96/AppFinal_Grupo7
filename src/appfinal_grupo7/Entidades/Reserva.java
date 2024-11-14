package appfinal_grupo7.Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Franquito Ledesma
 */
public class Reserva {
    
    
    private int id_reserva;
    private Mesa mesa;    
    private String nombre_persona;
    private int dni;
    private LocalDate fecha;
    private LocalTime hora; /////////////////////*/*/*/*/*
    private boolean estado;

    public Reserva() {
    }

    public Reserva(Mesa mesa, String nombre_persona, int dni, LocalDate fecha, LocalTime hora, boolean estado) {
        this.mesa = mesa;
        this.nombre_persona = nombre_persona;
        this.dni = dni;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public Reserva(int id_reserva, Mesa mesa, String nombre_persona, int dni, LocalDate fecha, LocalTime hora, boolean estado) { /////////?
        this.id_reserva = id_reserva;
        this.mesa = mesa;
        this.nombre_persona = nombre_persona;
        this.dni = dni;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return "Reserva mesa " + mesa.getId_mesa() + " a nombre de " + nombre_persona;
    }
}
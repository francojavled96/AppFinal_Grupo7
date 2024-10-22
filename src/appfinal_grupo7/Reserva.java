/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfinal_grupo7;

import java.time.LocalDate;

/**
 *
 * @author Franquito Ledesma
 */
public class Reserva {
    
   
    private int idReserva;
    private int dni;
    private String nombre;
    private LocalDate fecha;
    private LocalDate hora;
    private boolean estado;

    public Reserva() {
    }

    public Reserva(int dni, String nombre, LocalDate fecha, LocalDate hora, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public Reserva(int idReserva, int dni, String nombre, LocalDate fecha, LocalDate hora, boolean estado) {
        this.idReserva = idReserva;
        this.dni = dni;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}

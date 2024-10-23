/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfinal_grupo7.Entidades;

/**
 *
 * @author Franquito Ledesma
 */
public class Producto {
    
    private int codigo;
    private int cantidad;
    private double precio;
    private String nombre;

    public Producto() {
    }

    public Producto(int codigo, int cantidad, double precio, String nombre) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  codigo + " " + cantidad + " " + precio + " " + nombre;
    }

    
    
    
}

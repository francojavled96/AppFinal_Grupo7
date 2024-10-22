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
public class Pedido {
    
   
    private int idPedido;
    private Producto producto;

    public Pedido() {
    }

    public Pedido(Producto producto) {
        this.producto = producto;
    }

    public Pedido(int idPedido, Producto producto) {
        this.idPedido = idPedido;
        this.producto = producto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}

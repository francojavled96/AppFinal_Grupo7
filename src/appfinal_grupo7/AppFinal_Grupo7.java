/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfinal_grupo7;

import appfinal_grupo7.AccesoADatos.Detalle_PedidoData;
import appfinal_grupo7.AccesoADatos.MesaData;
import appfinal_grupo7.AccesoADatos.MeseroData;
import appfinal_grupo7.AccesoADatos.PedidoData;
import appfinal_grupo7.Entidades.Detalle_Pedido;
import appfinal_grupo7.Entidades.Mesa;
import appfinal_grupo7.Entidades.Mesero;
import appfinal_grupo7.Entidades.Pedido;
import appfinal_grupo7.Entidades.Producto;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Franquito Ledesma
 */
public class AppFinal_Grupo7 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        Producto perro = new Producto("Perro", 5000.50);
        Mesa mesa = new Mesa(6, 1);       
        Mesero pepe = new Mesero(6,"Juan", "Perez", true); 
        Detalle_Pedido detallin = new Detalle_Pedido(perro, 7);
        
        MesaData mesa2 = new MesaData();
        mesa2.guardarMesa(mesa);
        
        MeseroData mesero2 = new MeseroData();
        mesero2.guardarMesero(pepe);
        
                
        Detalle_PedidoData detallin2 = new Detalle_PedidoData();
        detallin2.guardarDetalle(detallin);
        Pedido pedido1 = new Pedido(detallin, mesa, pepe, 1, LocalDate.EPOCH);
        PedidoData pedido2 = new PedidoData();
        pedido2.guardarPedido(pedido1);        
    }
}
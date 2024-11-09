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
import appfinal_grupo7.AccesoADatos.ProductoData;
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
        
        Producto p1 = new Producto("Producto1", 5.50);
        Producto p2 = new Producto("Producto2", 5.50);
        Producto p3 = new Producto("Producto3", 5.50);

        ProductoData prod = new ProductoData();
        prod.guardarProducto(p1);
        prod.guardarProducto(p2);
        prod.guardarProducto(p3);
        
        Mesa mesa = new Mesa(99, 10, 1);    
        MesaData mesa2 = new MesaData();
        mesa2.guardarMesa(mesa);
        //mesa2.eliimnarMesa(14);
        
        Mesero mozo = new Mesero(9,"Buen", "Mozo", true); 
        MeseroData mozaso = new MeseroData();
        mozaso.guardarMesero(mozo); 
        //mesero2.eliminarMesero(6);
        
        Detalle_Pedido detalle1 = new Detalle_Pedido(p1, 7);
        Detalle_Pedido detalle2 = new Detalle_Pedido(p2, 5);
        Detalle_Pedido detalle3 = new Detalle_Pedido(p3, 1);
        Detalle_PedidoData detallaso = new Detalle_PedidoData();
        detallaso.guardarDetalle(detalle1);
        detallaso.guardarDetalle(detalle2);
        detallaso.guardarDetalle(detalle3);
        detallaso.listarDetalle();

        
        Pedido pedido1 = new Pedido(detalle1, mesa, mozo, 1, LocalDate.EPOCH);
        Pedido pedido2 = new Pedido(detalle2, mesa, mozo, 1, LocalDate.EPOCH);
        Pedido pedido3 = new Pedido(detalle3, mesa, mozo, 1, LocalDate.EPOCH);
        PedidoData pedidaso = new PedidoData();
        pedidaso.guardarPedido(pedido1);
        pedidaso.guardarPedido(pedido2);
        pedidaso.guardarPedido(pedido3);
        
    }
}
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
        
        
        
        //Creo 3 productos
        Producto p1 = new Producto("Producto1", 5.50);
        Producto p2 = new Producto("Producto2", 5.50);
        Producto p3 = new Producto("Producto3", 5.50);

        //Guardo en BD
        ProductoData prod = new ProductoData();
        prod.guardarProducto(p1);
        prod.guardarProducto(p2);
        prod.guardarProducto(p3);
        
        //Creo 1 mesa y la guardo en BD
        Mesa mesa = new Mesa(99, 10, true);    
        MesaData mesa2 = new MesaData();
        mesa2.guardarMesa(mesa);
        //mesa2.eliimnarMesa(14);
        
        //Creo 1 mesero y lo guardo en BD
        Mesero mozo = new Mesero(9,"Buen", "Mozo", true); 
        MeseroData mozaso = new MeseroData();
        mozaso.guardarMesero(mozo); 
        //mesero2.eliminarMesero(6);
        
        //Creo 1 pedido, le asigno su mesa y mesero
      //  Pedido pedido1 = new Pedido(mesa, mozo, 0, LocalDate.EPOCH);
//        PedidoData pedidaso = new PedidoData();
//        pedidaso.guardarPedido(pedido1);
//        
//        //Creo 3 detalles, le asigno su pedido y los guardo en la BD
//        Detalle_Pedido detalle1 = new Detalle_Pedido(p1, pedido1, 7);
//        Detalle_Pedido detalle2 = new Detalle_Pedido(p2, pedido1, 5);
//        Detalle_Pedido detalle3 = new Detalle_Pedido(p3, pedido1, 1);
//        Detalle_PedidoData detallaso = new Detalle_PedidoData();
//        detallaso.guardarDetalle(detalle1);
//        detallaso.guardarDetalle(detalle2);
//        detallaso.guardarDetalle(detalle3);
//        detallaso.listarDetalle();   
//
//        
//        //System.out.println(detalle1.buscarDetallePorID(24));
//        //Obtengo un array con el detalle
//        System.out.println(detallaso.buscarDetallePorPedido(pedido1.getId_pedido()));
//        
//        //Calculo el total del detalle
//        System.out.println(detallaso.calcularTotalDetalle(pedido1.getId_pedido()));
//        
//        //Hago que el mozo cobre, devuelve el monto y cambia los estados de mesa y mozo para ese pedido
//        mozaso.cobrarPedido(pedido1.getId_pedido());
    }
}
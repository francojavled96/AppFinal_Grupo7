package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Mesa;
import appfinal_grupo7.Entidades.Mesero;
import appfinal_grupo7.Entidades.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author litob
 */
public class PedidoData {     
    
    private Connection con = null;
    private MesaData mesa = new MesaData();
    private MeseroData mesero = new MeseroData();
        
    public PedidoData() {
    con = Conexion.getConexion();
    }    
    
    public void guardarPedido(Pedido pedido){
        
        String sql = "INSERT INTO pedido (id_mesa, id_mesero, estado, fecha)"
                + "VALUES(?, ?, ?, ?)";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getMesa().getId_mesa());
            ps.setInt(2, pedido.getMesero().getId_mesero());
            ps.setInt(3, pedido.getEstado());    
            ps.setDate(4, java.sql.Date.valueOf(pedido.getFecha()));
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedido.setId_pedido(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pedido guardado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido");
        }        
    }
    
    public void modificarPedido(Pedido pedido){
        
        String sql = "UPDATE pedido SET id_mesa = ?, id_mesero = ?, estado = ?, fecha = ? WHERE id_pedido = ?";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa().getId_mesa());
            ps.setInt(2, pedido.getMesero().getId_mesero());
            ps.setInt(3, pedido.getEstado());
            ps.setDate(4, Date.valueOf(pedido.getFecha()));
            ps.setInt(5, pedido.getId_pedido());
            int actualizado = ps.executeUpdate();
                       
            
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Detalle modificado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido");
        }        
    }
    
    //lo elimina de la BD (no lógico)
    public void eliminarPedido(int id){        
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";         
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int eliminado = ps.executeUpdate();
            
            if (eliminado == 1) {
               JOptionPane.showMessageDialog(null, "Pedido eliminado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido");
        }        
    }
    
    public Pedido buscarPedidoPorID(int id){
        String sql = "SELECT id_mesa, id_mesero, estado FROM pedido WHERE id_pedido = ?";
        Pedido pedido = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                pedido=new Pedido();
                pedido.setId_pedido(id);
                Mesa mesa1 = mesa.buscarMesaPorID(rs.getInt("id_mesa"));
                Mesero mesero1 = mesero.buscarMeseroPorID(rs.getInt("id_mesero"));
                pedido.setEstado(rs.getInt("estado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe el pedido indicado (pedido por id)");
            }                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla pedido");
        }
       return pedido;
    }
    
    public List<Pedido> ListarPedidosPorFecha(LocalDate fecha) {
    String sql = "SELECT id_pedido FROM pedido WHERE DATE(fecha) = ?";
    List<Pedido> pedidos = new ArrayList<>();
    
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));  // Convertir LocalDate a java.sql.Date
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedidos.add(pedido);
            }        
            if (pedidos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No existen pedidos para la fecha indicada.");
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de pedidos: " + ex.getMessage());
        }    
    return pedidos;
    }
    
    public int obtenerMesa(int id){
        String sql = "SELECT id_mesa FROM pedido WHERE id_pedido = ?";
        int id_mesa = -1;
        Pedido pedido = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                id_mesa = rs.getInt("id_mesa");
            }else{
                JOptionPane.showMessageDialog(null, "No existe el pedido indicado (mesa)");
            }                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla pedido");
        }
        return id_mesa;
    } 
    
    public int obtenerMesero(int id){
        String sql = "SELECT id_mesero FROM pedido WHERE id_pedido = ?";
        int id_mesero = -1;
        Pedido pedido = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                id_mesero = rs.getInt("id_mesero");
            }else{
                JOptionPane.showMessageDialog(null, "No existe el pedido indicado (mesero)");
            }                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla pedido");
        }
        return id_mesero;
    }    
    
    public void liberarPedido(int id){        
        String sql = "UPDATE pedido SET estado = 0 WHERE id_pedido = ?";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizado = ps.executeUpdate();                       
            
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Estado del pedido modificado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido");
        }        
    }
    
    //obtener la ganancia de todo un día NO ME FUNCIONA
    public double gananciaTotalPorFecha(LocalDate fecha) {
    double total = 0;
    String sql = "SELECT SUM(dp.cantidad * pr.precio_unitario) AS total FROM pedido p"
            + "INNER JOIN detalle_pedido dp ON p.id_pedido = dp.id_pedido "
            + "INNER JOIN producto pr ON dp.id_producto = pr.id_producto"
            + "WHERE DATE (p.fecha) = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(fecha)); //LocalDate a java.sql.Date
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al calcular la ganancia: " + ex.getMessage());
        }    
    return total;
    }
    
    public List <Pedido> buscarPedidoPorFecha(LocalDate fecha){
        ArrayList<Pedido> lista = new ArrayList<>();
        String sql = "SELECT id_pedido, id_mesa ,id_mesero FROM pedido WHERE fecha = ?";
        Pedido pedido = null;
        MesaData mesadata;
        MeseroData meserodata;
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                pedido=new Pedido();
                mesadata = new MesaData();
                meserodata = new MeseroData();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                Mesa mesa = mesadata.buscarMesaPorID(rs.getInt("id_mesa"));
                Mesero mesero = meserodata.buscarMeseroPorID(rs.getInt("id_mesero"));
                pedido.setMesa(mesa);
                pedido.setMesero(mesero);
                
                lista.add(pedido);
            }              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a a la tabla detalle_pedido");
        }
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontró detalle para el pedido proporcionado");
        }
        return lista;
    }    
    
    public double calcularTotalPorFecha(LocalDate fecha) {
        double total_fecha = 0.0;
        Detalle_PedidoData deta = new Detalle_PedidoData();

        List<Pedido> pedidos = buscarPedidoPorFecha(fecha);  

        for (Pedido pedido : pedidos) {
            total_fecha += deta.calcularTotalDetalle(pedido.getId_pedido());
        }    

        return total_fecha;
}  
    
}
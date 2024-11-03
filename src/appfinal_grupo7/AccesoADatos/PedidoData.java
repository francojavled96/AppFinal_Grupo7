package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author litob
 */
public class PedidoData {     
    
    private Connection con = null;
        
    public PedidoData() {
    con = Conexion.getConexion();
    }    
    
    public void guardarPedido(Pedido pedido){
        
        String sql = "INSERT INTO pedido (id_detalle, id_mesa, id_mesero, estado)"
                + "VALUES(?, ?, ?, ?)";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getDetalle_pedido().getId_detalle());
            ps.setInt(2, pedido.getMesa().getId_mesa());
            ps.setInt(3, pedido.getMesero().getId_mesero());
            ps.setInt(4, pedido.getEstado());            
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
        
        String sql = "UPDATE pedido SET id_detalle = ?, id_mesa = ?, id_mesero = ?, estado = ?, fecha = ? WHERE id_mesa = ?";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getDetalle_pedido().getId_detalle());
            ps.setInt(2, pedido.getMesa().getId_mesa());
            ps.setInt(3, pedido.getMesero().getId_mesero());
            ps.setInt(4, pedido.getEstado());
            ps.setDate(5, Date.valueOf(pedido.getFecha()));
            ps.setInt(6, pedido.getId_pedido());
            int actualizado = ps.executeUpdate();
                       
            
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Detalle modificado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido");
        }        
    }
    
    public void eliminarPedido(int id){
        
        String sql = "UPDATE pedido SET estado = 0 WHERE id_pedido = ?"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Pedido eliminado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido");
        }        
    }
}
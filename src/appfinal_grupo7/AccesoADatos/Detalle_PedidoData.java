package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Detalle_Pedido;
import appfinal_grupo7.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Detalle_PedidoData {
    
    private Connection con = null;
    private Map<Producto, Integer> pedido;

    public Detalle_PedidoData() {        
        con = Conexion.getConexion();
        this.pedido = new HashMap<>();
    }
    
    public void guardarDetalle(Detalle_Pedido detalle){
        
        String sql = "INSERT INTO detalle_pedido (id_producto, cantidad)"
                + "VALUES(?, ?)";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle.getProducto().getId_producto());
            ps.setInt(2, detalle.getCantidad());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detalle.setId_detalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle guardado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido");
        }        
    }
    
    public void modificarDetalle(Detalle_Pedido detalle){
        
        String sql = "UPDATE detalle_pedido SET cantidad = ? WHERE id_detalle = ?";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getCantidad());
            ps.setInt(2, detalle.getId_detalle());
            int actualizado = ps.executeUpdate();
                       
            
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Detalle modificado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido");
        }        
    }
    
    public void eliminarDetalle(int id){
        
        String sql = "UPDATE detalle_pedido SET estado = 0 WHERE id_detalle = ?"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Detalle eliminado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido");
        }        
    }
}
package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Pedido;
import java.sql.Connection;
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
        
        String sql = "INSERT INTO detalle_pedido ( id_detalle, id_mesa, id_mesero, estado)"
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detalle pedido");
        }        
    }
    
}

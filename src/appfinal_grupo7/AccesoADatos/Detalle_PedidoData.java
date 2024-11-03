/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Detalle_Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Detalle_PedidoData {
    
    private Connection con = null;

    public Detalle_PedidoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarDetalle(Detalle_PedidoData detalle){
        
        String sql = "INSERT INTO detalle_pedido (id_detalle, id_producto, cantidad)"
                + "VALUES(?, ?, ?)";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle.);
            ps.setString(2, detalle.getNombre_mesero());
            ps.setString(3, detalle.getApellido_mesero());
            ps.setBoolean(4, detalle.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detalle.setId_detalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Mesero guardado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesero");
        }        
    }
    
    public void modificarMesero(Mesero detalle){
        
        String sql = "UPDATE mesero set nombre = ?, apellido = ? WHERE id_Mesero = ?";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mesero.getNombre_mesero());
            ps.setString(2, mesero.getApellido_mesero());
            ps.setInt(3, mesero.getId_mesero());
            int actualizado = ps.executeUpdate();
                       
            
            if (actualizado == 1) {
                JOptionPane.showMessageDialog(null, "Mesero modificado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesero");
        }        
    }
    
}

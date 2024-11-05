package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Mesero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author litob
 */
public class MeseroData {
    
    
    private Connection con = null;

    public MeseroData() {
        con = Conexion.getConexion();
    }
    
    public void guardarMesero(Mesero mesero){
        
        String sql = "INSERT INTO mesero (id_mesero, nombre, apellido, estado)"
                + "VALUES(?, ?, ?, ?)";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesero.getId_mesero());
            ps.setString(2, mesero.getNombre_mesero());
            ps.setString(3, mesero.getApellido_mesero());
            ps.setBoolean(4, mesero.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mesero.setId_mesero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Mesero guardado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesero");
        }        
    }
    
    public void modificarMesero(Mesero mesero){
        
        String sql = "UPDATE mesero SET nombre = ?, apellido = ? WHERE id_Mesero = ?";   
        
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
    
    public void eliminarMesero(int id){
        
        String sql = "UPDATE mesero SET estado = 0 WHERE id_Mesero = ?"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Mesero dado de baja");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesero");
        }        
    }
    
    public void atenderMesa(){
        //Le cambia el estado a la mesa a ocupada y crea el pedido
        //Ver si 1 mesa le cambia el estado al meser, yo haría que atienda hasta 2 mesas
    }
    
    public void cobrarMesa() {
        //Le cambia el estado a la mesa a libre y cobra el pedido  
        //Le cambia el estado al mesero a libre
    }
    
    public void crearReserva(){
        //Crea una reserva
        //Le cambia el estado a la Mesa a ocupado
    }
    
    public void cancelarReserva(){
        //Elimina una reserva   
        //Le cambia el estado a la mesa a libre
    }
    
    public void verGanancias(){
        //Ve la suma de las ganancias filtrando por fecha
        //Posiblemente llame métodos de la Clase "PedidoData"
    }
}
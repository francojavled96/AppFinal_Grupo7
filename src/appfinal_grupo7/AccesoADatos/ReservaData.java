
package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Mesero;
import appfinal_grupo7.Entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ReservaData {
    
  private Connection con = null;  
  
  
  public ReservaData() {
        con = Conexion.getConexion();
    }
    
  public void guardarReserva(Reserva reserva){
        
        String sql = "INSERT INTO reserva ( id_mesa, nombre_persona,dni,fecha,estado)"
                + "VALUES(?, ?, ?,?,?)";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
     
            ps.setInt(1,reserva.getMesa().getId_mesa());
            ps.setString(2, reserva.getNombre_persona());
            ps.setInt(3, reserva.getDni());
            ps.setDate(4,Date.valueOf(reserva.getFecha()));
            ps.setBoolean(5, reserva.isEstado());
            
             ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                reserva.setId_reserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "reservado ");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva");
        }        
    }
  
  public void ActualizaReserva(int id_reserva) {
    String sql= "UPDATE reserva SET estado= 0 WHERE id_reserva= ? ";
         try{ 
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, id_reserva);
             int exito=ps.executeUpdate();
             
             if(exito==1){
                 JOptionPane.showMessageDialog(null, "reserva modificada");
             }
         }catch (SQLException ex){
         JOptionPane.showMessageDialog(null,"Error al acceder a la tabla reserva");
     }
 }
  
   public void borrarInscripcion(int id_reserva, int id_mesa){
        
        String sql="DELETE FROM reserva WHERE id_reservao =? AND id_mesa =?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id_reserva);
            ps.setInt(2, id_mesa);
            
            int filas=ps.executeUpdate();
            if (filas>0){
                
                JOptionPane.showMessageDialog(null,"reserva eliminada");
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla reserva");
        }
    }
  
  
  
}

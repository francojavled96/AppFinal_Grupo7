
package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Mesa;
import appfinal_grupo7.Entidades.Mesero;
import appfinal_grupo7.Entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ReservaData {
    
  private Connection con = null;  
  MesaData mesaData;
  
  
  public ReservaData() {
        con = Conexion.getConexion();
         mesaData = new MesaData();
    }
    
  public void guardarReserva(Reserva reserva){
        
        String sql = "INSERT INTO reserva ( id_mesa, nombre_persona,dni,fecha,hora,estado)"
                + "VALUES(?, ?, ?,?,?,?)";   
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
     
            ps.setInt(1,reserva.getMesa().getId_mesa());
            ps.setString(2, reserva.getNombre_persona());
            ps.setInt(3, reserva.getDni());
            ps.setDate(4,Date.valueOf(reserva.getFecha()));
            //hora
            java.sql.Time tiempoSql = java.sql.Time.valueOf(reserva.getHora());
            ps.setTime(5,tiempoSql);
            
            ps.setBoolean(6, reserva.isEstado());
            
             ps.executeUpdate();
             
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                reserva.setId_reserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Reserva cargada con éxito ");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva");
        }        
    }
  
  public void ActualizaReserva(int id_reserva) {
    String sql= "UPDATE reserva SET estado = 0 WHERE id_reserva = ?";
         try{ 
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, id_reserva);
             int exito=ps.executeUpdate();
             
             if(exito==1){
                 JOptionPane.showMessageDialog(null, "Reserva anulada con exito");
             }
         }catch (SQLException ex){
         JOptionPane.showMessageDialog(null,"Error al acceder a la tabla reserva");
     }
 }
  
   public void eliminarReserva(int id_reserva){
        
        String sql="DELETE FROM reserva WHERE id_reservao =?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id_reserva);
            
            
            int filas=ps.executeUpdate();
            if (filas>0){
                
                JOptionPane.showMessageDialog(null,"reserva eliminada");
                
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla reserva");
        }
    }
       public List <Reserva> listarTodasReservas(){ //LISTAR TODAS
        String sql ="SELECT * FROM reserva";
        ArrayList<Reserva> reservas = new ArrayList<>();
        
      try {
          PreparedStatement ps=con.prepareStatement(sql);
          ResultSet rs=ps.executeQuery();
          while(rs.next()){
          Reserva reserva = new Reserva();
          reserva.setId_reserva(rs.getInt("id_reserva"));
          int idMesa=rs.getInt("id_mesa"); /// msa
          Mesa mesa = mesaData.buscarMesaPorID(idMesa); //// mesa
          reserva.setMesa(mesa); /// mesa
          reserva.setNombre_persona(rs.getString("nombre_persona"));
          reserva.setDni(rs.getInt("dni"));
          //FECHA
          String datetimeString = rs.getString("fecha"); // Obtiene la fecha en formato de cadena
            LocalDate localDate = LocalDate.parse(datetimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            reserva.setFecha(localDate);          
          //HORA
          reserva.setHora(rs.getTime("hora").toLocalTime());
          
          reserva.setEstado(rs.getBoolean("estado"));
          
          reservas.add(reserva);
          
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
      }
        
      return reservas;
      
    }
  
    public List <Reserva> listarReservasActivas(){
        String sql ="SELECT * FROM reserva WHERE estado = 1";
                ArrayList<Reserva> reservas = new ArrayList<>();
        
      try {
          PreparedStatement ps=con.prepareStatement(sql);
          ResultSet rs=ps.executeQuery();
          while(rs.next()){
          Reserva reserva = new Reserva();
          reserva.setId_reserva(rs.getInt("id_reserva"));
          int idMesa=rs.getInt("id_mesa"); /// msa
          Mesa mesa = mesaData.buscarMesaPorID(idMesa); //// mesa
          reserva.setMesa(mesa); /// mesa
          reserva.setNombre_persona(rs.getString("nombre_persona"));
          reserva.setDni(rs.getInt("dni"));
          //FECHA
          String datetimeString = rs.getString("fecha"); // Obtiene la fecha en formato de cadena
            LocalDate localDate = LocalDate.parse(datetimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            reserva.setFecha(localDate);          
          //HORA
          reserva.setHora(rs.getTime("hora").toLocalTime());
          
          reserva.setEstado(rs.getBoolean("estado"));
          
          reservas.add(reserva);
          
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
      }
        
      return reservas;
      
    }
    public List <Reserva> listarReservasNoActivas(){
            String sql ="SELECT * FROM reserva WHERE estado = 0";
                ArrayList<Reserva> reservas = new ArrayList<>();
        
      try {
          PreparedStatement ps=con.prepareStatement(sql);
          ResultSet rs=ps.executeQuery();
          while(rs.next()){
          Reserva reserva = new Reserva();
          reserva.setId_reserva(rs.getInt("id_reserva"));
          int idMesa=rs.getInt("id_mesa"); /// msa
          Mesa mesa = mesaData.buscarMesaPorID(idMesa); //// mesa
          reserva.setMesa(mesa); /// mesa
          reserva.setNombre_persona(rs.getString("nombre_persona"));
          reserva.setDni(rs.getInt("dni"));
          //FECHA
          String datetimeString = rs.getString("fecha"); // Obtiene la fecha en formato de cadena
            LocalDate localDate = LocalDate.parse(datetimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            reserva.setFecha(localDate);          
          //HORA
          reserva.setHora(rs.getTime("hora").toLocalTime());
          
          reserva.setEstado(rs.getBoolean("estado"));
          
          reservas.add(reserva);
          
          }
          
      } catch (SQLException ex) {
          Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
      }
        
      return reservas;
    
    
    
    }
    
    public List<Reserva> listarReservasPorId(int id) {
    String sql = "SELECT * FROM reserva WHERE id_reserva = ? AND estado = 1";
    ArrayList<Reserva> reservas = new ArrayList<>();
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);  
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Reserva reserva = new Reserva();
            reserva.setId_reserva(rs.getInt("id_reserva"));
            
            int idMesa = rs.getInt("id_mesa");
            Mesa mesa = mesaData.buscarMesaPorID(idMesa);
            reserva.setMesa(mesa);
            
            reserva.setNombre_persona(rs.getString("nombre_persona"));
            reserva.setDni(rs.getInt("dni"));
            
            //uso localTime directamente
            reserva.setFecha(rs.getDate("fecha").toLocalDate());
            
            // uso localTime directamente
            reserva.setHora(rs.getTime("hora").toLocalTime());
            
            reserva.setEstado(rs.getBoolean("estado"));
            
            reservas.add(reserva);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return reservas;
    }
    
    public List<Reserva> listarReservasPorFecha(java.sql.Date fecha) {
    String sql = "SELECT * FROM reserva WHERE DATE(fecha) = ? AND estado = 1";
    ArrayList<Reserva> reservas = new ArrayList<>();
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, fecha);  
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Reserva reserva = new Reserva();
            reserva.setId_reserva(rs.getInt("id_reserva"));
            
            int idMesa = rs.getInt("id_mesa");
            Mesa mesa = mesaData.buscarMesaPorID(idMesa);
            reserva.setMesa(mesa);
            
            reserva.setNombre_persona(rs.getString("nombre_persona"));
            reserva.setDni(rs.getInt("dni"));
            
            // Fecha
           
            
            reserva.setFecha(rs.getDate("fecha").toLocalDate());;
            
            // Hora
            reserva.setHora(rs.getTime("hora").toLocalTime());
            
            reserva.setEstado(rs.getBoolean("estado"));
            
            reservas.add(reserva);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return reservas;
    }
}

package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Mesero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    public Mesero buscarMeseroPorID(int id){
    String sql = "SELECT nombre, apellido, estado FROM mesero WHERE id_mesero = ?";
    Mesero mesero = null;
    try {
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            mesero=new Mesero();
            mesero.setId_mesero(id);
            mesero.setNombre_mesero(rs.getString("nombre"));
            mesero.setApellido_mesero(rs.getString("apellido"));
            mesero.setEstado(true);
        }else{
            JOptionPane.showMessageDialog(null, "La mesa indicada no existe");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al accedera a la tabla mesa");
    }    
    return mesero;
    }
    
    public List<Mesero> listarMeserosLibres(){
        String sql = "SELECT id_mesero, nombre, apellido FROM mesero WHERE estado = 0";
        ArrayList<Mesero> meseros = new ArrayList<>();
        Mesero mesero;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                mesero=new Mesero();
                mesero.setId_mesero(rs.getInt("id_mesero"));
                mesero.setNombre_mesero(rs.getString("nombre"));
                mesero.setApellido_mesero(rs.getString("apellido"));
                mesero.setEstado(false);
                
                meseros.add(mesero);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a a la lista de meseros libres");
        }    
        return meseros;
    }
    
    public List<Mesero> listarMeserosOcupados(){
        String sql = "SELECT id_mesero, nombre, apellido FROM mesero WHERE estado = 1";
        ArrayList<Mesero> meseros = new ArrayList<>();
        Mesero mesero;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                mesero=new Mesero();
                mesero.setId_mesero(rs.getInt("id_mesero"));
                mesero.setNombre_mesero(rs.getString("nombre"));
                mesero.setApellido_mesero(rs.getString("apellido"));
                mesero.setEstado(true);
                
                meseros.add(mesero);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a a la lista de meseros libres");
        }    
        return meseros;
    }
    
    public List<Mesero> listarMeserosTodos(){
        String sql = "SELECT id_mesero, nombre, apellido, estado FROM mesero" ;
        ArrayList<Mesero> meseros = new ArrayList<>();
        Mesero mesero;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                mesero=new Mesero();
                mesero.setId_mesero(rs.getInt("id_mesero"));
                mesero.setNombre_mesero(rs.getString("nombre"));
                mesero.setApellido_mesero(rs.getString("apellido"));                
                
                meseros.add(mesero);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a a la lista de meseros libres");
        }    
        return meseros;
    }
    
    public void cambiarAOcupado(int id){
        
        String sql = "UPDATE mesero SET estado = 1 WHERE id_Mesero = ?"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Mesero ocupado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesero");
        }        
    }
    
    public void cambiarALibre(int id){
        
        String sql = "UPDATE mesero SET estado = 0 WHERE id_Mesero = ?"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Mesero liberado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesero");
        }        
    }    
    
    
    public void atenderMesa(){
        //Le cambia el estado a la mesa a ocupada y crea el pedido
        //Ver si 1 mesa le cambia el estado al meser, yo haría que atienda hasta 2 mesas
    }
    
    public double cobrarPedido(int id) {
        double total;
        int num_mesa;
        int num_mesero;
        
        MeseroData mesero = new MeseroData();
        PedidoData pedido = new PedidoData();
        Detalle_PedidoData detalle = new Detalle_PedidoData();
        MesaData mesa = new MesaData();
        
        total = detalle.calcularTotalDetalle(id); //guarda el total del pedido
        num_mesa = pedido.obtenerMesa(id);
        num_mesero = pedido.obtenerMesero(id);
        mesa.cambiarALibre(num_mesa); //cambia la mesa a libre
        mesero.cambiarALibre(num_mesero); //cambia mesero a libre  
        pedido.liberarPedido(id);
        
        return total;
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Mesa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author litob
 */
public class MesaData {
        
    private Connection con = null;
    public MesaData() {
    con = Conexion.getConexion();
    }

    public void guardarMesa(Mesa mesa){
         String sql = "INSERT INTO mesa(capacidad, numero, estado)"
            + "VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesa.getCapacidad());
            ps.setInt(2, mesa.getNumero());
            ps.setBoolean(3, mesa.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
            mesa.setId_mesa(rs.getInt(1));
            System.out.println("Carga de mesa realizada con exito");
            }
            ps.close();
        } catch (SQLException ex) {
             System.out.println("Error no se pudo cargar la mesa ");
        }
    }
    public void modificarMesa(Mesa mesa){
         String sql = "UPDATE mesa SET capacidad = ?, numero = ?, estado = ? WHERE id_mesa = ?";

         try {
            PreparedStatement ps = con.prepareStatement(sql);                          
            ps.setInt(1,mesa.getCapacidad());
            ps.setInt(2,mesa.getCapacidad());
            ps.setBoolean(3, mesa.isEstado());
            ps.setInt(4, mesa.getId_mesa());
            int exito = ps.executeUpdate();
            if(exito==1){
                System.out.println("Mesa actualizada ");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error no se pudo actualizar la mesa");
        }
    }

    public void eliminarMesa(int id_mesa){ //ELIMINACION LOGICA 
        String sql = "UPDATE mesa SET estado = 0 WHERE id_mesa = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id_mesa);
            int exito = ps.executeUpdate();
            if(exito ==1){
                System.out.println("Mesa eliminadoa ");
            }

        } catch (SQLException ex) {
            System.out.println( "Error al accedera a la tabla mesa");
        }        
    }
    
    public Mesa buscarMesaPorID(int id){
        String sql = "SELECT numero, capacidad, estado FROM mesa WHERE id_mesa = ?";
        Mesa mesa = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                mesa=new Mesa();
                mesa.setId_mesa(id);
                mesa.setNumero(rs.getInt("numero"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "La mesa indicada no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla mesa");
        }    
        return mesa;
    }
    
    public List<Mesa> listarMesasLibres(){
        String sql = "SELECT id_mesa, numero, capacidad FROM mesa WHERE estado = 0";
        ArrayList<Mesa> mesas = new ArrayList<>();
        Mesa mesa;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                mesa=new Mesa();
                mesa.setId_mesa(rs.getInt("id_mesa"));
                mesa.setNumero(rs.getInt("numero"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setEstado(false);
                
                mesas.add(mesa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a a la lista de mesas libres");
        }    
        return mesas;
    }

    public List<Mesa> listarMesasOcupadas(){
        String sql = "SELECT id_mesa, numero, capacidad FROM mesa WHERE estado = 1";
        ArrayList<Mesa> mesas = new ArrayList<>();
        Mesa mesa;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                mesa=new Mesa();
                mesa.setId_mesa(rs.getInt("id_mesa"));
                mesa.setNumero(rs.getInt("numero"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setEstado(true);                
                mesas.add(mesa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a a la lista de mesas ocupadas");
        }    
        return mesas;
    }
    
    public List<Mesa> listarMesasTodas(){
        String sql = "SELECT id_mesa, numero, capacidad, estado FROM mesa";
        ArrayList<Mesa> mesas = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Mesa mesa=new Mesa();
                mesa.setId_mesa(rs.getInt("id_mesa"));
                mesa.setNumero(rs.getInt("numero"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setEstado(true);
                
                mesas.add(mesa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a a la lista de mesas ocupadas");
        }    
        return mesas;
    }
    
    public void cambiarAOcupada(int id){
         String sql = "UPDATE mesa SET estado = 1 WHERE id_mesa = ?"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Mesa ocupada");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa");
        }        
    }
    
    public void cambiarALibre(int id){
         String sql = "UPDATE mesa SET estado = 0 WHERE id_mesa = ?"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Mesa liberada");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa");
        }        
    }
    public List<Mesa> listarMesasDisponiblesXFecha(java.sql.Date fecha) {
        String sql = "SELECT m.id_mesa, m.numero, m.capacidad "
                   + "FROM mesa m "
                   + "LEFT JOIN reserva r ON m.id_mesa = r.id_mesa AND r.fecha = ? "
                   + "WHERE m.estado = 0 AND r.id_mesa IS NULL";
        ArrayList<Mesa> mesas = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, fecha);  // Establecer la fecha en el PreparedStatement
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setId_mesa(rs.getInt("id_mesa"));
                mesa.setNumero(rs.getInt("numero"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setEstado(false);  // Si es necesario, ajusta esto
                mesas.add(mesa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la lista de mesas disponibles");
            ex.printStackTrace();  // Esto es útil para depuración
        }
        return mesas;
    }
}
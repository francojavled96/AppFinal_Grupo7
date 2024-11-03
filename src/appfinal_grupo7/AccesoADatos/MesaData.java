/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Mesa;
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
public class MesaData {
        
        private Connection con = null;
        public MesaData() {
        con = Conexion.getConexion();
        }
    
        public void guardarMesa(Mesa mesa){
             String sql = "INSERT INTO mesa(capacidad, estado)"
                + "VALUES (?,?)";
             
            try {
                PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, mesa.getCapacidad());
                ps.setInt(2, mesa.getEstado());
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
             String sql = "UPDATE mesa SET capacidad = ?, estado = ? WHERE id_mesa = ?";
            
             try {
                PreparedStatement ps = con.prepareStatement(sql);                          
                ps.setInt(1,mesa.getCapacidad());
                ps.setInt(2, mesa.getEstado());
                ps.setInt(3, mesa.getId_mesa());
                int exito = ps.executeUpdate();
                if(exito==1){
                    System.out.println("Mesa actualizada ");
                }
                ps.close();
            } catch (SQLException ex) {
                 System.out.println("Error no se pudo actualizar la mesa");
            }
    
    
        }
        
        public void eliimnarMesa(int id_mesa){ //ELIMINACION LOGICA 
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
        
        
        
        }
        
        
        


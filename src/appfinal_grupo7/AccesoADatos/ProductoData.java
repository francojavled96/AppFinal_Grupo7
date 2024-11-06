/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Producto;
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
public class ProductoData {
    private Connection con = null;
    public ProductoData() {
    con = Conexion.getConexion();
    }
    public void guardarProducto(Producto producto){
        String sql = "INSERT INTO producto (nombre, precio_unitario) VALUES (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, producto.getNombre());
             ps.setDouble(2, producto.getPrecio_unitario());
             ps.executeUpdate();
             ResultSet rs=ps.getGeneratedKeys();
             if (rs.next()) {
                producto.setId_producto(rs.getInt(1));
                System.out.println("Producto cargado correctamente");
                ps.close();
            }
            } catch (SQLException ex) {
            System.out.println("Error no se pudo guardar el producto");
              }
    }
    
    public void modificarProducto(Producto producto){
        String sql = "UPDATE producto SET nombre = ?, precio_unitario = ? WHERE id_producto = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,producto.getNombre());
            ps.setDouble(2, producto.getPrecio_unitario());
            ps.setInt(3, producto.getId_producto());
            ps.executeUpdate();
            System.out.println("Producto modificado correctamente");
            

             
            
        } catch (SQLException ex) {
            System.out.println("Error al modificar producto");
        }
   
    
    
    }
    
    public void eliminarProducto(int id_producto){ //eliminacion fisica
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
            int exito = ps.executeUpdate();
            if(exito ==1){
                System.out.println("Producto eliminado correctamente");
            }    
           } catch (SQLException ex) {
            System.out.println("Error al eliminar producto ");
        }
    
    }
//    public Producto buscarProductoPorId(int idProducto){
//    
//    }
}

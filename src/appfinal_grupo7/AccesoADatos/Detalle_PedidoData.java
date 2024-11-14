package appfinal_grupo7.AccesoADatos;

import appfinal_grupo7.Entidades.Detalle_Pedido;
import appfinal_grupo7.Entidades.Pedido;
import appfinal_grupo7.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Detalle_PedidoData {
    
    private Connection con = null;
    private PedidoData pedido = new PedidoData();
    private MesaData mesa = new MesaData();
    private MeseroData mesero = new MeseroData();
    private ProductoData producto = new ProductoData();

    public Detalle_PedidoData() {        
        con = Conexion.getConexion();
    }
    
    public void guardarDetalle(Detalle_Pedido detalle){        
        String sql = "INSERT INTO detalle_pedido (id_producto, id_pedido, cantidad)"
        + "VALUES(?, ?, ?)";  
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalle.getProducto().getId_producto());
            ps.setInt(2, detalle.getPedido().getId_pedido());
            ps.setInt(3, detalle.getCantidad());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detalle.setId_detalle(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle guardado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error no se puedo guardar detalle pedido");
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
            JOptionPane.showMessageDialog(null, "Error al modificar detalle pedido");
        }        
    }
    
    public void eliminarDetalle(int idDetalle){        
        String sql = "UPDATE detalle_pedido SET cantidad = 0 WHERE id_detalle = ?"; 
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDetalle);
            int actualizado = ps.executeUpdate();
            
            if (actualizado == 1) {
               JOptionPane.showMessageDialog(null, "Detalle eliminado");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar detalle pedido");
        }        
    }
    
    //Detalle por id
    public Detalle_Pedido buscarDetallePorID(int id){
        String sql = "SELECT id_producto, id_pedido ,cantidad FROM detalle_pedido WHERE id_detalle = ?";
        Detalle_Pedido detalle = null;
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                detalle=new Detalle_Pedido();
                detalle.setId_detalle(id);
                Producto prod = producto.buscarProductoPorID(rs.getInt("id_producto"));
                Pedido pe = pedido.buscarPedidoPorID(rs.getInt("id_pedido"));
                detalle.setProducto(prod);
                detalle.setPedido(pe);
                detalle.setCantidad(rs.getInt("cantidad"));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró detalle con el ID proporcionado");
            }                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla detalle_pedido");
        }
       return detalle;
    }
    
    //Lista todos los detalles
    public List <Detalle_Pedido> listarDetalle(){
        ArrayList<Detalle_Pedido> lista = new ArrayList<>();   
        Detalle_Pedido detalle;
        String sql = "SELECT * FROM detalle_pedido";
        
          try (
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery()) {
        {
            while(rs.next()){
                detalle = new Detalle_Pedido();
                detalle.setId_detalle(rs.getInt("id_producto"));
                Pedido pedi = pedido.buscarPedidoPorID(rs.getInt("id_pedido"));
                detalle.setCantidad(rs.getInt("cantidad"));
            lista.add(detalle);
            }
        }
    }   catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar el detalle del pedido");
        }
        return lista;
    }    
    
    //Lista de detalle que comparten un mismo pedido
    public List <Detalle_Pedido> buscarDetallePorPedido(int id){
        ArrayList<Detalle_Pedido> lista = new ArrayList<>();
        String sql = "SELECT id_detalle, id_producto ,cantidad FROM detalle_pedido WHERE id_pedido = ?";
        Detalle_Pedido detalle = null;
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                detalle=new Detalle_Pedido();
                detalle.setId_detalle(rs.getInt("id_detalle"));
                Producto prod = producto.buscarProductoPorID(rs.getInt("id_producto"));
                detalle.setProducto(prod);
                detalle.setCantidad(rs.getInt("cantidad"));
                
                lista.add(detalle);
            }              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a a la tabla detalle_pedido");
        }
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontró detalle para el pedido proporcionado");
        }
        return lista;
    }
    
    //elimino todos los detalles de ese pedido
    public void eliminarDetallesPorPedido(int id_pedido) {
    String sql = "DELETE FROM detalle_pedido WHERE id_pedido = ?";
    
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_pedido);
            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Se eliminaron " + filasEliminadas + " detalles del pedido con ID: " + id_pedido);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró detalle para el pedido proporcionado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar eliminar detalles de la tabla detalle_pedido");
        }
    }   
    
    //Suma total de todos los detalles para un mismo pedido
    public double calcularTotalDetalle(int id) {
    double total_pedido = 0.0;    
    List<Detalle_Pedido> detalles = buscarDetallePorPedido(id);  
    
    for (Detalle_Pedido detalle : detalles) {
        total_pedido += detalle.getProducto().getPrecio_unitario() * detalle.getCantidad();
    }    
    return total_pedido;
    }
}
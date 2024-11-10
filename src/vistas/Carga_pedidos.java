/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import appfinal_grupo7.AccesoADatos.Detalle_PedidoData;
import appfinal_grupo7.AccesoADatos.MesaData;
import appfinal_grupo7.AccesoADatos.MeseroData;
import appfinal_grupo7.AccesoADatos.PedidoData;
import appfinal_grupo7.AccesoADatos.ProductoData;
import appfinal_grupo7.Entidades.Detalle_Pedido;
import appfinal_grupo7.Entidades.Mesa;
import appfinal_grupo7.Entidades.Mesero;
import appfinal_grupo7.Entidades.Pedido;
import appfinal_grupo7.Entidades.Producto;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno
 */
public class Carga_pedidos extends javax.swing.JInternalFrame {
    private ArrayList<Mesa> lista_mesa;
    private ArrayList<Mesero> lista_mesero;
    private ArrayList<Producto> lista_producto;
    
    
    private MesaData mesa_data;
    private MeseroData mesero_data;
    private Detalle_PedidoData detalle_data; 
    private PedidoData pedi_data;
    private ProductoData produ_data;
    
    private DefaultTableModel modelo;

    /**
     * Creates new form Carga_pedidos
     */
    public Carga_pedidos() {
        initComponents();
        
        mesa_data = new MesaData();
        mesero_data = new MeseroData();
        pedi_data = new PedidoData();
        detalle_data = new Detalle_PedidoData();
        produ_data = new ProductoData();
        modelo = new DefaultTableModel();
        
        lista_mesa = (ArrayList<Mesa>) mesa_data.listarMesasLibres();
        lista_mesero = (ArrayList<Mesero>) mesero_data.listarMeserosLibres();
        
        cargarMesas();
        cargarMeseros();
        armarTabla();
        cargarTabla();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Cargarpedidos = new javax.swing.JLabel();
        jLabel_Pedido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Pedido = new javax.swing.JTable();
        jButton_Limpiar = new javax.swing.JButton();
        jButton_Cargar_detalle = new javax.swing.JButton();
        jLabel_Mesa = new javax.swing.JLabel();
        jComboBox_Mesa = new javax.swing.JComboBox<>();
        jLabel_Mesero = new javax.swing.JLabel();
        jComboBox_Mesero = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_CrearPedido = new javax.swing.JButton();
        jButton_Salir = new javax.swing.JButton();
        jTextField_PedidoNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel_Cargarpedidos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_Cargarpedidos.setText("Cargar pedidos");

        jLabel_Pedido.setText("Seleccione los productos y cantidades a cargar:");

        jTable_Pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Producto", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Pedido);

        jButton_Limpiar.setText("Limpiar");
        jButton_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LimpiarActionPerformed(evt);
            }
        });

        jButton_Cargar_detalle.setText("Cargar detalle");
        jButton_Cargar_detalle.setEnabled(false);
        jButton_Cargar_detalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cargar_detalleActionPerformed(evt);
            }
        });

        jLabel_Mesa.setText("Seleccione una mesa libre");

        jComboBox_Mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_MesaActionPerformed(evt);
            }
        });

        jLabel_Mesero.setText("Seleccione un mesero libre");

        jLabel1.setText("Seleccione una fecha:");

        jButton_CrearPedido.setText("Crear Pedido");
        jButton_CrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearPedidoActionPerformed(evt);
            }
        });

        jButton_Salir.setText("Salir");
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("El número de pedido es:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Cargarpedidos)
                .addGap(152, 152, 152))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Pedido)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel_Mesa)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel_Mesero))
                                .addGap(27, 27, 27)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_Mesero, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_CrearPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_PedidoNumero)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_Limpiar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Cargar_detalle)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel_Cargarpedidos)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Mesa)
                    .addComponent(jComboBox_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Mesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Mesero))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_PedidoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton_CrearPedido)
                .addGap(46, 46, 46)
                .addComponent(jLabel_Pedido)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Limpiar)
                    .addComponent(jButton_Cargar_detalle)
                    .addComponent(jButton_Salir))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Cargar_detalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cargar_detalleActionPerformed
        // TODO add your handling code here:
        Detalle_PedidoData detallaso = new Detalle_PedidoData();
        Pedido pedido;
        PedidoData pedidaso = new PedidoData();       
        Producto producto;
        ProductoData productaso = new ProductoData();
        int id =Integer.parseInt(jTextField_PedidoNumero.getText());         
        
        int rowCount = jTable_Pedido.getRowCount();

            // Recorrer todas las filas de la tabla
            for (int i = 0; i < rowCount; i++) {
                // Obtener el modelo de la tabla
                DefaultTableModel tableModel = (DefaultTableModel) jTable_Pedido.getModel();

                // Obtener los valores de las columnas de la fila actual
                int producto_id = (int) tableModel.getValueAt(i, 0);// Columna "ID"
                System.out.println(producto_id);
                double precio = (double) tableModel.getValueAt(i, 2);// Columna "Precio"
                System.out.println(precio);
                if (tableModel.getValueAt(i, 3) != null) {
                    int cantidad = Integer.parseInt(tableModel.getValueAt(i, 3).toString());// Columna "Cantidad"       
                    System.out.println(cantidad);
                    
                    producto = productaso.buscarProductoPorID(producto_id);
                    pedido = pedidaso.buscarPedidoPorID(id);

                    // Crear el objeto Detalle_Pedido con los valores obtenidos
                    Detalle_Pedido detalle= new Detalle_Pedido(producto, pedido, cantidad);
                    detallaso.guardarDetalle(detalle);
                    jButton_Cargar_detalle.setEnabled(false);
                    jButton_CrearPedido.setEnabled(true);                                        
                }
            }
        limpiarCampos();
    }//GEN-LAST:event_jButton_Cargar_detalleActionPerformed

    private void jButton_CrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearPedidoActionPerformed
        // TODO add your handling code here:
        Mesa mesa_selec = (Mesa) jComboBox_Mesa.getSelectedItem();
        Mesero mesero_secMesero = (Mesero) jComboBox_Mesero.getSelectedItem();
        //Date fecha = (Date) jDateChooser1.getDate();
        
        Pedido nuevo_pedido = new Pedido(mesa_selec, mesero_secMesero, 1, null);
        PedidoData registro_pedido = new PedidoData();
        registro_pedido.guardarPedido(nuevo_pedido);
        jTextField_PedidoNumero.setText(nuevo_pedido.getId_pedido()+"");
        jTextField_PedidoNumero.setEditable(false);
        jButton_CrearPedido.setEnabled(false);
        jButton_Cargar_detalle.setEnabled(true);     
        
        mesero_data.cambiarAOcupado(mesero_secMesero.getId_mesero());
        mesa_data.cambiarAOcupada(mesa_selec.getId_mesa());
        
        jComboBox_Mesa.removeAllItems();
        jComboBox_Mesero.removeAllItems();
        lista_mesa = (ArrayList<Mesa>) mesa_data.listarMesasLibres();
        lista_mesero = (ArrayList<Mesero>) mesero_data.listarMeserosLibres();
        cargarMesas();
        cargarMeseros();
    }//GEN-LAST:event_jButton_CrearPedidoActionPerformed

    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton_SalirActionPerformed

    private void jComboBox_MesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_MesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_MesaActionPerformed

    private void jButton_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LimpiarActionPerformed
        // TODO add your handling code here:
        modelo.setRowCount(0);
        cargarTabla();
    }//GEN-LAST:event_jButton_LimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cargar_detalle;
    private javax.swing.JButton jButton_CrearPedido;
    private javax.swing.JButton jButton_Limpiar;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JComboBox<Mesa> jComboBox_Mesa;
    private javax.swing.JComboBox<Mesero> jComboBox_Mesero;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Cargarpedidos;
    private javax.swing.JLabel jLabel_Mesa;
    private javax.swing.JLabel jLabel_Mesero;
    private javax.swing.JLabel jLabel_Pedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Pedido;
    private javax.swing.JTextField jTextField_PedidoNumero;
    // End of variables declaration//GEN-END:variables
    
    private void cargarMesas(){
        for (Mesa mesa : lista_mesa) {
            jComboBox_Mesa.addItem(mesa);            
        }
    }
    
    private void cargarMeseros(){
        for (Mesero mesero : lista_mesero) {
            jComboBox_Mesero.addItem(mesero);            
        }
    }
    
    private void armarTabla(){
        ArrayList<Object> cabecera = new ArrayList<>();
        cabecera.add("ID");
        cabecera.add("Producto");
        cabecera.add("Precio");
        cabecera.add("Cantidad");
        
        for (Object object : cabecera) {
            modelo.addColumn(object);
        }
        jTable_Pedido.setModel(modelo);
    }
    
    private void cargarTabla(){
        lista_producto = produ_data.listarProductos();
        
        for (Producto produ : lista_producto) {
            modelo.addRow(new Object[] {produ.getId_producto(), produ.getNombre(), produ.getPrecio_unitario()});
        }
    }
    
    private void limpiarCampos(){
        jTextField_PedidoNumero.setText("");
        modelo.setRowCount(0);
        cargarTabla();
    } 
}

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
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno
 */
public class Carga_pedidos extends javax.swing.JInternalFrame {
    private ArrayList<Mesa> lista_mesa;
    private ArrayList<Mesero> lista_mesero;
    private ArrayList<Producto> lista_producto;
    
    
    private Producto producto;
    private Mesa mesa;
    private Mesero mesero;
    private Detalle_Pedido detalle_pedido;
    private Pedido pedido;
    
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
        jButton_CrearPedido = new javax.swing.JButton();
        jButton_Salir = new javax.swing.JButton();
        jTextField_PedidoNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser_Fecha = new com.toedter.calendar.JDateChooser();
        jButton_TotalPorDia = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(350, 640));

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

        jDateChooser_Fecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser_FechaPropertyChange(evt);
            }
        });

        jButton_TotalPorDia.setText("Totaldía");
        jButton_TotalPorDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TotalPorDiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel_Pedido))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel_Cargarpedidos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_PedidoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_CrearPedido)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_Limpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Cargar_detalle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_TotalPorDia))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Mesa)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel_Mesero))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox_Mesa, 0, 137, Short.MAX_VALUE)
                                    .addComponent(jComboBox_Mesero, 0, 137, Short.MAX_VALUE)
                                    .addComponent(jDateChooser_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Cargarpedidos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Mesa)
                    .addComponent(jComboBox_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Mesero)
                    .addComponent(jComboBox_Mesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jDateChooser_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_PedidoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_CrearPedido)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Pedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Limpiar)
                    .addComponent(jButton_Cargar_detalle)
                    .addComponent(jButton_Salir)
                    .addComponent(jButton_TotalPorDia))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Cargar_detalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cargar_detalleActionPerformed
        // TODO add your handling code here:
        int id =Integer.parseInt(jTextField_PedidoNumero.getText());
        int cantidad_filas = jTable_Pedido.getRowCount();

            for (int i = 0; i < cantidad_filas; i++) {
                DefaultTableModel modelo = (DefaultTableModel) jTable_Pedido.getModel();

                int producto_id = (int) modelo.getValueAt(i, 0);// Columna "ID"
                double precio = (double) modelo.getValueAt(i, 2);// Columna "Precio"
                if (modelo.getValueAt(i, 3) != null) {
                int cantidad = Integer.parseInt(modelo.getValueAt(i, 3).toString());// Columna "Cantidad" 
                producto = produ_data.buscarProductoPorID(producto_id);
                pedido = this.pedi_data.buscarPedidoPorID(id);

                Detalle_Pedido detalle= new Detalle_Pedido(producto, pedido, cantidad);
                detalle_data.guardarDetalle(detalle);
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
        
        if (jDateChooser_Fecha.getDate() != null) {    
            
            //obtener fecha (java.util.Date)
            java.util.Date fechaUtil = jDateChooser_Fecha.getDate();
        
            //convertir util a Local
            LocalDate fechaLocal = fechaUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            //convierter Local a java.sql.Date
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaLocal);
            
            Pedido nuevo_pedido = new Pedido(mesa_selec, mesero_secMesero, 1, fechaLocal);
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
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una fecha");            
        }
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

    private void jDateChooser_FechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser_FechaPropertyChange
        // TODO add your handling code here:
        if (jDateChooser_Fecha.getDate() != null) {
            LocalDate fecha = jDateChooser_Fecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();            
        }
    }//GEN-LAST:event_jDateChooser_FechaPropertyChange

    private void jButton_TotalPorDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TotalPorDiaActionPerformed
        // TODO add your handling code here:
        java.util.Date fechaUtil = jDateChooser_Fecha.getDate();

        if (fechaUtil != null) {
            LocalDate fechaLocal = fechaUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.println(fechaLocal);
            System.out.println(pedi_data.gananciaTotalPorFecha(fechaLocal));
        } else {
            JOptionPane.showMessageDialog(null, "Introduzca una fecha válida.");
        }
    }//GEN-LAST:event_jButton_TotalPorDiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cargar_detalle;
    private javax.swing.JButton jButton_CrearPedido;
    private javax.swing.JButton jButton_Limpiar;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JButton jButton_TotalPorDia;
    private javax.swing.JComboBox<Mesa> jComboBox_Mesa;
    private javax.swing.JComboBox<Mesero> jComboBox_Mesero;
    private com.toedter.calendar.JDateChooser jDateChooser_Fecha;
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

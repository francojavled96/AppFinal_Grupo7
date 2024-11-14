/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import appfinal_grupo7.AccesoADatos.MesaData;
import appfinal_grupo7.AccesoADatos.ReservaData;
import appfinal_grupo7.Entidades.Mesa;
import appfinal_grupo7.Entidades.Reserva;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author litob
 */
public class Modificar_Eliminar_Reserva extends javax.swing.JInternalFrame {
    private MesaData mesadata;
    private ReservaData reservaData;
    private List<Reserva> reservas;
    private DefaultTableModel modelo;
    
    
    public Modificar_Eliminar_Reserva() { //comn
        
        initComponents();
        jTableReservas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        modelo = new DefaultTableModel();
        jTableReservas.setModel(modelo);
        armarTabla();
        reservaData = new ReservaData();
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooserReserva = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldIdReserva = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservas = new javax.swing.JTable();
        jButtonAnularReserva = new javax.swing.JButton();
        jButtonBuscarId = new javax.swing.JButton();
        jButtonBuscarFecha = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();

        jLabel1.setText("Seleccione Fecha");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("BUSCAR RESERVA");

        jLabel3.setText("Ingrese ID de la Reserva");

        jTextFieldIdReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdReservaActionPerformed(evt);
            }
        });

        jTableReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableReservas);

        jButtonAnularReserva.setText("Anular Reserva");
        jButtonAnularReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnularReservaActionPerformed(evt);
            }
        });

        jButtonBuscarId.setText("Buscar");
        jButtonBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarIdActionPerformed(evt);
            }
        });

        jButtonBuscarFecha.setText("Buscar");
        jButtonBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarFechaActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBuscarFecha)
                            .addComponent(jButtonBuscarId)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButtonAnularReserva))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jButtonLimpiar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jDateChooserReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarId)))
                    .addComponent(jButtonBuscarFecha))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonAnularReserva)
                .addGap(37, 37, 37)
                .addComponent(jButtonLimpiar)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnularReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnularReservaActionPerformed
        int[] filasSelec = jTableReservas.getSelectedRows();
        if (filasSelec.length > 0) { // Verifica si se seleccionaron reservas
            for (int fila : filasSelec) {
                int idReserva = (int) modelo.getValueAt(fila, 0); 
                reservaData.ActualizaReserva(idReserva);  
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una reserva para anular", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAnularReservaActionPerformed
    
    private void jButtonBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarFechaActionPerformed
        try {
        modelo.setRowCount(0);
        ArrayList<Reserva> reservas= new ArrayList<>();
        
        /////FECHA  sqlDate//////////////////
        java.util.Date fecha = jDateChooserReserva.getDate();
        LocalDate fecha2 = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(fecha2);
        reservas = (ArrayList) reservaData.listarReservasPorFecha(sqlDate);
        
        // Si no se encuentran reservas
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron reservas activas en la fecha ingresada");
            return;
        }

        // Agrego reservas sa tabla
        for (Reserva reserva : reservas) {
            Object[] fila = new Object[] {
                reserva.getId_reserva(),   
                reserva.getMesa().getId_mesa(), 
                reserva.getNombre_persona(),  
                reserva.getDni(), 
                reserva.getFecha(),  
                reserva.getHora(),   
                reserva.isEstado() ? "Activo" : "Inactivo" // Estado (convertido a texto)
            };
            modelo.addRow(fila); // agrego la fila al modelo de la tabla
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de reserva valido");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al buscar reservas: " + e.getMessage());
    }
        
        
        
    }//GEN-LAST:event_jButtonBuscarFechaActionPerformed

    private void jButtonBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarIdActionPerformed
    
        try {
        modelo.setRowCount(0);
        ArrayList<Reserva> reservas= new ArrayList<>();
        Integer idRserva = Integer.parseInt(jTextFieldIdReserva.getText());
        reservas = (ArrayList) reservaData.listarReservasPorId(idRserva);
        
        // Si no se encuentran reservas, muestra un mensaje
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron reservas con esa ID");
            return;
        }

        // Agrega cada reserva ala tabla
        for (Reserva reserva : reservas) {
            Object[] fila = new Object[] {
                reserva.getId_reserva(),   
                reserva.getMesa().getId_mesa(), 
                reserva.getNombre_persona(),  
                reserva.getDni(),  
                reserva.getFecha(),  
                reserva.getHora(),   
                reserva.isEstado() ? "Activo" : "Inactivo" // Estado (convertido a texto)
            };
            modelo.addRow(fila); // Agrega la fila al modelo de la tabla
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID de reserva válido");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al buscar reservas: " + e.getMessage());
    }
        

        
        
        
    }//GEN-LAST:event_jButtonBuscarIdActionPerformed

    private void jTextFieldIdReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdReservaActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarCampos();
        borrarFila();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed
    private void armarTabla(){
        ArrayList<Object> cabecera = new ArrayList<>();
        cabecera.add("ID Reserva");
        cabecera.add("ID Mesa");
        cabecera.add("Nombre");
        cabecera.add("DNI");
        cabecera.add("Fecha");
        cabecera.add("Hora");
        cabecera.add("Estado");
        
        for (Object object : cabecera) {
            modelo.addColumn(object);
        }
        jTableReservas.setModel(modelo);
    }  
    
        private void limpiarCampos(){
       
        jTextFieldIdReserva.setText("");
        jDateChooserReserva.setDate(new java.util.Date());
        
        }
        private void borrarFila(){
            int indice = modelo.getRowCount()-1;
                for (int i = indice; i>=0; i--) {
                    modelo.removeRow(i);
                }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnularReserva;
    private javax.swing.JButton jButtonBuscarFecha;
    private javax.swing.JButton jButtonBuscarId;
    private javax.swing.JButton jButtonLimpiar;
    private com.toedter.calendar.JDateChooser jDateChooserReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReservas;
    private javax.swing.JTextField jTextFieldIdReserva;
    // End of variables declaration//GEN-END:variables
}

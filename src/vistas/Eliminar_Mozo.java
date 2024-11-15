/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import appfinal_grupo7.AccesoADatos.MeseroData;
import appfinal_grupo7.AccesoADatos.ReservaData;
import appfinal_grupo7.Entidades.Mesa;
import appfinal_grupo7.Entidades.Mesero;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author litob
 */
public class Eliminar_Mozo extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private List<Mesero> listaMeseros;
    private MeseroData meseroData;
    
    public Eliminar_Mozo() {
    initComponents();
    meseroData = new MeseroData();
    jTableMozos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    modelo = new DefaultTableModel(); 
    armarTabla();  
    jTableMozos.setModel(modelo); 
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMozos = new javax.swing.JTable();
        jToggleButton_LiberarMesero = new javax.swing.JToggleButton();
        jToggleButton_Echar = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButtonListarMozos = new javax.swing.JToggleButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SELECCIONE MOZO");

        jTableMozos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableMozos);

        jToggleButton_LiberarMesero.setText("Liberar mesero");
        jToggleButton_LiberarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_LiberarMeseroActionPerformed(evt);
            }
        });

        jToggleButton_Echar.setText("Despedir mesero");
        jToggleButton_Echar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_EcharActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Salir");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButtonListarMozos.setText("Listar todos los mozos");
        jToggleButtonListarMozos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonListarMozosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jToggleButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButtonListarMozos)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton_LiberarMesero)
                                .addGap(43, 43, 43)
                                .addComponent(jToggleButton_Echar)))))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jToggleButtonListarMozos)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton_LiberarMesero)
                    .addComponent(jToggleButton_Echar))
                .addGap(18, 18, 18)
                .addComponent(jToggleButton3)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton_LiberarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_LiberarMeseroActionPerformed
        int seleccion = jTableMozos.getSelectedRow();
        if (seleccion != -1) {
            int idMesero = (int) modelo.getValueAt(seleccion, 0);
            meseroData.cambiarALibre(idMesero); 
            cargarMeserosDisponibles(); 
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un mozo para liberar");
        }
    }//GEN-LAST:event_jToggleButton_LiberarMeseroActionPerformed

    private void jToggleButtonListarMozosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonListarMozosActionPerformed
        cargarMeserosDisponibles();
    }//GEN-LAST:event_jToggleButtonListarMozosActionPerformed

    private void jToggleButton_EcharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_EcharActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = jTableMozos.getSelectedRow();
    
        if (filaSeleccionada != -1) {
            int idMesero = (int) modelo.getValueAt(filaSeleccionada, 0);
            meseroData.eliminarMesero(idMesero); 
            cargarMeserosDisponibles(); 
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un mozo para dar de baja.");
        }
    }//GEN-LAST:event_jToggleButton_EcharActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jToggleButton3ActionPerformed
 private void armarTabla(){
        ArrayList<Object> cabecera = new ArrayList<>();
        cabecera.add("ID");
        cabecera.add("Nombre");
        cabecera.add("Apellido");
        
        
        for (Object object : cabecera) {
            modelo.addColumn(object);
        }
        jTableMozos.setModel(modelo);
    }
 public void cargarMeserosDisponibles(){ //en la tabla
      modelo.setRowCount(0); 
     listaMeseros = (ArrayList) meseroData.listarMeserosTodos();
     
     for (Mesero mesero : listaMeseros) {
            modelo.addRow(new Object[] {mesero.getId_mesero(), mesero.getNombre_mesero(),mesero.getApellido_mesero() });
        }
 
 
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMozos;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButtonListarMozos;
    private javax.swing.JToggleButton jToggleButton_Echar;
    private javax.swing.JToggleButton jToggleButton_LiberarMesero;
    // End of variables declaration//GEN-END:variables
}

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
public class Listar_Reservas extends javax.swing.JInternalFrame {

    private MesaData mesaData;
    private ReservaData reservaData = new ReservaData();
    private DefaultTableModel modelo;
    private List<Mesa> listaMesas;
    public Listar_Reservas() {
        initComponents();
        jTableReservas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        modelo = new DefaultTableModel();
        jTableReservas.setModel(modelo);
        armarTabla();
        reservaData = new ReservaData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReservas = new javax.swing.JTable();
        jButtonReservasActivas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonInactivas = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("RESERVAS");

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

        jButtonReservasActivas.setText("Activas");
        jButtonReservasActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReservasActivasActionPerformed(evt);
            }
        });

        jButton2.setText("Listar todas las reservas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("LIMPIAR");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonInactivas.setText("Inactivas");
        jButtonInactivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInactivasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLimpiar)
                .addGap(193, 193, 193))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButtonReservasActivas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonInactivas, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReservasActivas)
                    .addComponent(jButton2)
                    .addComponent(jButtonInactivas))
                .addGap(18, 18, 18)
                .addComponent(jButtonLimpiar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //LISTAR TODAS LAS RESERVAS
        
        try {
        modelo.setRowCount(0);
        ArrayList<Reserva> reservas= new ArrayList<>();
        

        reservas = (ArrayList) reservaData.listarTodasReservas();
        
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonReservasActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReservasActivasActionPerformed
        //LISTAR RESERVAS ASCTIVAS
                try {
        modelo.setRowCount(0);
        ArrayList<Reserva> reservas= new ArrayList<>();
        

        reservas = (ArrayList) reservaData.listarReservasActivas();
        
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
        
        
    }//GEN-LAST:event_jButtonReservasActivasActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarCampos();
        borrarFila();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonInactivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInactivasActionPerformed
                        try {
        modelo.setRowCount(0);
        ArrayList<Reserva> reservas= new ArrayList<>();
        

        reservas = (ArrayList) reservaData.listarReservasNoActivas();
        
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
    }//GEN-LAST:event_jButtonInactivasActionPerformed
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
       
        
        
        }
        private void borrarFila(){
            int indice = modelo.getRowCount()-1;
                for (int i = indice; i>=0; i--) {
                    modelo.removeRow(i);
                }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonInactivas;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonReservasActivas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReservas;
    // End of variables declaration//GEN-END:variables
}

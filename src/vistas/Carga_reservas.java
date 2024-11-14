/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import appfinal_grupo7.AccesoADatos.MesaData;
import appfinal_grupo7.AccesoADatos.ReservaData;
import appfinal_grupo7.Entidades.Mesa;
import appfinal_grupo7.Entidades.Reserva;
import java.sql.Date;
import java.time.LocalDate; //fecha
import java.time.LocalTime; //hora
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno
 */
public class Carga_reservas extends javax.swing.JInternalFrame {
    private MesaData mesaData;
    private ReservaData reserData = new ReservaData();
    private DefaultTableModel modelo;
    private List<Mesa> listaMesas;
    
    
    
    
    
    public Carga_reservas() {
        initComponents();
        jTableMesas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        modelo = new DefaultTableModel();
        reserData = new ReservaData();
       
        jTableMesas.setModel(modelo);
        mesaData = new MesaData();  // Inicializar mesaData antes de llamar a cargarDisponibles()
        armarTabla();
        inicializarComboHora();
        inicializarComboMinuto();
        
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_CargarReservas = new javax.swing.JLabel();
        jLabel_SeleccionarHorario = new javax.swing.JLabel();
        jLabel_DatosCliente = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_DNI = new javax.swing.JLabel();
        jButton_Limpiar = new javax.swing.JButton();
        jButton_CrearReserva = new javax.swing.JButton();
        jTextField_Nombre = new javax.swing.JTextField();
        jTextField_DNI = new javax.swing.JTextField();
        jLabel_SeleccionarDia = new javax.swing.JLabel();
        jLabel_SeleccionarCantidad = new javax.swing.JLabel();
        jDateChooserReserva = new com.toedter.calendar.JDateChooser();
        jComboHora = new javax.swing.JComboBox<>();
        jComboMinuto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMesas = new javax.swing.JTable();
        jTextFieldCantidadP = new javax.swing.JTextField();
        jButtonCalcularMesas = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 153));
        setClosable(true);

        jLabel_CargarReservas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_CargarReservas.setText("Buscar disponibilidad");

        jLabel_SeleccionarHorario.setText("Seleccione un horario");

        jLabel_DatosCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel_DatosCliente.setText("Cargar Reserva");

        jLabel_Nombre.setText("Nombre");

        jLabel_DNI.setText("DNI");

        jButton_Limpiar.setText("Limpiar");
        jButton_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LimpiarActionPerformed(evt);
            }
        });

        jButton_CrearReserva.setText("Crear reserva");
        jButton_CrearReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearReservaActionPerformed(evt);
            }
        });

        jTextField_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NombreActionPerformed(evt);
            }
        });

        jTextField_DNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DNIActionPerformed(evt);
            }
        });

        jLabel_SeleccionarDia.setText("Seleccione un día");

        jLabel_SeleccionarCantidad.setText("Seleccione cantidad personas");

        jComboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboHoraActionPerformed(evt);
            }
        });

        jComboMinuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMinutoActionPerformed(evt);
            }
        });

        jTableMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTableMesas.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jTableMesas);
        if (jTableMesas.getColumnModel().getColumnCount() > 0) {
            jTableMesas.getColumnModel().getColumn(0).setResizable(false);
        }

        jTextFieldCantidadP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadPActionPerformed(evt);
            }
        });

        jButtonCalcularMesas.setText("Buscar");
        jButtonCalcularMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularMesasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel_CargarReservas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_SeleccionarCantidad)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCantidadP, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_SeleccionarDia)
                                .addGap(29, 29, 29)
                                .addComponent(jDateChooserReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButtonCalcularMesas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_DNI)
                                    .addComponent(jLabel_Nombre))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel_DatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_SeleccionarHorario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton_Limpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_CrearReserva)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel_CargarReservas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_SeleccionarDia)
                    .addComponent(jDateChooserReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_SeleccionarCantidad)
                    .addComponent(jTextFieldCantidadP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCalcularMesas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel_DatosCliente)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Nombre)
                    .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_DNI)
                    .addComponent(jTextField_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_SeleccionarHorario)
                    .addComponent(jComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Limpiar)
                    .addComponent(jButton_CrearReserva))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CrearReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearReservaActionPerformed
    
        try {    
        String nombre = jTextField_Nombre.getText();
        Integer dni = Integer.parseInt(jTextField_DNI.getText());
        java.util.Date fecha = jDateChooserReserva.getDate();
        LocalDate fecha2 = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();  
        String horaSeleccionada = (String) jComboHora.getSelectedItem();
        String minutoSeleccionado = (String) jComboMinuto.getSelectedItem();
        ////
        int hora = Integer.parseInt(horaSeleccionada);
        int minuto = Integer.parseInt(minutoSeleccionado);
        LocalTime tiempo = LocalTime.of(hora, minuto);
        
       
    
        
        
        // Buscar la mesa seleccionada
            int[] filasSelec = jTableMesas.getSelectedRows();
            if (filasSelec.length > 0) { // Verifica si se seleccionaron mesas
            for (int fila : filasSelec) {
                int idMesa = (int) modelo.getValueAt(fila, 1); // 
                Mesa mesa = mesaData.buscarMesaPorID(idMesa);  
                if (mesa != null) {
                    // Crear la reserva para cada mesa seleccionada
                   Reserva nuevaReserva = new Reserva(mesa, nombre, dni, fecha2, tiempo, true);
                   reserData.guardarReserva(nuevaReserva); // Guardar la reserva en la base de datos
                } else {
                    JOptionPane.showMessageDialog(this, "Mesa no encontrada para el id " + idMesa, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una mesa", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Debe ingresar un formato de número válido", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton_CrearReservaActionPerformed

    private void jButton_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LimpiarActionPerformed
        limpiarCampos();
        borrarFila();
        
    }//GEN-LAST:event_jButton_LimpiarActionPerformed

    private void jTextField_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NombreActionPerformed

    private void jTextField_DNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DNIActionPerformed

    private void jComboMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboMinutoActionPerformed

    private void jComboHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboHoraActionPerformed

    }//GEN-LAST:event_jComboHoraActionPerformed

    private void jTextFieldCantidadPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadPActionPerformed

    private void jButtonCalcularMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularMesasActionPerformed
            cargarDisponibles();
            
    }//GEN-LAST:event_jButtonCalcularMesasActionPerformed

        private void limpiarCampos(){
       
        jTextField_Nombre.setText("");
        jTextField_DNI.setText("");
        jTextFieldCantidadP.setText("");
        jDateChooserReserva.setDate(new java.util.Date());
    }
        
        
        private void armarTabla(){
        ArrayList<Object> cabecera = new ArrayList<>();
        cabecera.add("ID");
        cabecera.add("Numero Mesa");
        cabecera.add("Capacidad");
        
        for (Object object : cabecera) {
            modelo.addColumn(object);
        }
        jTableMesas.setModel(modelo);
    }  
        
        
    private void cargarDisponibles() {
        // Obtener la cantidad de personas desde el JTextField
        int cantidadPersonas = 0;
        try {
            cantidadPersonas = Integer.parseInt(jTextFieldCantidadP.getText()); // Obtener la cantidad de personas como entero
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido de personas.");
            return;
        }
        // Obtener la fecha de jDateChooser (java.util.Date)
        java.util.Date fecha = jDateChooserReserva.getDate();

        // Convertir la fecha a LocalDate
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Convertir el LocalDate a java.sql.Date
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

        // Limpiar la tabla antes de cargar los nuevos datos
        modelo.setRowCount(0); // Limpiar las filas actuales de la tabla

        // Obtener las mesas libres
        listaMesas = (ArrayList) mesaData.listarMesasDisponiblesXFecha(sqlDate); // Llamamos al método que obtiene las mesas libres

        // Filtrar las mesas cuya capacidad sea mayor o igual a la cantidad de personas
        ArrayList<Mesa> mesasSuficientes = new ArrayList<>();
        for (Mesa mesa : listaMesas) {
            if (mesa.getCapacidad() >= cantidadPersonas) {
                mesasSuficientes.add(mesa); // Agregar las mesas que cumplen con el requisito
            }
        }

        // Si encontramos mesas las agregamos directamente a la tabla
        for (Mesa mesa : mesasSuficientes) {
            modelo.addRow(new Object[] { mesa.getId_mesa(),  mesa.getNumero(), mesa.getCapacidad()});
        }

        // Si no encontramos mesas
        if (mesasSuficientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron mesas disponibles para la cantidad de personas solicitada.");
        }
    }
    
    private void cargarOcupadas(){    
        listaMesas= (ArrayList) mesaData.listarMesasOcupadas();
            for (Mesa mesa : listaMesas) {
                modelo.addRow(new Object[] {mesa.getNumero(), mesa.getCapacidad()});            
            }  
      
    }
        
        private void borrarFila(){
            int indice = modelo.getRowCount()-1;
        
                for (int i = indice; i>=0; i--) {
                    modelo.removeRow(i);
                }
        }
        private void inicializarComboHora() { ///cargar comboHora
            jComboHora.removeAllItems(); 
            for (int i = 0; i < 24; i++) {
            String hora = String.format("%02d", i); // Formatea el número para que tenga dos dígitos
            jComboHora.addItem(hora);
            }
        }
        private void inicializarComboMinuto() {
            jComboMinuto.removeAllItems();
            for (int i = 0; i < 60; i++) {
            String minuto = String.format("%02d", i); // Formatea el número para que tenga dos dígitos
            jComboMinuto.addItem(minuto);
            }             
        }
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalcularMesas;
    private javax.swing.JButton jButton_CrearReserva;
    private javax.swing.JButton jButton_Limpiar;
    private javax.swing.JComboBox<String> jComboHora;
    private javax.swing.JComboBox<String> jComboMinuto;
    private com.toedter.calendar.JDateChooser jDateChooserReserva;
    private javax.swing.JLabel jLabel_CargarReservas;
    private javax.swing.JLabel jLabel_DNI;
    private javax.swing.JLabel jLabel_DatosCliente;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_SeleccionarCantidad;
    private javax.swing.JLabel jLabel_SeleccionarDia;
    private javax.swing.JLabel jLabel_SeleccionarHorario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMesas;
    private javax.swing.JTextField jTextFieldCantidadP;
    private javax.swing.JTextField jTextField_DNI;
    private javax.swing.JTextField jTextField_Nombre;
    // End of variables declaration//GEN-END:variables
}

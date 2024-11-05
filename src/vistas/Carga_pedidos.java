/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author bruno
 */
public class Carga_pedidos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Carga_pedidos
     */
    public Carga_pedidos() {
        initComponents();
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
        jButton_Cargar_pedido = new javax.swing.JButton();
        jLabel_Mesa = new javax.swing.JLabel();
        jComboBox_Mesa = new javax.swing.JComboBox<>();
        jLabel_Mesero = new javax.swing.JLabel();
        jComboBox_Mesero = new javax.swing.JComboBox<>();

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
                "Producto", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Pedido);

        jButton_Limpiar.setText("Limpiar");

        jButton_Cargar_pedido.setText("Cargar pedido");
        jButton_Cargar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Cargar_pedidoActionPerformed(evt);
            }
        });

        jLabel_Mesa.setText("Seleccione una mesa");

        jComboBox_Mesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel_Mesero.setText("Seleccione un mesero");

        jComboBox_Mesero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 108, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_Pedido)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Mesero)
                                    .addComponent(jLabel_Mesa))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jComboBox_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jComboBox_Mesero, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButton_Limpiar)
                        .addGap(51, 51, 51)
                        .addComponent(jButton_Cargar_pedido))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel_Cargarpedidos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_Cargarpedidos)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Mesa)
                    .addComponent(jComboBox_Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Mesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Mesero))
                .addGap(38, 38, 38)
                .addComponent(jLabel_Pedido)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Limpiar)
                    .addComponent(jButton_Cargar_pedido))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Cargar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Cargar_pedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Cargar_pedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cargar_pedido;
    private javax.swing.JButton jButton_Limpiar;
    private javax.swing.JComboBox<String> jComboBox_Mesa;
    private javax.swing.JComboBox<String> jComboBox_Mesero;
    private javax.swing.JLabel jLabel_Cargarpedidos;
    private javax.swing.JLabel jLabel_Mesa;
    private javax.swing.JLabel jLabel_Mesero;
    private javax.swing.JLabel jLabel_Pedido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Pedido;
    // End of variables declaration//GEN-END:variables
}
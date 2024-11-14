
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
import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno
 */
public class Ganancias extends javax.swing.JInternalFrame {
    private Pedido pedido;    
    private PedidoData pedi_data;    
    private DefaultTableModel modelo;
    
    private Color color;

    /**
     * Creates new form Ganancias
     */
    public Ganancias() {
        initComponents();        
        pedi_data = new PedidoData();
        String texto = "Elija una fecha, verá una lista con todos los pedidos realizados en la misma y la ganancia total diaria";
        jLabel_texto.setText(textoAHTML(texto));
        
        color = jButton_Salir.getBackground(); 
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
        jDateChooser_Fecha = new com.toedter.calendar.JDateChooser();
        jButton_Buscar = new javax.swing.JButton();
        jLabel_texto = new javax.swing.JLabel();
        jButton_Salir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Ganancia por día");

        jButton_Buscar.setText("¡Buscar!");
        jButton_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_BuscarMouseExited(evt);
            }
        });
        jButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActionPerformed(evt);
            }
        });

        jLabel_texto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel_texto.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_texto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_texto.setText("Elija una fecha, verá una lista con todos los pedidos realizados en la misma y la ganancia total diaria");
        jLabel_texto.setToolTipText("");
        jLabel_texto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jButton_Salir.setText("Salir");
        jButton_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_SalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_SalirMouseExited(evt);
            }
        });
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jDateChooser_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jButton_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jButton_Salir)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jButton_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton_Salir)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActionPerformed
        // TODO add your handling code here:
        LocalDate fecha = jDateChooser_Fecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (fecha != null) {
            //double total = pedi_data.gananciaTotalPorFecha(fecha);
            double total = pedi_data.calcularTotalPorFecha(fecha);
            JOptionPane.showMessageDialog(this, "La ganancia total para el día " + fecha + " es de: $" + total);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.");
        }
    }//GEN-LAST:event_jButton_BuscarActionPerformed

    private void jButton_BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_BuscarMouseEntered
        // TODO add your handling code here:
        jButton_Buscar.setBackground( Color.orange.darker());
    }//GEN-LAST:event_jButton_BuscarMouseEntered

    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton_SalirActionPerformed

    private void jButton_SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SalirMouseEntered
        // TODO add your handling code here:
        jButton_Salir.setBackground( Color.red.darker());
    }//GEN-LAST:event_jButton_SalirMouseEntered

    private void jButton_SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SalirMouseExited
        // TODO add your handling code here:
        jButton_Salir.setBackground(color);
    }//GEN-LAST:event_jButton_SalirMouseExited

    private void jButton_BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_BuscarMouseExited
        // TODO add your handling code here:
        jButton_Buscar.setBackground(color);
    }//GEN-LAST:event_jButton_BuscarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Buscar;
    private javax.swing.JButton jButton_Salir;
    private com.toedter.calendar.JDateChooser jDateChooser_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_texto;
    // End of variables declaration//GEN-END:variables

    public String textoAHTML (String texto){
        return "<html><p>" + texto + "</p></html>";
    }


}

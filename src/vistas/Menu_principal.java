/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author bruno
 */
public class Menu_principal extends javax.swing.JFrame {

    /**
     * Creates new form Menu_principal
     */
    public Menu_principal() {
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

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Pedidos = new javax.swing.JMenu();
        jMenuItem_CrearPedi = new javax.swing.JMenuItem();
        jMenuItem_CobrarPedi = new javax.swing.JMenuItem();
        jMenu_Reservas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu_Pedidos.setText("Pedidos");
        jMenu_Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_PedidosActionPerformed(evt);
            }
        });

        jMenuItem_CrearPedi.setText("Crear/eliminar pedido");
        jMenuItem_CrearPedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CrearPediActionPerformed(evt);
            }
        });
        jMenu_Pedidos.add(jMenuItem_CrearPedi);

        jMenuItem_CobrarPedi.setText("Cobrar pedido");
        jMenuItem_CobrarPedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_CobrarPediActionPerformed(evt);
            }
        });
        jMenu_Pedidos.add(jMenuItem_CobrarPedi);

        jMenuBar1.add(jMenu_Pedidos);

        jMenu_Reservas.setText("Reservas");
        jMenuBar1.add(jMenu_Reservas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu_PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_PedidosActionPerformed
        // TODO add your handling code here:
              
    }//GEN-LAST:event_jMenu_PedidosActionPerformed

    private void jMenuItem_CrearPediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CrearPediActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        Carga_pedidos pedidos = new Carga_pedidos();
        pedidos.setVisible(true);
        escritorio.add(pedidos);  
    }//GEN-LAST:event_jMenuItem_CrearPediActionPerformed

    private void jMenuItem_CobrarPediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_CobrarPediActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_CobrarPediActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_CobrarPedi;
    private javax.swing.JMenuItem jMenuItem_CrearPedi;
    private javax.swing.JMenu jMenu_Pedidos;
    private javax.swing.JMenu jMenu_Reservas;
    // End of variables declaration//GEN-END:variables
}

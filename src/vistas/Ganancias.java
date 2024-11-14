
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
    private ArrayList<Mesa> lista_mesa;
    private ArrayList<Mesero> lista_mesero;
    private ArrayList<Producto> lista_producto;
    
    
    private Producto producto;
    private Mesero mesero;
    private Detalle_Pedido detalle_pedido;
    private Pedido pedido;
    
    private MeseroData mesero_data;
    private Detalle_PedidoData detalle_data; 
    private PedidoData pedi_data;
    private ProductoData produ_data;
    
    private DefaultTableModel modelo;

    /**
     * Creates new form Ganancias
     */
    public Ganancias() {
        initComponents();
        
        mesero_data = new MeseroData();
        pedi_data = new PedidoData();
        detalle_data = new Detalle_PedidoData();
        produ_data = new ProductoData();
        modelo = new DefaultTableModel();
        
        
        /*cargarMesas();
        cargarMeseros();
        armarTabla();
        cargarTabla();*/
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Ganancia por día");

        jButton_Buscar.setText("¡Buscar!");
        jButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Elija una fecha, verá uuna lista con todos los pedidos realizados en la misma y la ganancia total diaria");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jDateChooser_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jButton_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jDateChooser_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Buscar;
    private com.toedter.calendar.JDateChooser jDateChooser_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

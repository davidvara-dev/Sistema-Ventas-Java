
package vista;

import java.util.ArrayList;
import modelo.DetalleVenta;
import modelo.Venta;
public class FrmComprobante extends javax.swing.JFrame {
    
    private Venta venta;
private ArrayList<DetalleVenta> detalles;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmComprobante.class.getName());

  
    
    
    public FrmComprobante() {
        initComponents();
    }
public FrmComprobante(Venta venta, ArrayList<DetalleVenta> detalles) {
    initComponents();
    setLocationRelativeTo(null);
    setTitle("Comprobante de Venta");

    this.venta = venta;
    this.detalles = detalles;

    generarComprobante();
}

/*Metodo para generar comprobante*/
private void generarComprobante() {

    StringBuilder sb = new StringBuilder();

    sb.append("========================================\n");
    sb.append("           SISTEMA DE VENTAS            \n");
    sb.append("========================================\n");
    sb.append("          COMPROBANTE DE VENTA          \n");
    sb.append("========================================\n\n");

    sb.append("Venta N°: ").append(venta.getIdVenta()).append("\n");
    sb.append("Fecha: ").append(venta.getFecha()).append("\n\n");

    sb.append("Cliente: ").append(venta.getCliente().getNombres()).append("\n");
    sb.append("DNI: ").append(venta.getCliente().getDNI()).append("\n");
    sb.append("Vendedor: ").append(venta.getUsuario().getUsuario()).append("\n\n");

    sb.append("----------------------------------------\n");
    sb.append(String.format("%-15s %5s %8s %8s\n", "Producto", "Cant", "Precio", "Subt."));
    sb.append("----------------------------------------\n");

    for (DetalleVenta detalle : detalles) {

        String nombreProducto = detalle.getProducto().getNombre();

        if (nombreProducto.length() > 15) {
            nombreProducto = nombreProducto.substring(0, 15);
        }

        sb.append(String.format(
                java.util.Locale.US,
                "%-15s %5d %8.2f %8.2f\n",
                nombreProducto,
                detalle.getCantidad(),
                detalle.getPrecioUnitario(),
                detalle.getSubtotal()
        ));
    }

    sb.append("----------------------------------------\n");
    sb.append(String.format(java.util.Locale.US, "%-25s S/ %8.2f\n", "Subtotal:", venta.getSubtotal()));
    sb.append(String.format(java.util.Locale.US, "%-25s S/ %8.2f\n", "IGV:", venta.getIgv()));
    sb.append(String.format(java.util.Locale.US, "%-25s S/ %8.2f\n", "Total:", venta.getTotal()));
    sb.append("----------------------------------------\n\n");

    sb.append("        Gracias por su compra.\n");
    sb.append("========================================\n");

    txtComprobante.setText(sb.toString());
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtComprobante = new javax.swing.JTextArea();
        btnCerrar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtComprobante.setEditable(false);
        txtComprobante.setColumns(20);
        txtComprobante.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtComprobante.setRows(5);
        jScrollPane1.setViewportView(txtComprobante);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::btnCerrarActionPerformed);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(this::btnImprimirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addGap(36, 36, 36)
                .addComponent(btnCerrar)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnImprimir))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();

    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
 try {
        txtComprobante.print();
    } catch (Exception e) {
        System.out.println("Error al imprimir comprobante");
        System.out.println("Error: " + e.getMessage());
    }

    }//GEN-LAST:event_btnImprimirActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmComprobante().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtComprobante;
    // End of variables declaration//GEN-END:variables
}

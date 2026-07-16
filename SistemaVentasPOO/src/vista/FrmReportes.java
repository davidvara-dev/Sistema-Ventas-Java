
package vista;

import controlador.ReporteControlador;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Producto;
import modelo.Venta;
import util.EstiloUI;
import modelo.DetalleVenta;
import javax.swing.JOptionPane;

public class FrmReportes extends javax.swing.JFrame {
    private final ReporteControlador controlador = new ReporteControlador();

    private String reporteActual = "";
    public FrmReportes() {
        initComponents();
         setLocationRelativeTo(null);
    setTitle("Reportes del Sistema");
    setMinimumSize(new java.awt.Dimension(900, 600));
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProductos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReportes = new javax.swing.JTable();
        btnVerDetalle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tblReportes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReportesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReportes);

        btnVerDetalle.setText("Ver Detalle");
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnVolver)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(289, 289, 289)
                            .addComponent(btnVerDetalle)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductos)
                    .addComponent(btnVerDetalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        reporteActual = "PRODUCTOS";
    ArrayList<Producto> lista = controlador.productos();

    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Descripción");
    modelo.addColumn("Precio");
    modelo.addColumn("Stock");
    modelo.addColumn("Categoría");

    for (Producto producto : lista) {
        Object[] fila = new Object[6];

        fila[0] = producto.getIdProducto();
        fila[1] = producto.getNombre();
        fila[2] = producto.getDescripcion();
        fila[3] = producto.getPrecio();
        fila[4] = producto.getStock();
        fila[5] = producto.getCategoria().getNombreCategoria();

        modelo.addRow(fila);
    }

    tblReportes.setModel(modelo);
    EstiloUI.prepararTabla(tblReportes, 55, 170, 250, 90, 75, 140);
    EstiloUI.alinearDerecha(tblReportes, 3, 4);

    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
reporteActual = "CLIENTES";
    ArrayList<Cliente> lista = controlador.clientes();

    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("ID");
    modelo.addColumn("DNI");
    modelo.addColumn("Nombres");
    modelo.addColumn("Teléfono");
    modelo.addColumn("Dirección");
    modelo.addColumn("Correo");

    for (Cliente cliente : lista) {
        Object[] fila = new Object[6];

        fila[0] = cliente.getId();
        fila[1] = cliente.getDNI();
        fila[2] = cliente.getNombres();
        fila[3] = cliente.getTelefono();
        fila[4] = cliente.getDireccion();
        fila[5] = cliente.getCorreo();

        modelo.addRow(fila);
    }

    tblReportes.setModel(modelo);
    EstiloUI.prepararTabla(tblReportes, 55, 90, 180, 110, 230, 220);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        
        reporteActual = "VENTAS";
    ArrayList<Venta> lista = controlador.ventas();

    DefaultTableModel modelo = new DefaultTableModel();

    modelo.addColumn("ID Venta");
    modelo.addColumn("Fecha");
    modelo.addColumn("Cliente");
    modelo.addColumn("Usuario");
    modelo.addColumn("Subtotal");
    modelo.addColumn("IGV");
    modelo.addColumn("Total");

    for (Venta venta : lista) {
        Object[] fila = new Object[7];

        fila[0] = venta.getIdVenta();
        fila[1] = venta.getFecha();
        fila[2] = venta.getCliente().getNombres();
        fila[3] = venta.getUsuario().getUsuario();
        fila[4] = venta.getSubtotal();
        fila[5] = venta.getIgv();
        fila[6] = venta.getTotal();

        modelo.addRow(fila);
    }

    tblReportes.setModel(modelo);
    EstiloUI.prepararTabla(tblReportes, 80, 100, 190, 120, 100, 90, 110);
    EstiloUI.alinearDerecha(tblReportes, 4, 5, 6);
        
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
  
         if (!reporteActual.equals("VENTAS")) {
        JOptionPane.showMessageDialog(this, "Primero debe mostrar el reporte de ventas");
        return;
    }
        int fila = tblReportes.getSelectedRow();

    if (fila < 0) {
        JOptionPane.showMessageDialog(this, "Seleccione una venta de la tabla");
        return;
    }

    int idVenta = Integer.parseInt(tblReportes.getValueAt(fila, 0).toString());

    FrmDetalleVenta detalle = new FrmDetalleVenta(idVenta);
    detalle.setVisible(true);
    detalle.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void tblReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReportesMouseClicked
        if (evt.getClickCount() == 2) {

        if (!reporteActual.equals("VENTAS")) return;

        int fila = tblReportes.getSelectedRow();

        if (fila < 0) {
            return;
        }

        int idVenta = Integer.parseInt(tblReportes.getValueAt(fila, 0).toString());

        FrmDetalleVenta detalle = new FrmDetalleVenta(idVenta);
        detalle.setVisible(true);
        detalle.setLocationRelativeTo(null);
    }

    }//GEN-LAST:event_tblReportesMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReportes;
    // End of variables declaration//GEN-END:variables
}

package vista;

import util.Validaciones;
import controlador.VentaControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Usuario;
import modelo.Venta;
import util.EstiloUI;

public class FrmVentas extends javax.swing.JFrame {
    private final VentaControlador controlador = new VentaControlador();

    private Cliente clienteSeleccionado;
    private Producto productoSeleccionado;
    private Usuario usuarioActual;
    private ArrayList<DetalleVenta> listaDetalles;
    private DefaultTableModel modeloDetalle;

    public FrmVentas() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Registro de Ventas");
        setMinimumSize(new java.awt.Dimension(820, 650));

        listaDetalles = new ArrayList<>();

//        cargarUsuarioActual();
        prepararTablaDetalle();
        limpiarTotales();
        configurarAtajos();
    }
    
    public FrmVentas(Usuario usuario) {
    initComponents();
    setLocationRelativeTo(null);
    setTitle("Registro de Ventas");
    setMinimumSize(new java.awt.Dimension(820, 650));

    this.usuarioActual = usuario;

    listaDetalles = new ArrayList<>();
    prepararTablaDetalle();
    limpiarTotales();
    configurarAtajos();
}

    private void configurarAtajos() {
        txtIdProducto.addActionListener(evt -> btnBuscarProducto.doClick());
        txtCantidad.addActionListener(evt -> btnAgregarProducto.doClick());
        txtSubtotal.setEditable(false);
        txtIGV.setEditable(false);
        txtTotal.setEditable(false);
        txtNombreCliente.setEditable(false);
        txtNombreProducto.setEditable(false);
        txtPrecio.setEditable(false);
        txtStock.setEditable(false);
    }

    private void prepararTablaDetalle() {

        modeloDetalle = new DefaultTableModel();

        modeloDetalle.addColumn("ID Producto");
        modeloDetalle.addColumn("Producto");
        modeloDetalle.addColumn("Cantidad");
        modeloDetalle.addColumn("Precio");
        modeloDetalle.addColumn("Subtotal");

        tblDetalleVenta.setModel(modeloDetalle);
        EstiloUI.prepararTabla(tblDetalleVenta, 90, 200, 90, 100, 110);
        EstiloUI.alinearDerecha(tblDetalleVenta, 2, 3, 4);
    }

    private void limpiarTotales() {

        txtSubtotal.setText("0.00");
        txtIGV.setText("0.00");
        txtTotal.setText("0.00");
    }
// private void calcularTotales() {
//
//    double subtotal = 0;
//
//    for (DetalleVenta detalle : listaDetalles) {
//        subtotal = subtotal + detalle.getSubtotal();
//    }
//
//    double igv = subtotal * 0.18;
//    double total = subtotal + igv;
//
//    txtSubtotal.setText(String.format("%.2f", subtotal));
//    txtIGV.setText(String.format("%.2f", igv));
//    txtTotal.setText(String.format("%.2f", total));
//}

    private void calcularTotales() {

        double subtotal = 0;

        for (DetalleVenta detalle : listaDetalles) {
            subtotal = subtotal + detalle.getSubtotal();
        }

        double igv = subtotal * 0.18;
        double total = subtotal + igv;

        txtSubtotal.setText(String.format(java.util.Locale.US, "%.2f", subtotal));
        txtIGV.setText(String.format(java.util.Locale.US, "%.2f", igv));
        txtTotal.setText(String.format(java.util.Locale.US, "%.2f", total));
    }

    private void limpiarProducto() {

        txtIdProducto.setText("");
        txtNombreProducto.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtCantidad.setText("");

        productoSeleccionado = null;

        txtIdProducto.requestFocus();
    }

    private void limpiarVenta() {

        txtDNICliente.setText("");
        txtNombreCliente.setText("");

        limpiarProducto();

        clienteSeleccionado = null;
        productoSeleccionado = null;

        listaDetalles.clear();

        modeloDetalle.setRowCount(0);

        limpiarTotales();

        txtDNICliente.requestFocus();
    }

    private boolean productoYaAgregado(int idProducto) {

        for (DetalleVenta detalle : listaDetalles) {
            if (detalle.getProducto().getIdProducto() == idProducto) {
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDNICliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        txtSubtotal = new javax.swing.JTextField();
        txtIGV = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnRegistrarVenta = new javax.swing.JButton();
        btnQuitarProducto = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        lblDNI = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        lblIGV = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDNICliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIClienteActionPerformed(evt);
            }
        });

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDetalleVenta);

        btnRegistrarVenta.setText("Registrar");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });

        btnQuitarProducto.setText("Quitar");
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lblDNI.setText("DNI");

        lblNombre.setText("Nombre");

        lblSubTotal.setText("SubTotal");

        lblIGV.setText("IGV");

        lblTotal.setText("Total");

        lblProducto.setText("ID Producto");

        jLabel1.setText("Nombre");

        lblPrecio.setText("Precio");

        lblStock.setText("Stock");

        lblCantidad.setText("Cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarVenta)
                .addGap(53, 53, 53)
                .addComponent(btnQuitarProducto)
                .addGap(34, 34, 34)
                .addComponent(btnNuevo)
                .addGap(72, 72, 72)
                .addComponent(btnVolver)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreCliente)
                            .addComponent(txtDNICliente, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnAgregarProducto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarProducto))))
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(164, 164, 164))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(lblIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDNI)
                            .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProducto)
                            .addComponent(btnBuscarProducto))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarProducto)
                            .addComponent(lblCantidad))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubTotal)
                    .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIGV)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegistrarVenta)
                        .addComponent(btnQuitarProducto)
                        .addComponent(btnNuevo))
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (txtIdProducto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del producto");
            return;
        }

        int idProducto = Integer.parseInt(txtIdProducto.getText());

        productoSeleccionado = controlador.buscarProducto(idProducto);

        if (productoSeleccionado != null) {

            txtNombreProducto.setText(productoSeleccionado.getNombre());
            txtPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
            txtStock.setText(String.valueOf(productoSeleccionado.getStock()));

            txtCantidad.requestFocus();

        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado");
            limpiarProducto();
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        if (txtDNICliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el DNI del cliente");
            return;
        }

        String dni = txtDNICliente.getText();

        clienteSeleccionado = controlador.buscarCliente(dni);

        if (clienteSeleccionado != null) {
            txtNombreCliente.setText(clienteSeleccionado.getNombres());
            txtIdProducto.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado");
            txtNombreCliente.setText("");
        }

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Primero busque un producto");
            return;
        }

        if (Validaciones.campoVacio(txtCantidad.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad");
            return;
        }

        if (!Validaciones.esEntero(txtCantidad.getText())) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero");
            return;
        }

        int cantidad = Integer.parseInt(txtCantidad.getText());

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor que cero");
            return;
        }

        if (cantidad > productoSeleccionado.getStock()) {
            JOptionPane.showMessageDialog(this, "Stock insuficiente");
            return;
        }
        if (productoYaAgregado(productoSeleccionado.getIdProducto())) {
            for (int i = 0; i < listaDetalles.size(); i++) {
                DetalleVenta existente = listaDetalles.get(i);
                if (existente.getProducto().getIdProducto() == productoSeleccionado.getIdProducto()) {
                    int nuevaCantidad = existente.getCantidad() + cantidad;
                    if (nuevaCantidad > productoSeleccionado.getStock()) {
                        JOptionPane.showMessageDialog(this, "La cantidad acumulada supera el stock disponible");
                        return;
                    }
                    existente.setCantidad(nuevaCantidad);
                    existente.calcularSubtotal();
                    modeloDetalle.setValueAt(nuevaCantidad, i, 2);
                    modeloDetalle.setValueAt(existente.getSubtotal(), i, 4);
                    calcularTotales();
                    limpiarProducto();
                    return;
                }
            }
        }
        DetalleVenta detalle = new DetalleVenta();

        detalle.setProducto(productoSeleccionado);
        detalle.setCantidad(cantidad);
        detalle.setPrecioUnitario(productoSeleccionado.getPrecio());
        detalle.calcularSubtotal();

        listaDetalles.add(detalle);

        Object[] fila = new Object[5];

        fila[0] = productoSeleccionado.getIdProducto();
        fila[1] = productoSeleccionado.getNombre();
        fila[2] = cantidad;
        fila[3] = productoSeleccionado.getPrecio();
        fila[4] = detalle.getSubtotal();

        modeloDetalle.addRow(fila);

        calcularTotales();

        limpiarProducto();

    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
        int fila = tblDetalleVenta.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla");
            return;
        }

        listaDetalles.remove(fila);
        modeloDetalle.removeRow(fila);

        calcularTotales();


    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        if (clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Primero busque un cliente");
            return;
        }

        if (usuarioActual == null) {
            JOptionPane.showMessageDialog(this, "No hay usuario activo");
            return;
        }

        if (listaDetalles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe agregar al menos un producto");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "Cliente: " + clienteSeleccionado.getNombres()
                + "\nProductos: " + listaDetalles.size()
                + "\nTotal: S/ " + txtTotal.getText()
                + "\n\n¿Desea registrar la venta?",
                "Confirmar venta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmacion != JOptionPane.YES_OPTION) return;

        Venta venta = new Venta();

        venta.setCliente(clienteSeleccionado);
        venta.setUsuario(usuarioActual);
        venta.setFecha(java.time.LocalDate.now().toString());

        venta.setSubtotal(Double.parseDouble(txtSubtotal.getText()));
        venta.setIgv(Double.parseDouble(txtIGV.getText()));
        venta.setTotal(Double.parseDouble(txtTotal.getText()));

        boolean registrado = controlador.registrar(venta, listaDetalles);

        if (registrado) {
            JOptionPane.showMessageDialog(this, "Venta registrada correctamente. ID Venta: " + venta.getIdVenta());
            ArrayList<DetalleVenta> copiaDetalles = new ArrayList<>(listaDetalles);
            FrmComprobante comprobante = new FrmComprobante(venta, copiaDetalles);
            comprobante.setVisible(true);
            comprobante.setLocationRelativeTo(null);

            limpiarVenta();

        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar la venta");
        }


    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarVenta();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtDNIClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIClienteActionPerformed
        btnBuscarCliente.doClick();
    }//GEN-LAST:event_txtDNIClienteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblIGV;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDNICliente;
    private javax.swing.JTextField txtIGV;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

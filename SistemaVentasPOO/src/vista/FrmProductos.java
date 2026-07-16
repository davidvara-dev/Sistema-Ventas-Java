
package vista;
import util.Validaciones;
import controlador.ProductoControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.EstiloUI;
import modelo.Categoria;
import modelo.Producto;
public class FrmProductos extends javax.swing.JFrame {
    private final ProductoControlador productoDAO = new ProductoControlador();

   
    public FrmProductos() {
        initComponents();
            setLocationRelativeTo(null);
            setTitle("Gestión de Productos");
            setMinimumSize(new java.awt.Dimension(900, 650));
            cargarCategorias();
            listarProductos();
    }
private void cargarCategorias() {
       ArrayList<Categoria> lista = productoDAO.listarCategorias();
       cboCategoria.removeAllItems();
       for(Categoria categoria: lista){
           cboCategoria.addItem(categoria);
       }
}

private void listarProductos() {


    ArrayList<Producto> lista = productoDAO.listar();

    DefaultTableModel modeloTabla = new DefaultTableModel();

    modeloTabla.addColumn("ID");
    modeloTabla.addColumn("Nombre");
    modeloTabla.addColumn("Descripción");
    modeloTabla.addColumn("Precio");
    modeloTabla.addColumn("Stock");
    modeloTabla.addColumn("Categoría");

    for (Producto producto : lista) {

        Object[] fila = new Object[6];

        fila[0] = producto.getIdProducto();
        fila[1] = producto.getNombre();
        fila[2] = producto.getDescripcion();
        fila[3] = producto.getPrecio();
        fila[4] = producto.getStock();
        fila[5] = producto.getCategoria().getNombreCategoria();

        modeloTabla.addRow(fila);
    }

    tblProductos.setModel(modeloTabla);
    EstiloUI.prepararTabla(tblProductos, 55, 170, 250, 90, 75, 140);
    EstiloUI.alinearDerecha(tblProductos, 3, 4);
}

private void limpiarCampos() {
    
    txtDescripcion.setText("");
    txtIdProducto.setText("");
    txtNombre.setText("");
    txtPrecio.setText("");
    txtStock.setText("");
    if (cboCategoria.getItemCount() > 0) {
        cboCategoria.setSelectedIndex(0);
    }

    txtNombre.requestFocus();
}

private Producto obtenerProductoFormulario() {
     Producto producto = new Producto();

    if (!txtIdProducto.getText().isEmpty()) {
        producto.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
    }

    producto.setNombre(txtNombre.getText().trim().replaceAll("\\s+", " "));
    producto.setDescripcion(txtDescripcion.getText().trim().replaceAll("\\s+", " "));
    producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
    producto.setStock(Integer.parseInt(txtStock.getText()));

    Categoria categoriaSeleccionada = (Categoria) cboCategoria.getSelectedItem();
    producto.setCategoria(categoriaSeleccionada);

    return producto;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        cboCategoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblProducto = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProductoActionPerformed(evt);
            }
        });

        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción", "Precio", "Categoria", "Stock"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblProducto.setText("ID Producto");

        lblNombre.setText("Nombre:");

        lblDescripcion.setText("Descripcion:");

        lblStock.setText("Stock:");

        lblPrecio.setText("Precio:");

        lblCategoria.setText("Categoria:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(139, 139, 139)
                            .addComponent(btnActualizar)
                            .addGap(18, 18, 18)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStock)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
      limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
            limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (Validaciones.campoVacio(txtNombre.getText())
        || Validaciones.campoVacio(txtPrecio.getText())
        || Validaciones.campoVacio(txtStock.getText())
        || cboCategoria.getSelectedItem() == null) {

    JOptionPane.showMessageDialog(this, "Complete los campos obligatorios");
    return;
}

if (!Validaciones.esDecimal(txtPrecio.getText())) {
    JOptionPane.showMessageDialog(this, "El precio debe ser un número válido");
    return;
}

if (!Validaciones.esEntero(txtStock.getText())) {
    JOptionPane.showMessageDialog(this, "El stock debe ser un número entero");
    return;
}

double precio = Double.parseDouble(txtPrecio.getText());
int stock = Integer.parseInt(txtStock.getText());

if (precio <= 0) {
    JOptionPane.showMessageDialog(this, "El precio debe ser mayor que cero");
    return;
}

if (stock < 0) {
    JOptionPane.showMessageDialog(this, "El stock no puede ser negativo");
    return;
}


if (productoDAO.existeNombre(txtNombre.getText().trim())) {
    JOptionPane.showMessageDialog(this, "Ya existe un producto con ese nombre");
    return;
}
        

    Producto producto = obtenerProductoFormulario();
    boolean registrado = productoDAO.registrar(producto);

    if (registrado) {
        JOptionPane.showMessageDialog(this, "Producto registrado correctamente");
        limpiarCampos();
        listarProductos();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo registrar el producto");
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
    if (txtIdProducto.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a buscar");
        return;
    }

    int idProducto;

    try {
        idProducto = Integer.parseInt(txtIdProducto.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El ID debe ser un número entero");
        return;
    }


    Producto producto = productoDAO.buscarPorId(idProducto);

    if (producto != null) {

        txtNombre.setText(producto.getNombre());
        txtDescripcion.setText(producto.getDescripcion());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtStock.setText(String.valueOf(producto.getStock()));

        for (int i = 0; i < cboCategoria.getItemCount(); i++) {

            Categoria categoria = cboCategoria.getItemAt(i);

            if (categoria.getIdCategoria() == producto.getCategoria().getIdCategoria()) {
                cboCategoria.setSelectedIndex(i);
                break;
            }
        }

        txtNombre.requestFocus();

    } else {
        JOptionPane.showMessageDialog(this, "No se encontró el producto");
        limpiarCampos();
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
 if (txtIdProducto.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Primero busque o seleccione un producto");
        return;
    }

    if (txtNombre.getText().isEmpty()
            || txtPrecio.getText().isEmpty()
            || txtStock.getText().isEmpty()
            || cboCategoria.getSelectedItem() == null) {

        JOptionPane.showMessageDialog(this, "Complete los campos obligatorios");
        return;
    }

    Producto producto = obtenerProductoFormulario();
int idProducto = Integer.parseInt(txtIdProducto.getText());
if (productoDAO.existeNombreEnOtroProducto(txtNombre.getText(), idProducto)) {
    JOptionPane.showMessageDialog(this, "Ya existe otro producto con ese nombre");
    return;
}
    boolean actualizado = productoDAO.actualizar(producto);

    if (actualizado) {
        JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
        limpiarCampos();
        listarProductos();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo actualizar el producto");
    }



    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
 if (txtIdProducto.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el ID del producto a eliminar");
        return;
    }
  int idProducto = Integer.parseInt(txtIdProducto.getText());
    if (productoDAO.tieneVentas(idProducto)) {
    JOptionPane.showMessageDialog(this, "No se puede eliminar el producto porque ya tiene ventas registradas");
    return;
}
 
    int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de eliminar este producto?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {


      
        boolean eliminado = productoDAO.eliminar(idProducto);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente");
            limpiarCampos();
            listarProductos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el producto");
        }
    }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        /*solo si se cierra el principal al entrar a productos*/
//            FrmPrincipal principal = new FrmPrincipal();
//    principal.setVisible(true);
//    principal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        
    int fila = tblProductos.getSelectedRow();

    if (fila >= 0) {

        txtIdProducto.setText(tblProductos.getValueAt(fila, 0).toString());
        txtNombre.setText(tblProductos.getValueAt(fila, 1).toString());
        txtDescripcion.setText(tblProductos.getValueAt(fila, 2).toString());
        txtPrecio.setText(tblProductos.getValueAt(fila, 3).toString());
        txtStock.setText(tblProductos.getValueAt(fila, 4).toString());

        String nombreCategoria = tblProductos.getValueAt(fila, 5).toString();

        for (int i = 0; i < cboCategoria.getItemCount(); i++) {

            Categoria categoria = cboCategoria.getItemAt(i);

            if (categoria.getNombreCategoria().equals(nombreCategoria)) {
                cboCategoria.setSelectedIndex(i);
                break;
            }
        }
    }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void txtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProductoActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<Categoria> cboCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblStock;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}

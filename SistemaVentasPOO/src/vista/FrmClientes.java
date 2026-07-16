
package vista;


import controlador.ClienteControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import util.Validaciones;
import util.EstiloUI;
public class FrmClientes extends javax.swing.JFrame {
    private final ClienteControlador clienteDAO = new ClienteControlador();

    public FrmClientes() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Gestion de Clientes");
        setMinimumSize(new java.awt.Dimension(900, 620));
        listarClientes();
    }
    private void listarClientes() {


    ArrayList<Cliente> lista = clienteDAO.listar();

    DefaultTableModel modeloTabla = new DefaultTableModel();

    modeloTabla.addColumn("ID");
    modeloTabla.addColumn("DNI");
    modeloTabla.addColumn("Nombres");
    modeloTabla.addColumn("Teléfono");
    modeloTabla.addColumn("Dirección");
    modeloTabla.addColumn("Correo");

    for (Cliente cliente : lista) {

        Object[] fila = new Object[6];

        fila[0] = cliente.getId();
        fila[1] = cliente.getDNI();
        fila[2] = cliente.getNombres();
        fila[3] = cliente.getTelefono();
        fila[4] = cliente.getDireccion();
        fila[5] = cliente.getCorreo();

        modeloTabla.addRow(fila);
    }

    tblClientes.setModel(modeloTabla);
    tblClientes.setModel(modeloTabla);

tblClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

tblClientes.getColumnModel().getColumn(0).setPreferredWidth(40);
tblClientes.getColumnModel().getColumn(1).setPreferredWidth(80);
tblClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
tblClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
tblClientes.getColumnModel().getColumn(4).setPreferredWidth(230);
tblClientes.getColumnModel().getColumn(5).setPreferredWidth(200);
EstiloUI.prepararTabla(tblClientes, 55, 90, 180, 110, 230, 220);
}
private void limpiarCampos() {

    txtIdCliente.setText("");
    txtDNI.setText("");
    txtNombres.setText("");
    txtTelefono.setText("");
    txtDireccion.setText("");
    txtCorreo.setText("");

    txtDNI.requestFocus();
}
private Cliente obtenerClienteFormulario(){
    Cliente cliente = new Cliente();
    if (!txtIdCliente.getText().isEmpty()) {
        cliente.setId(Integer.parseInt(txtIdCliente.getText()));
    }
    cliente.setDNI(txtDNI.getText().trim());
    cliente.setNombres(txtNombres.getText().trim().replaceAll("\\s+", " "));
    cliente.setDireccion(txtDireccion.getText().trim().replaceAll("\\s+", " "));
    cliente.setCorreo(txtCorreo.getText().trim().toLowerCase());
    cliente.setTelefono(txtTelefono.getText().trim());
    return cliente;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtIdCliente = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtIdCliente.setEditable(false);

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

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

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblCliente.setText("ID Cliente:");

        lblDNI.setText("DNI:");

        lblNombre.setText("Nombre:");

        lblTelefono.setText("Teléfono:");

        lblDireccion.setText("Dirección:");

        lblCorreo.setText("Correo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVolver))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                        .addComponent(btnActualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                            .addComponent(txtNombres))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                            .addComponent(txtCorreo))
                                        .addGap(22, 22, 22)))
                                .addGap(0, 16, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente)
                    .addComponent(lblNombre)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDNI)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualizar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnVolver)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
    if (Validaciones.campoVacio(txtDNI.getText())
            || Validaciones.campoVacio(txtNombres.getText())
            || Validaciones.campoVacio(txtTelefono.getText())
            || Validaciones.campoVacio(txtCorreo.getText())) {

        JOptionPane.showMessageDialog(this, "Complete los campos obligatorios");
        return;
    }

        if (!Validaciones.esDNIValido(txtDNI.getText())) {
        JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos numéricos");
        return;
    }

    if (!Validaciones.esTelefonoValido(txtTelefono.getText())) {
        JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos numéricos");
        return;
    }

    if (!Validaciones.esCorreoValido(txtCorreo.getText())) {
        JOptionPane.showMessageDialog(this, "Ingrese un correo válido");
        return;
    }

            Cliente cliente = obtenerClienteFormulario();
           
            
 if (clienteDAO.existeDNI(txtDNI.getText())) {
        JOptionPane.showMessageDialog(this, "Ya existe un cliente con ese DNI");
        return;
    }

    if (clienteDAO.existeTelefono(txtTelefono.getText())) {
        JOptionPane.showMessageDialog(this, "Ya existe un cliente con ese teléfono");
        return;
    }

    if (clienteDAO.existeCorreo(txtCorreo.getText())) {
        JOptionPane.showMessageDialog(this, "Ya existe un cliente con ese correo");
        return;
    }
 boolean registrado = clienteDAO.registrar(cliente);
            
            if (registrado) {
                JOptionPane.showMessageDialog(this, "Cliente registrado correctamente");
                limpiarCampos();
                listarClientes();
        }else{
                JOptionPane.showMessageDialog(this, "No se pudo registrar Cliente");
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        /*Busqueda por DNI*/
        if (txtDNI.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese el DNI del cliente");
            return;
        }
        if (!Validaciones.esNombreValido(txtNombres.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre válido");
            txtNombres.requestFocus();
            return;
        }
            String dni = txtDNI.getText();
            Cliente cliente = clienteDAO.buscarPorDni(dni);
            if (cliente!=null) {
             txtIdCliente.setText(String.valueOf(cliente.getId()));
             txtNombres.setText(cliente.getNombres());
             txtDNI.setText(cliente.getDNI());
             txtDireccion.setText(cliente.getDireccion());
             txtCorreo.setText(cliente.getCorreo());
             txtTelefono.setText(cliente.getTelefono());
        }else{
                JOptionPane.showMessageDialog(this, "No se encontro el Cliente");
            }
            
            
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        
    if (txtIdCliente.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Primero busque o seleccione un cliente");
        return;
    }

    if (txtDNI.getText().isEmpty()
            || txtNombres.getText().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Complete los campos obligatorios");
        return;
    }
    if (!Validaciones.esDNIValido(txtDNI.getText())) {
        JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos numéricos");
        txtDNI.requestFocus();
        return;
    }
    if (!Validaciones.esNombreValido(txtNombres.getText())) {
        JOptionPane.showMessageDialog(this, "Ingrese un nombre válido");
        txtNombres.requestFocus();
        return;
    }
    if (!Validaciones.esTelefonoValido(txtTelefono.getText())) {
        JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos numéricos");
        txtTelefono.requestFocus();
        return;
    }
    if (!Validaciones.esCorreoValido(txtCorreo.getText())) {
        JOptionPane.showMessageDialog(this, "Ingrese un correo válido");
        txtCorreo.requestFocus();
        return;
    }
int idCliente = Integer.parseInt(txtIdCliente.getText());


if (clienteDAO.existeDNIEnOtroCliente(txtDNI.getText(), idCliente)) {
    JOptionPane.showMessageDialog(this, "Ya existe otro cliente con ese DNI");
    return;
}

if (clienteDAO.existeTelefonoEnOtroCliente(txtTelefono.getText(), idCliente)) {
    JOptionPane.showMessageDialog(this, "Ya existe otro cliente con ese teléfono");
    return;
}

if (clienteDAO.existeCorreoEnOtroCliente(txtCorreo.getText(), idCliente)) {
    JOptionPane.showMessageDialog(this, "Ya existe otro cliente con ese correo");
    return;
}
    Cliente cliente = obtenerClienteFormulario();
    boolean actualizado = clienteDAO.actualizar(cliente);

    if (actualizado) {
        JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente");
        limpiarCampos();
        listarClientes();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo actualizar el cliente");
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
           if (txtIdCliente.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Primero busque o seleccione un cliente");
        return;
    }

    int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de eliminar este cliente?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {

        int idCliente = Integer.parseInt(txtIdCliente.getText());


        boolean eliminado = clienteDAO.eliminar(idCliente);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
            limpiarCampos();
            listarClientes();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el cliente");
        }
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
 int fila = tblClientes.getSelectedRow();

    if (fila >= 0) {

        txtIdCliente.setText(tblClientes.getValueAt(fila, 0).toString());
        txtDNI.setText(tblClientes.getValueAt(fila, 1).toString());
        txtNombres.setText(tblClientes.getValueAt(fila, 2).toString());
        txtTelefono.setText(tblClientes.getValueAt(fila, 3).toString());
        txtDireccion.setText(tblClientes.getValueAt(fila, 4).toString());
        txtCorreo.setText(tblClientes.getValueAt(fila, 5).toString());
    }
    }//GEN-LAST:event_tblClientesMouseClicked

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

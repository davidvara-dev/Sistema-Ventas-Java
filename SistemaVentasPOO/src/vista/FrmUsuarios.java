package vista;

import controlador.UsuarioControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.EstiloUI;
import modelo.Usuario;
import util.Validaciones;

public class FrmUsuarios extends javax.swing.JFrame {
    private final UsuarioControlador usuarioDAO = new UsuarioControlador();
    private int idUsuarioActual;

    public FrmUsuarios() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Gestión de Usuarios");
        setMinimumSize(new java.awt.Dimension(880, 650));
        listarUsuarios();
    }

    public FrmUsuarios(Usuario usuarioActual) {
        this();
        this.idUsuarioActual = usuarioActual == null ? 0 : usuarioActual.getId();
    }

    public void listarUsuarios() {
        ArrayList<Usuario> lista = usuarioDAO.listar();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombres");
        modelo.addColumn("Telefono");
        modelo.addColumn("Usuarios");
        modelo.addColumn("Rol");

        for (Usuario usuario : lista) {
            Object[] fila = new Object[6];
            fila[0] = usuario.getId();
            fila[1] = usuario.getDNI();
            fila[2] = usuario.getNombres();
            fila[3] = usuario.getTelefono();
            fila[4] = usuario.getUsuario();
            fila[5] = usuario.getRol();
            modelo.addRow(fila);
        }
        tblUsuarios.setModel(modelo);
        EstiloUI.prepararTabla(tblUsuarios, 55, 90, 180, 110, 130, 110);
    }

    public void limpiarCampos() {
        txtIdUsuario.setText("");
        txtNombre.setText("");
        txtDni.setText("");
        txtUsuario.setText("");
        txtTelefono.setText("");
        txtPassword.setText("");

        if (cboRol.getItemCount() > 0) {
            cboRol.setSelectedIndex(0);

        }
        txtDni.requestFocusInWindow();
    }

    private Usuario obtenerUsuarioFormulario() {
        Usuario usuario = new Usuario();

        if (!txtIdUsuario.getText().isEmpty()) {
            usuario.setId(Integer.parseInt(txtIdUsuario.getText()));
        }
        usuario.setDNI(txtDni.getText().trim());
        usuario.setNombres(txtNombre.getText().trim());
        usuario.setTelefono(txtTelefono.getText().trim());
        usuario.setUsuario(txtUsuario.getText().trim());
        usuario.setPassword(String.valueOf(txtPassword.getPassword()));
        usuario.setRol(cboRol.getSelectedItem().toString());
        return usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPasswword = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        cboRol = new javax.swing.JComboBox<>();
        txtIdUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUsuario.setText("Usuario: ");

        lblTelefono.setText("Teléfono: ");

        lblNombre.setText("Nombre: ");

        lblPasswword.setText("Password: ");

        lblDni.setText("DNI: ");

        lblRol.setText("Rol: ");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        cboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtUsuario))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(95, 95, 95)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNuevo)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnGuardar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnActualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminar)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDni, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPasswword, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(421, 421, 421))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (Validaciones.campoVacio(txtDni.getText())
                || Validaciones.campoVacio(txtUsuario.getText())
                || Validaciones.campoVacio(txtNombre.getText())
                || Validaciones.campoVacio(txtTelefono.getText())
                || Validaciones.campoVacio(String.valueOf(txtPassword.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos obligatorios");
            return;
        }

 if (!Validaciones.esDNIValido(txtDni.getText())) {
        JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos numéricos");
        return;
    }

    if (!Validaciones.esTelefonoValido(txtTelefono.getText())) {
        JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos numéricos");
        return;
    }
    if (!Validaciones.esNombreValido(txtNombre.getText())) {
        JOptionPane.showMessageDialog(this, "Ingrese un nombre válido");
        txtNombre.requestFocus();
        return;
    }
    if (!Validaciones.esUsuarioValido(txtUsuario.getText())) {
        JOptionPane.showMessageDialog(this, "El usuario debe tener 4 a 50 caracteres y no contener espacios");
        txtUsuario.requestFocus();
        return;
    }
    if (!Validaciones.esPasswordValido(String.valueOf(txtPassword.getPassword()))) {
        JOptionPane.showMessageDialog(this, "La contraseña debe tener entre 4 y 50 caracteres");
        txtPassword.requestFocus();
        return;
    }


    if (usuarioDAO.existeDNI(txtDni.getText())) {
        JOptionPane.showMessageDialog(this, "Ya existe un usuario con ese DNI");
        return;
    }

    if (usuarioDAO.existeTelefono(txtTelefono.getText())) {
        JOptionPane.showMessageDialog(this, "Ya existe un usuario con ese teléfono");
        return;
    }

    if (usuarioDAO.existeUsuario(txtUsuario.getText())) {
        JOptionPane.showMessageDialog(this, "Ya existe ese nombre de usuario");
        return;
    }
    txtIdUsuario.setText("");
    Usuario usuario = obtenerUsuarioFormulario();

    boolean registrado = usuarioDAO.registrar(usuario);

    if (registrado) {
        JOptionPane.showMessageDialog(this, "Usuario registrado correctamente");
        limpiarCampos();
        listarUsuarios();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo registrar el usuario");
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
 if (txtIdUsuario.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el ID del usuario");
        return;
    }

    int idUsuario = Integer.parseInt(txtIdUsuario.getText());
    if (idUsuario == idUsuarioActual) {
        JOptionPane.showMessageDialog(this, "No puede eliminar el usuario que tiene la sesión activa");
        return;
    }
    if (usuarioDAO.tieneVentas(idUsuario)) {
        JOptionPane.showMessageDialog(this, "No se puede eliminar el usuario porque tiene ventas registradas");
        return;
    }


    Usuario usuario = usuarioDAO.buscarPorId(idUsuario);

    if (usuario != null) {

        txtIdUsuario.setText(String.valueOf(usuario.getId()));
        txtDni.setText(usuario.getDNI());
        txtNombre.setText(usuario.getNombres());
        txtTelefono.setText(usuario.getTelefono());
        txtUsuario.setText(usuario.getUsuario());
        txtPassword.setText(usuario.getPassword());
        cboRol.setSelectedItem(usuario.getRol());

        txtNombre.requestFocus();

    } else {
        JOptionPane.showMessageDialog(this, "No se encontró el usuario");
    }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
      
        if (txtIdUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Primero busque o seleccione un usuario");
            return;
        }
        if (Validaciones.campoVacio(txtTelefono.getText().trim())
                ||Validaciones.campoVacio(txtUsuario.getText().trim())
                ||Validaciones.campoVacio(txtDni.getText().trim())
                ||Validaciones.campoVacio(txtNombre.getText().trim())
                ||Validaciones.campoVacio(String.valueOf(txtPassword.getPassword()))
              
                ) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos obligatorios");
            return;
        }
        if (!Validaciones.esDNIValido(txtDni.getText())) {
            JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos numéricos");
            return;
        }
        if (!Validaciones.esTelefonoValido(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos numéricos");
            return;
        }
        if (!Validaciones.esNombreValido(txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre válido");
            txtNombre.requestFocus();
            return;
        }
        if (!Validaciones.esUsuarioValido(txtUsuario.getText())) {
            JOptionPane.showMessageDialog(this, "El usuario debe tener 4 a 50 caracteres y no contener espacios");
            txtUsuario.requestFocus();
            return;
        }
        if (!Validaciones.esPasswordValido(String.valueOf(txtPassword.getPassword()))) {
            JOptionPane.showMessageDialog(this, "La contraseña debe tener entre 4 y 50 caracteres");
            txtPassword.requestFocus();
            return;
        }
        int idUsuario = Integer.parseInt(txtIdUsuario.getText());
 if (usuarioDAO.existeDNIEnOtroUsuario(txtDni.getText(), idUsuario)) {
        JOptionPane.showMessageDialog(this, "Ya existe otro usuario con ese DNI");
        return;
    }

    if (usuarioDAO.existeTelefonoEnOtroUsuario(txtTelefono.getText(), idUsuario)) {
        JOptionPane.showMessageDialog(this, "Ya existe otro usuario con ese teléfono");
        return;
    }

    if (usuarioDAO.existeUsuarioEnOtroUsuario(txtUsuario.getText(), idUsuario)) {
        JOptionPane.showMessageDialog(this, "Ya existe otro usuario con ese nombre de usuario");
        return;
    }

    Usuario usuario = obtenerUsuarioFormulario();

    boolean actualizado = usuarioDAO.actualizar(usuario);

    if (actualizado) {
        JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente");
        limpiarCampos();
        listarUsuarios();
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo actualizar el usuario");
    }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
 if (txtIdUsuario.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el ID del usuario a eliminar");
        return;
    }

    int idUsuario = Integer.parseInt(txtIdUsuario.getText());

    int respuesta = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de eliminar este usuario?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
    );

    if (respuesta == JOptionPane.YES_OPTION) {


        boolean eliminado = usuarioDAO.eliminar(idUsuario);

        if (eliminado) {
            JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
            limpiarCampos();
            listarUsuarios();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el usuario");
        }
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
                
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
     this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked

    int fila = tblUsuarios.getSelectedRow();

    if (fila >= 0) {

        txtIdUsuario.setText(tblUsuarios.getValueAt(fila, 0).toString());
        txtDni.setText(tblUsuarios.getValueAt(fila, 1).toString());
        txtNombre.setText(tblUsuarios.getValueAt(fila, 2).toString());
        txtTelefono.setText(tblUsuarios.getValueAt(fila, 3).toString());
        txtUsuario.setText(tblUsuarios.getValueAt(fila, 4).toString());
        cboRol.setSelectedItem(tblUsuarios.getValueAt(fila, 5).toString());

        Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(txtIdUsuario.getText()));

        if (usuario != null) {
            txtPassword.setText(usuario.getPassword());
        }
    }

    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuarios().setVisible(true);
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
    private javax.swing.JComboBox<String> cboRol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPasswword;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

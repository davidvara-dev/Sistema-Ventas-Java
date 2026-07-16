package vista;

import controlador.CategoriaControlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import util.EstiloUI;
import util.ResultadoOperacion;

public class FrmCategorias extends javax.swing.JFrame {
    private final CategoriaControlador controlador = new CategoriaControlador();
    private DefaultTableModel modeloTabla;

    public FrmCategorias() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Gestión de Categorías");
        prepararTabla();
        listarCategorias();
        limpiarFormulario();
    }

    private void prepararTabla() {
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre de categoría"}, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        tblCategorias.setModel(modeloTabla);
        EstiloUI.prepararTabla(tblCategorias, 70, 610);
    }

    private void listarCategorias() {
        modeloTabla.setRowCount(0);
        ArrayList<Categoria> categorias = controlador.listar();
        for (Categoria categoria : categorias) {
            modeloTabla.addRow(new Object[]{categoria.getIdCategoria(), categoria.getNombreCategoria()});
        }
        EstiloUI.estado(lblEstado, categorias.size() + " categoría(s) registrada(s).", EstiloUI.GRIS);
    }

    private void limpiarFormulario() {
        txtIdCategoria.setText("");
        txtNombre.setText("");
        tblCategorias.clearSelection();
        txtNombre.requestFocus();
    }

    private int idSeleccionado() {
        return txtIdCategoria.getText().isBlank() ? 0 : Integer.parseInt(txtIdCategoria.getText());
    }

    private void mostrarResultado(ResultadoOperacion<?> resultado) {
        EstiloUI.estado(lblEstado, resultado.getMensaje(),
                resultado.isExitoso() ? EstiloUI.VERDE : EstiloUI.ROJO);
        if (!resultado.isExitoso()) txtNombre.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtIdCategoria = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        pnlAcciones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        scrCategorias = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(760, 500));
        setPreferredSize(new java.awt.Dimension(760, 500));

        pnlTitulo.setBackground(new Color(28, 78, 121));
        pnlTitulo.setLayout(new FlowLayout(FlowLayout.LEFT, 24, 15));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setText("Gestión de Categorías");
        pnlTitulo.add(lblTitulo);

        pnlDatos.setBorder(BorderFactory.createTitledBorder("Datos de la categoría"));
        pnlDatos.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        lblId.setText("ID:");
        pnlDatos.add(lblId, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.15;
        txtIdCategoria.setEditable(false);
        txtIdCategoria.setBackground(new Color(238, 238, 238));
        pnlDatos.add(txtIdCategoria, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0;
        lblNombre.setText("Nombre:");
        pnlDatos.add(lblNombre, gbc);
        gbc.gridx = 3;
        gbc.weightx = 0.85;
        txtNombre.setColumns(28);
        pnlDatos.add(txtNombre, gbc);

        pnlAcciones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(evt -> btnNuevoActionPerformed(evt));
        btnGuardar.setText("Guardar");
        btnGuardar.setBackground(EstiloUI.VERDE);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.addActionListener(evt -> btnGuardarActionPerformed(evt));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(evt -> btnActualizarActionPerformed(evt));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBackground(EstiloUI.ROJO);
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.addActionListener(evt -> btnEliminarActionPerformed(evt));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(evt -> btnVolverActionPerformed(evt));
        pnlAcciones.add(btnNuevo);
        pnlAcciones.add(btnGuardar);
        pnlAcciones.add(btnActualizar);
        pnlAcciones.add(btnEliminar);
        pnlAcciones.add(btnVolver);

        tblCategorias.setModel(new DefaultTableModel(
                new Object[][]{}, new String[]{"ID", "Nombre de categoría"}));
        tblCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriasMouseClicked(evt);
            }
        });
        scrCategorias.setViewportView(tblCategorias);
        lblEstado.setText(" ");

        JPanel contenido = new JPanel(new BorderLayout(0, 8));
        contenido.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        contenido.add(pnlDatos, BorderLayout.NORTH);
        contenido.add(scrCategorias, BorderLayout.CENTER);
        JPanel inferior = new JPanel(new BorderLayout());
        inferior.add(pnlAcciones, BorderLayout.NORTH);
        inferior.add(lblEstado, BorderLayout.SOUTH);
        contenido.add(inferior, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(contenido, BorderLayout.CENTER);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarFormulario();
        EstiloUI.estado(lblEstado, "Ingrese los datos de la nueva categoría.", EstiloUI.GRIS);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ResultadoOperacion<Categoria> resultado = controlador.registrar(txtNombre.getText());
        mostrarResultado(resultado);
        if (resultado.isExitoso()) { listarCategorias(); limpiarFormulario(); }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ResultadoOperacion<Categoria> resultado = controlador.actualizar(idSeleccionado(), txtNombre.getText());
        mostrarResultado(resultado);
        if (resultado.isExitoso()) { listarCategorias(); limpiarFormulario(); }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int id = idSeleccionado();
        if (id <= 0) { mostrarResultado(ResultadoOperacion.error("Seleccione una categoría.")); return; }
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea eliminar la categoría seleccionada?", "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            ResultadoOperacion<Void> resultado = controlador.eliminar(id);
            mostrarResultado(resultado);
            if (resultado.isExitoso()) { listarCategorias(); limpiarFormulario(); }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void tblCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriasMouseClicked
        int fila = tblCategorias.getSelectedRow();
        if (fila >= 0) {
            int indiceModelo = tblCategorias.convertRowIndexToModel(fila);
            txtIdCategoria.setText(modeloTabla.getValueAt(indiceModelo, 0).toString());
            txtNombre.setText(modeloTabla.getValueAt(indiceModelo, 1).toString());
            EstiloUI.estado(lblEstado, "Categoría seleccionada.", EstiloUI.GRIS);
        }
    }//GEN-LAST:event_tblCategoriasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrCategorias;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

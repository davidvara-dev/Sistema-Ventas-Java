package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public final class EstiloUI {
    public static final Color AZUL = new Color(28, 78, 121);
    public static final Color VERDE = new Color(38, 125, 82);
    public static final Color ROJO = new Color(176, 50, 50);
    public static final Color GRIS = new Color(90, 98, 108);

    private EstiloUI() { }

    public static void prepararTabla(JTable tabla, int... anchos) {
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setRowHeight(25);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setAutoCreateRowSorter(true);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.getTableHeader().setFont(tabla.getTableHeader().getFont().deriveFont(Font.BOLD));
        TableColumnModel columnas = tabla.getColumnModel();
        for (int i = 0; i < anchos.length && i < columnas.getColumnCount(); i++) {
            columnas.getColumn(i).setMinWidth(Math.min(anchos[i], 60));
            columnas.getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    public static void alinearDerecha(JTable tabla, int... columnas) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int columna : columnas) {
            if (columna >= 0 && columna < tabla.getColumnCount()) {
                tabla.getColumnModel().getColumn(columna).setCellRenderer(renderer);
            }
        }
    }

    public static void estado(JLabel etiqueta, String mensaje, Color color) {
        etiqueta.setText(mensaje);
        etiqueta.setForeground(color);
    }

    public static void resaltarError(Component componente) {
        if (componente instanceof javax.swing.JComponent jComponent) {
            jComponent.setBackground(new Color(255, 235, 235));
            jComponent.requestFocus();
        }
    }
}

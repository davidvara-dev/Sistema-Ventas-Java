package app;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import vista.FrmLogin;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        aplicarApariencia();
        SwingUtilities.invokeLater(() -> new FrmLogin().setVisible(true));
    }

    private static void aplicarApariencia() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo aplicar la apariencia Nimbus: " + e.getMessage());
        }
    }
}

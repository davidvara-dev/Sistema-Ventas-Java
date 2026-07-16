package prueba;

import dao.UsuarioDAO;
import modelo.Usuario;

public class PruebaUsuarioDAO {

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario = dao.validarLogin("admin", "1234");

        if (usuario != null) {
            System.out.println("Login correcto");
            System.out.println("Bienvenido: " + usuario.getNombres());
            System.out.println("Rol: " + usuario.getRol());
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
    }
}

package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;
import util.ResultadoOperacion;

public class LoginControlador {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public ResultadoOperacion<Usuario> autenticar(String nombreUsuario, String password) {
        String usuario = nombreUsuario == null ? "" : nombreUsuario.trim();
        if (usuario.isEmpty() || password == null || password.isBlank()) {
            return ResultadoOperacion.error("Complete el usuario y la contraseña.");
        }
        Usuario encontrado = usuarioDAO.validarLogin(usuario, password);
        return encontrado == null
                ? ResultadoOperacion.error("Usuario o contraseña incorrectos.")
                : ResultadoOperacion.exito("Bienvenido, " + encontrado.getNombres(), encontrado);
    }
}

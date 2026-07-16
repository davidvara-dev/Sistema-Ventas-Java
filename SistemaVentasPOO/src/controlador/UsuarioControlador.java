package controlador;

import dao.UsuarioDAO;
import java.util.ArrayList;
import modelo.Usuario;

public class UsuarioControlador {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    public ArrayList<Usuario> listar() { return usuarioDAO.listar(); }
    public Usuario buscarPorId(int id) { return usuarioDAO.buscarPorId(id); }
    public boolean registrar(Usuario usuario) { return usuarioDAO.registrar(usuario); }
    public boolean actualizar(Usuario usuario) { return usuarioDAO.actualizar(usuario); }
    public boolean eliminar(int id) { return usuarioDAO.eliminar(id); }
    public boolean existeUsuario(String nombre) { return usuarioDAO.existeUsuario(nombre); }
    public boolean existeDNI(String dni) { return usuarioDAO.existeDNI(dni); }
    public boolean existeTelefono(String telefono) { return usuarioDAO.existeTelefono(telefono); }
    public boolean existeUsuarioEnOtroUsuario(String nombre, int id) { return usuarioDAO.existeUsuarioEnOtroUsuario(nombre, id); }
    public boolean existeDNIEnOtroUsuario(String dni, int id) { return usuarioDAO.existeDNIEnOtroUsuario(dni, id); }
    public boolean existeTelefonoEnOtroUsuario(String telefono, int id) { return usuarioDAO.existeTelefonoEnOtroUsuario(telefono, id); }
    public boolean tieneVentas(int id) { return usuarioDAO.usuarioTieneVentas(id); }
}

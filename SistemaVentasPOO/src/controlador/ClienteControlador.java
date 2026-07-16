package controlador;

import dao.ClienteDAO;
import java.util.ArrayList;
import modelo.Cliente;

public class ClienteControlador {
    private final ClienteDAO clienteDAO = new ClienteDAO();
    public ArrayList<Cliente> listar() { return clienteDAO.listar(); }
    public Cliente buscarPorDni(String dni) { return clienteDAO.buscarPorDni(dni == null ? "" : dni.trim()); }
    public boolean registrar(Cliente cliente) { return clienteDAO.registrar(cliente); }
    public boolean actualizar(Cliente cliente) { return clienteDAO.actualizar(cliente); }
    public boolean eliminar(int id) { return clienteDAO.eliminar(id); }
    public boolean existeDNI(String dni) { return clienteDAO.existeDNI(dni); }
    public boolean existeTelefono(String telefono) { return clienteDAO.existeTelefono(telefono); }
    public boolean existeCorreo(String correo) { return clienteDAO.existeCorreo(correo); }
    public boolean existeDNIEnOtroCliente(String dni, int id) { return clienteDAO.existeDNIEnOtroCliente(dni, id); }
    public boolean existeTelefonoEnOtroCliente(String telefono, int id) { return clienteDAO.existeTelefonoEnOtroCliente(telefono, id); }
    public boolean existeCorreoEnOtroCliente(String correo, int id) { return clienteDAO.existeCorreoEnOtroCliente(correo, id); }
}

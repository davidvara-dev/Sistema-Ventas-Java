package controlador;

import dao.ClienteDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;

public class VentaControlador {
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final ProductoDAO productoDAO = new ProductoDAO();
    private final VentaDAO ventaDAO = new VentaDAO();
    public Cliente buscarCliente(String dni) { return clienteDAO.buscarPorDni(dni == null ? "" : dni.trim()); }
    public Producto buscarProducto(int id) { return productoDAO.buscarPorId(id); }
    public boolean registrar(Venta venta, ArrayList<DetalleVenta> detalles) { return ventaDAO.registrarVenta(venta, detalles); }
    public ArrayList<Venta> listar() { return ventaDAO.listarVentas(); }
}

package controlador;

import dao.ClienteDAO;
import dao.DetalleVentaDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;

public class ReporteControlador {
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final ProductoDAO productoDAO = new ProductoDAO();
    private final VentaDAO ventaDAO = new VentaDAO();
    private final DetalleVentaDAO detalleVentaDAO = new DetalleVentaDAO();
    public ArrayList<Cliente> clientes() { return clienteDAO.listar(); }
    public ArrayList<Producto> productos() { return productoDAO.listar(); }
    public ArrayList<Venta> ventas() { return ventaDAO.listarVentas(); }
    public ArrayList<DetalleVenta> detalles(int idVenta) { return detalleVentaDAO.listarPorVenta(idVenta); }
}

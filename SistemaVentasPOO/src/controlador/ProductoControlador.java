package controlador;

import dao.CategoriaDAO;
import dao.ProductoDAO;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Producto;

public class ProductoControlador {
    private final ProductoDAO productoDAO = new ProductoDAO();
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    public ArrayList<Producto> listar() { return productoDAO.listar(); }
    public ArrayList<Categoria> listarCategorias() { return categoriaDAO.listar(); }
    public Producto buscarPorId(int id) { return productoDAO.buscarPorId(id); }
    public boolean registrar(Producto producto) { return productoDAO.registrar(producto); }
    public boolean actualizar(Producto producto) { return productoDAO.actualizar(producto); }
    public boolean eliminar(int id) { return productoDAO.eliminar(id); }
    public boolean existeNombre(String nombre) { return productoDAO.existeNombre(nombre); }
    public boolean existeNombreEnOtroProducto(String nombre, int id) { return productoDAO.existeNombreEnOtroProducto(nombre, id); }
    public boolean tieneVentas(int id) { return productoDAO.productoTieneVentas(id); }
}

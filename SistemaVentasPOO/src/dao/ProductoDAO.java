package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Producto;

public class ProductoDAO {

    public boolean registrar(Producto producto) {

        boolean registrado = false;

        String sql = "INSERT INTO productos (nombre, descripcion, precio, stock, idCategoria) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getCategoria().getIdCategoria());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                registrado = true;
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al registrar producto");
            System.out.println("Error: " + e.getMessage());
        }

        return registrado;
    }

    public boolean actualizar(Producto producto) {

        boolean actualizado = false;

        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, stock = ?, idCategoria = ? "
                   + "WHERE idProducto = ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getCategoria().getIdCategoria());
            ps.setInt(6, producto.getIdProducto());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                actualizado = true;
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto");
            System.out.println("Error: " + e.getMessage());
        }

        return actualizado;
    }

    public boolean eliminar(int idProducto) {

        boolean eliminado = false;

        String sql = "DELETE FROM productos WHERE idProducto = ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idProducto);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                eliminado = true;
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar producto");
            System.out.println("Error: " + e.getMessage());
        }

        return eliminado;
    }

    public ArrayList<Producto> listar() {

        ArrayList<Producto> lista = new ArrayList<>();

        String sql = "SELECT p.idProducto, p.nombre, p.descripcion, p.precio, p.stock, "
                   + "c.idCategoria, c.nombreCategoria "
                   + "FROM productos p "
                   + "INNER JOIN categorias c ON p.idCategoria = c.idCategoria";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombreCategoria(rs.getString("nombreCategoria"));

                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(categoria);

                lista.add(producto);
            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al listar productos");
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

    public Producto buscarPorId(int idProducto) {

        Producto productoEncontrado = null;

        String sql = "SELECT p.idProducto, p.nombre, p.descripcion, p.precio, p.stock, "
                   + "c.idCategoria, c.nombreCategoria "
                   + "FROM productos p "
                   + "INNER JOIN categorias c ON p.idCategoria = c.idCategoria "
                   + "WHERE p.idProducto = ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idProducto);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombreCategoria(rs.getString("nombreCategoria"));

                productoEncontrado = new Producto();
                productoEncontrado.setIdProducto(rs.getInt("idProducto"));
                productoEncontrado.setNombre(rs.getString("nombre"));
                productoEncontrado.setDescripcion(rs.getString("descripcion"));
                productoEncontrado.setPrecio(rs.getDouble("precio"));
                productoEncontrado.setStock(rs.getInt("stock"));
                productoEncontrado.setCategoria(categoria);
            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar producto por ID");
            System.out.println("Error: " + e.getMessage());
        }

        return productoEncontrado;
    }

    public Producto buscarPorNombre(String nombre) {

        Producto productoEncontrado = null;

        String sql = "SELECT p.idProducto, p.nombre, p.descripcion, p.precio, p.stock, "
                   + "c.idCategoria, c.nombreCategoria "
                   + "FROM productos p "
                   + "INNER JOIN categorias c ON p.idCategoria = c.idCategoria "
                   + "WHERE p.nombre LIKE ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombreCategoria(rs.getString("nombreCategoria"));

                productoEncontrado = new Producto();
                productoEncontrado.setIdProducto(rs.getInt("idProducto"));
                productoEncontrado.setNombre(rs.getString("nombre"));
                productoEncontrado.setDescripcion(rs.getString("descripcion"));
                productoEncontrado.setPrecio(rs.getDouble("precio"));
                productoEncontrado.setStock(rs.getInt("stock"));
                productoEncontrado.setCategoria(categoria);
            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar producto por nombre");
            System.out.println("Error: " + e.getMessage());
        }

        return productoEncontrado;
    }

    public boolean actualizarStock(int idProducto, int nuevoStock) {

        boolean actualizado = false;

        String sql = "UPDATE productos SET stock = ? WHERE idProducto = ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, nuevoStock);
            ps.setInt(2, idProducto);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                actualizado = true;
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar stock");
            System.out.println("Error: " + e.getMessage());
        }

        return actualizado;
    }

    public boolean descontarStock(Connection cn, int idProducto, int cantidad) throws SQLException {
        String sql = "UPDATE productos SET stock = stock - ? "
                + "WHERE idProducto = ? AND stock >= ?";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, cantidad);
        ps.setInt(2, idProducto);
        ps.setInt(3, cantidad);
        boolean actualizado = ps.executeUpdate() > 0;
        ps.close();
        return actualizado;
    }
    
    public boolean existeNombre(String nombre) {

    boolean existe = false;

    String sql = "SELECT idProducto FROM productos WHERE nombre = ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar nombre de producto");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}
    public boolean productoTieneVentas(int idProducto) {

    boolean tieneVentas = false;

    String sql = "SELECT idDetalle FROM detalle_venta WHERE idProducto = ? LIMIT 1";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idProducto);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            tieneVentas = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar ventas del producto");
        System.out.println("Error: " + e.getMessage());
    }

    return tieneVentas;
}
    
   public boolean existeNombreEnOtroProducto(String nombre, int idProducto) {

    boolean existe = false;

    String sql = "SELECT idProducto FROM productos WHERE nombre = ? AND idProducto <> ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setInt(2, idProducto);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar nombre en otro producto");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
} 
    
}

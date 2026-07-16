package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;

public class DetalleVentaDAO {

    public boolean registrar(DetalleVenta detalle) {

        boolean registrado = false;

        String sql = "INSERT INTO detalle_venta "
                   + "(idVenta, idProducto, cantidad, precioUnitario, subtotal) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setInt(1, detalle.getVenta().getIdVenta());
            ps.setInt(2, detalle.getProducto().getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnitario());
            ps.setDouble(5, detalle.getSubtotal());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                registrado = true;
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al registrar detalle de venta");
            System.out.println("Error: " + e.getMessage());
        }

        return registrado;
    }

    public boolean registrar(Connection cn, DetalleVenta detalle) throws SQLException {
        String sql = "INSERT INTO detalle_venta "
                + "(idVenta, idProducto, cantidad, precioUnitario, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, detalle.getVenta().getIdVenta());
        ps.setInt(2, detalle.getProducto().getIdProducto());
        ps.setInt(3, detalle.getCantidad());
        ps.setDouble(4, detalle.getPrecioUnitario());
        ps.setDouble(5, detalle.getSubtotal());
        boolean registrado = ps.executeUpdate() > 0;
        ps.close();
        return registrado;
    }
    
    public ArrayList<DetalleVenta> listarPorVenta(int idVenta) {

    ArrayList<DetalleVenta> lista = new ArrayList<>();

    String sql = "SELECT dv.idDetalle, dv.idVenta, dv.idProducto, dv.cantidad, "
            + "dv.precioUnitario, dv.subtotal, "
            + "p.nombre, p.descripcion, p.precio, p.stock, "
            + "c.idCategoria, c.nombreCategoria "
            + "FROM detalle_venta dv "
            + "INNER JOIN productos p ON dv.idProducto = p.idProducto "
            + "INNER JOIN categorias c ON p.idCategoria = c.idCategoria "
            + "WHERE dv.idVenta = ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idVenta);

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

            Venta venta = new Venta();
            venta.setIdVenta(rs.getInt("idVenta"));

            DetalleVenta detalle = new DetalleVenta();
            detalle.setIdDetalle(rs.getInt("idDetalle"));
            detalle.setVenta(venta);
            detalle.setProducto(producto);
            detalle.setCantidad(rs.getInt("cantidad"));
            detalle.setPrecioUnitario(rs.getDouble("precioUnitario"));
            detalle.setSubtotal(rs.getDouble("subtotal"));

            lista.add(detalle);
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al listar detalle de venta");
        System.out.println("Error: " + e.getMessage());
    }

    return lista;
}
}



package dao;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Usuario;
import modelo.Venta;

public class VentaDAO {
  public boolean registrarVenta(Venta venta, ArrayList<DetalleVenta> detalles) {
        String sqlVenta = "INSERT INTO ventas "
                + "(fecha, subtotal, igv, total, idCliente, idUsuario) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        Connection cn = null;
        PreparedStatement psVenta = null;
        ResultSet rs = null;
        try {
            Conexion conexionBD = new Conexion();
            cn = conexionBD.conectar();
            if (cn == null) return false;
            cn.setAutoCommit(false);
            psVenta = cn.prepareStatement(sqlVenta, PreparedStatement.RETURN_GENERATED_KEYS);
            psVenta.setString(1, venta.getFecha());
            psVenta.setDouble(2, venta.getSubtotal());
            psVenta.setDouble(3, venta.getIgv());
            psVenta.setDouble(4, venta.getTotal());
            psVenta.setInt(5, venta.getCliente().getId());
            psVenta.setInt(6, venta.getUsuario().getId());

            if (psVenta.executeUpdate() <= 0) throw new SQLException("No se insertó la venta");
            rs = psVenta.getGeneratedKeys();
            if (!rs.next()) throw new SQLException("No se obtuvo el ID de la venta");
            venta.setIdVenta(rs.getInt(1));

            DetalleVentaDAO detalleDAO = new DetalleVentaDAO();
            ProductoDAO productoDAO = new ProductoDAO();
            for (DetalleVenta detalle : detalles) {
                detalle.setVenta(venta);
                if (!detalleDAO.registrar(cn, detalle)) {
                    throw new SQLException("No se registró un detalle de venta");
                }
                if (!productoDAO.descontarStock(cn,
                        detalle.getProducto().getIdProducto(), detalle.getCantidad())) {
                    throw new SQLException("Stock insuficiente para " + detalle.getProducto().getNombre());
                }
            }
            cn.commit();
            rs.close();
            psVenta.close();
            cn.close();
            return true;
        } catch (SQLException e) {
            if (cn != null) {
                try { cn.rollback(); } catch (SQLException rollbackError) {
                    System.out.println("Error al revertir la venta: " + rollbackError.getMessage());
                }
            }
            try { if (rs != null) rs.close(); } catch (SQLException ignored) { }
            try { if (psVenta != null) psVenta.close(); } catch (SQLException ignored) { }
            try { if (cn != null) cn.close(); } catch (SQLException ignored) { }
            System.out.println("Error al registrar venta");
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
  
  public ArrayList<Venta> listarVentas() {

    ArrayList<Venta> lista = new ArrayList<>();

    String sql = "SELECT v.idVenta, v.fecha, v.subtotal, v.igv, v.total, "
            + "c.idCliente, c.dni, c.nombres, c.telefono, c.direccion, c.correo, "
            + "u.idUsuario, u.dni AS dniUsuario, u.nombres AS nombresUsuario, "
            + "u.telefono AS telefonoUsuario, u.usuario, u.rol "
            + "FROM ventas v "
            + "INNER JOIN clientes c ON v.idCliente = c.idCliente "
            + "INNER JOIN usuarios u ON v.idUsuario = u.idUsuario "
            + "ORDER BY v.idVenta DESC";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("idCliente"));
            cliente.setDNI(rs.getString("dni"));
            cliente.setNombres(rs.getString("nombres"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setDireccion(rs.getString("direccion"));
            cliente.setCorreo(rs.getString("correo"));

            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("idUsuario"));
            usuario.setDNI(rs.getString("dniUsuario"));
            usuario.setNombres(rs.getString("nombresUsuario"));
            usuario.setTelefono(rs.getString("telefonoUsuario"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setRol(rs.getString("rol"));

            Venta venta = new Venta();
            venta.setIdVenta(rs.getInt("idVenta"));
            venta.setFecha(rs.getString("fecha"));
            venta.setSubtotal(rs.getDouble("subtotal"));
            venta.setIgv(rs.getDouble("igv"));
            venta.setTotal(rs.getDouble("total"));
            venta.setCliente(cliente);
            venta.setUsuario(usuario);

            lista.add(venta);
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al listar ventas");
        System.out.println("Error: " + e.getMessage());
    }

    return lista;
}
}

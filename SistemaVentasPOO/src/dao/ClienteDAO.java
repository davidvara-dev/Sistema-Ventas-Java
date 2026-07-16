package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;

public class ClienteDAO {

    public boolean registrar(Cliente cliente) {

        boolean registrado = false;

        String sql = "INSERT INTO clientes (dni, nombres, telefono, direccion, correo) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, cliente.getDNI());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getCorreo());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                registrado = true;
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al registrar cliente");
            System.out.println("Error: " + e.getMessage());
        }

        return registrado;
    }

    public boolean actualizar(Cliente cliente) {

        boolean actualizado = false;

        String sql = "UPDATE clientes SET dni = ?, nombres = ?, telefono = ?, direccion = ?, correo = ? "
                   + "WHERE idCliente = ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, cliente.getDNI());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getCorreo());
            ps.setInt(6, cliente.getId());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                actualizado = true;
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente");
            System.out.println("Error: " + e.getMessage());
        }

        return actualizado;
    }

    public boolean eliminar(int idCliente) {

        boolean eliminado = false;

        String sql = "DELETE FROM clientes WHERE idCliente = ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idCliente);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                eliminado = true;
            }

            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente");
            System.out.println("Error: " + e.getMessage());
        }

        return eliminado;
    }

    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

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

                lista.add(cliente);
            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al listar clientes");
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

    public Cliente buscarPorDni(String dni) {

        Cliente clienteEncontrado = null;

        String sql = "SELECT * FROM clientes WHERE dni = ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                clienteEncontrado = new Cliente();

                clienteEncontrado.setId(rs.getInt("idCliente"));
                clienteEncontrado.setDNI(rs.getString("dni"));
                clienteEncontrado.setNombres(rs.getString("nombres"));
                clienteEncontrado.setTelefono(rs.getString("telefono"));
                clienteEncontrado.setDireccion(rs.getString("direccion"));
                clienteEncontrado.setCorreo(rs.getString("correo"));
            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por DNI");
            System.out.println("Error: " + e.getMessage());
        }

        return clienteEncontrado;
    }

    public Cliente buscarPorId(int idCliente) {

        Cliente clienteEncontrado = null;

        String sql = "SELECT * FROM clientes WHERE idCliente = ?";

        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idCliente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                clienteEncontrado = new Cliente();

                clienteEncontrado.setId(rs.getInt("idCliente"));
                clienteEncontrado.setDNI(rs.getString("dni"));
                clienteEncontrado.setNombres(rs.getString("nombres"));
                clienteEncontrado.setTelefono(rs.getString("telefono"));
                clienteEncontrado.setDireccion(rs.getString("direccion"));
                clienteEncontrado.setCorreo(rs.getString("correo"));
            }

            rs.close();
            ps.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por ID");
            System.out.println("Error: " + e.getMessage());
        }

        return clienteEncontrado;
    }
    
    public boolean existeDNI(String dni) {

    boolean existe = false;

    String sql = "SELECT idCliente FROM clientes WHERE dni = ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, dni);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar DNI");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}
    public boolean existeTelefono(String telefono) {

    boolean existe = false;

    String sql = "SELECT idCliente FROM clientes WHERE telefono = ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, telefono);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar teléfono");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}
    public boolean existeCorreo(String correo) {

    boolean existe = false;

    String sql = "SELECT idCliente FROM clientes WHERE correo = ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, correo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar correo");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}
    public boolean existeDNIEnOtroCliente(String dni, int idCliente) {

    boolean existe = false;

    String sql = "SELECT idCliente FROM clientes WHERE dni = ? AND idCliente <> ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, dni);
        ps.setInt(2, idCliente);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar DNI en otro cliente");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}
    /*codigo manualmente escrito*/
    public boolean existeTelefonoEnOtroCliente(String telefono, int idCliente) {

    boolean existe = false;

    String sql = "SELECT idCliente FROM clientes WHERE telefono = ? AND idCliente <> ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, telefono);
        ps.setInt(2, idCliente);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar telefono en otro cliente");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}
public boolean existeCorreoEnOtroCliente(String correo, int idCliente) {

    boolean existe = false;

    String sql = "SELECT idCliente FROM clientes WHERE correo = ? AND idCliente <> ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, correo);
        ps.setInt(2, idCliente);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar correo   en otro cliente");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}    
}
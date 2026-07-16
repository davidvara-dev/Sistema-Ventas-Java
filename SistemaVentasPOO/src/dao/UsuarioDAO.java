

package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;


public class UsuarioDAO {
    public Usuario validarLogin(String usuario, String password){
        Usuario usuarioEncontrado = null;
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ? ";
        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();
            
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuarioEncontrado = new Usuario();
                
                usuarioEncontrado.setId(rs.getInt("idUsuario"));
                usuarioEncontrado.setDNI(rs.getString("DNI"));
                usuarioEncontrado.setNombres("nombres");
                usuarioEncontrado.setTelefono(rs.getString("telefono"));
                usuarioEncontrado.setUsuario(rs.getString("usuario"));
                usuarioEncontrado.setPassword(rs.getString("password"));
                usuarioEncontrado.setRol(rs.getString("rol"));
                
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e){
            System.out.println("Error al validar Login");
            System.out.println("Error: " + e.getMessage());
        }
        return usuarioEncontrado;
    }
    
public boolean registrar(Usuario usuario){
    boolean registrado = false;
    String sql = "INSERT INTO usuarios (dni,nombres,telefono,usuario,password, rol)"
            + "VALUES (?,?,?,?,?,?)";
    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, usuario.getDNI());
        ps.setString(2, usuario.getNombres());
        ps.setString(3, usuario.getTelefono());
        ps.setString(4, usuario.getUsuario());
        ps.setString(5, usuario.getPassword());
        ps.setString(6, usuario.getRol());
        
        int filas = ps.executeUpdate();
        if(filas >0){
            registrado = true;
        }
        ps.close();
        cn.close();
    } catch (Exception e) {
        System.out.println("Error al registrar usuario");
        System.out.println("Error: " + e.getMessage());
    }
    return registrado;
}

public boolean actualizar(Usuario usuario){
    boolean actualizado = false;
    String sql = "UPDATE usuarios SET dni = ?, nombres=?, telefono =?, usuario = ?,"
            + "password=?, rol=?" + "WHERE idUsuario=?";
    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1,usuario.getDNI() );
        ps.setString(2,usuario.getNombres() );
        ps.setString(3, usuario.getTelefono() );
        ps.setString(4,usuario.getUsuario() );
        ps.setString(5, usuario.getPassword() );
        ps.setString(6,usuario.getRol() );
        ps.setInt(7, usuario.getId());
        int filas = ps.executeUpdate();
        if (filas >0) {
            actualizado=true;
        }
        ps.close();
        cn.close();
    } catch (Exception e) {
        System.out.println("Error al actualizar usuario");
        System.out.println("Error: " + e.getMessage());
    }
        return actualizado;
}

public boolean eliminar(int idUsuario) {

    boolean eliminado = false;

    String sql = "DELETE FROM usuarios WHERE idUsuario = ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idUsuario);

        int filas = ps.executeUpdate();

        if (filas > 0) {
            eliminado = true;
        }

        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al eliminar usuario");
        System.out.println("Error: " + e.getMessage());
    }

    return eliminado;
}

public ArrayList<Usuario> listar() {

    ArrayList<Usuario> lista = new ArrayList<>();

    String sql = "SELECT * FROM usuarios";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Usuario usuario = new Usuario();

            usuario.setId(rs.getInt("idUsuario"));
            usuario.setDNI(rs.getString("dni"));
            usuario.setNombres(rs.getString("nombres"));
            usuario.setTelefono(rs.getString("telefono"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setPassword(rs.getString("password"));
            usuario.setRol(rs.getString("rol"));

            lista.add(usuario);
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al listar usuarios");
        System.out.println("Error: " + e.getMessage());
    }

    return lista;
}

public Usuario buscarPorId(int idUsuario){
    Usuario usuarioEncontrado = null;
    
    String sql = "SELECT * FROM  usuarios WHERE idUsuario=?";
    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
             usuarioEncontrado = new Usuario();
            
           usuarioEncontrado.setId(rs.getInt("idUsuario"));
            usuarioEncontrado.setDNI(rs.getString("dni"));
            usuarioEncontrado.setNombres(rs.getString("nombres"));
            usuarioEncontrado.setTelefono(rs.getString("telefono"));
            usuarioEncontrado.setUsuario(rs.getString("usuario"));
            usuarioEncontrado.setPassword(rs.getString("password"));
            usuarioEncontrado.setRol(rs.getString("rol"));
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al buscar usuario");
        System.out.println("Error: " + e.getMessage());
    }
    return usuarioEncontrado;
}

public boolean existeUsuario(String nombreUsuario) {

    boolean existe = false;

    String sql = "SELECT idUsuario FROM usuarios WHERE usuario = ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombreUsuario);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar usuario");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}
public boolean existeDNI(String dni) {

    boolean existe = false;

    String sql = "SELECT idUsuario FROM usuarios WHERE dni = ?";

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
        System.out.println("Error al verificar DNI de usuario");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}

public boolean existeTelefono(String telefono){
    boolean existe=false;
    String sql = " SELECT idUsuario FROM usuarios WHERE telefono =?";
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
        
    } catch (Exception e) {
        System.out.println("Error, el numero de Telefono ya esta registrado");
        System.out.println("Error: " + e.getMessage());
    }
    return existe;
}

public boolean existeUsuarioEnOtroUsuario(String nombreUsuario, int idUsuario) {

    boolean existe = false;

    String sql = "SELECT idUsuario FROM usuarios WHERE usuario = ? AND idUsuario <> ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, nombreUsuario);
        ps.setInt(2, idUsuario);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar usuario en otro usuario");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}

public boolean existeDNIEnOtroUsuario(String dni, int idUsuario) {

    boolean existe = false;

    String sql = "SELECT idUsuario FROM usuarios WHERE dni = ? AND idUsuario <> ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, dni);
        ps.setInt(2, idUsuario);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar DNI en otro usuario");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}
public boolean existeTelefonoEnOtroUsuario(String telefono, int idUsuario) {

    boolean existe = false;

    String sql = "SELECT idUsuario FROM usuarios WHERE telefono = ? AND idUsuario <> ?";

    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();

        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, telefono);
        ps.setInt(2, idUsuario);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        ps.close();
        cn.close();

    } catch (SQLException e) {
        System.out.println("Error al verificar teléfono en otro usuario");
        System.out.println("Error: " + e.getMessage());
    }

    return existe;
}

public boolean usuarioTieneVentas(int idUsuario) {
    boolean tieneVentas = false;
    String sql = "SELECT idVenta FROM ventas WHERE idUsuario = ? LIMIT 1";
    try {
        Conexion conexionBD = new Conexion();
        Connection cn = conexionBD.conectar();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();
        tieneVentas = rs.next();
        rs.close();
        ps.close();
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al verificar ventas del usuario");
        System.out.println("Error: " + e.getMessage());
    }
    return tieneVentas;
}


}

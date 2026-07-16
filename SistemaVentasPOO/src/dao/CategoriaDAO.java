

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
import java.util.ArrayList;
import modelo.Categoria;



public class CategoriaDAO {

    public boolean registrar(Categoria categoria){
        boolean registrado = false;
        String sql= "INSERT INTO categorias (nombreCategoria) VALUES (?)";
        try{
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();
            
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, categoria.getNombreCategoria());
            int filas = ps.executeUpdate();
            
            if (filas > 0) {
                registrado = true;
            }
            ps.close();
            cn.close();
        } catch(SQLException e){
            System.out.println("Error al registrar categoria");
            System.out.println("Error: " + e.getMessage());
        }
        return registrado;
    }

    public boolean actualizar(Categoria categoria) {
        boolean actualizado = false;
        String sql = "UPDATE categorias SET nombreCategoria = ? WHERE idCategoria = ?";
        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, categoria.getNombreCategoria());
            ps.setInt(2, categoria.getIdCategoria());
            actualizado = ps.executeUpdate() > 0;
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar categoría");
            System.out.println("Error: " + e.getMessage());
        }
        return actualizado;
    }

    public boolean eliminar(int idCategoria) {
        boolean eliminado = false;
        String sql = "DELETE FROM categorias WHERE idCategoria = ?";
        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idCategoria);
            eliminado = ps.executeUpdate() > 0;
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoría");
            System.out.println("Error: " + e.getMessage());
        }
        return eliminado;
    }

    public Categoria buscarPorNombre(String nombre) {
        Categoria encontrada = null;
        String sql = "SELECT * FROM categorias WHERE LOWER(nombreCategoria) = LOWER(?)";
        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombre.trim());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                encontrada = new Categoria();
                encontrada.setIdCategoria(rs.getInt("idCategoria"));
                encontrada.setNombreCategoria(rs.getString("nombreCategoria"));
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar categoría por nombre");
            System.out.println("Error: " + e.getMessage());
        }
        return encontrada;
    }

    public boolean existeNombre(String nombre) {
        return buscarPorNombre(nombre) != null;
    }

    public boolean existeNombreEnOtraCategoria(String nombre, int idCategoria) {
        boolean existe = false;
        String sql = "SELECT idCategoria FROM categorias "
                + "WHERE LOWER(nombreCategoria) = LOWER(?) AND idCategoria <> ?";
        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nombre.trim());
            ps.setInt(2, idCategoria);
            ResultSet rs = ps.executeQuery();
            existe = rs.next();
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al verificar categoría duplicada");
            System.out.println("Error: " + e.getMessage());
        }
        return existe;
    }

    public boolean categoriaTieneProductos(int idCategoria) {
        boolean tieneProductos = false;
        String sql = "SELECT idProducto FROM productos WHERE idCategoria = ? LIMIT 1";
        try {
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            tieneProductos = rs.next();
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al verificar productos de la categoría");
            System.out.println("Error: " + e.getMessage());
        }
        return tieneProductos;
    }
    
    public ArrayList<Categoria> listar(){
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try{
            Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();
            
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNombreCategoria(rs.getString("nombreCategoria"));
                lista.add(categoria);
            }
                 rs.close();
            ps.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al listar categorias");
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
    
    public Categoria buscarPorId(int idCategoria){
        Categoria categoriaEncontrada = null;
        String sql = "SELECT * FROM categorias WHERE idCategoria = ?";
        try{
             Conexion conexionBD = new Conexion();
            Connection cn = conexionBD.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idCategoria);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                categoriaEncontrada = new Categoria();
                
                categoriaEncontrada.setIdCategoria(rs.getInt("idCategoria"));
                categoriaEncontrada.setNombreCategoria(rs.getString("nombreCategoria"));     
          }
            rs.close();
            ps.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error al buscar la categoria");
            System.out.println("Error: " + e.getMessage());
        }
        return categoriaEncontrada;
    }
}

package controlador;

import dao.CategoriaDAO;
import java.util.ArrayList;
import modelo.Categoria;
import util.ResultadoOperacion;

public class CategoriaControlador {
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public ArrayList<Categoria> listar() { return categoriaDAO.listar(); }
    public Categoria buscarPorId(int id) { return categoriaDAO.buscarPorId(id); }

    public ResultadoOperacion<Categoria> registrar(String nombre) {
        String limpio = limpiar(nombre);
        if (limpio.isEmpty()) return ResultadoOperacion.error("Ingrese el nombre de la categoría.");
        if (categoriaDAO.existeNombre(limpio)) return ResultadoOperacion.error("Ya existe una categoría con ese nombre.");
        Categoria categoria = new Categoria(0, limpio);
        return categoriaDAO.registrar(categoria)
                ? ResultadoOperacion.exito("Categoría registrada correctamente.", categoria)
                : ResultadoOperacion.error("No se pudo registrar la categoría.");
    }

    public ResultadoOperacion<Categoria> actualizar(int id, String nombre) {
        String limpio = limpiar(nombre);
        if (id <= 0) return ResultadoOperacion.error("Seleccione una categoría.");
        if (limpio.isEmpty()) return ResultadoOperacion.error("Ingrese el nombre de la categoría.");
        if (categoriaDAO.existeNombreEnOtraCategoria(limpio, id)) return ResultadoOperacion.error("Ya existe otra categoría con ese nombre.");
        Categoria categoria = new Categoria(id, limpio);
        return categoriaDAO.actualizar(categoria)
                ? ResultadoOperacion.exito("Categoría actualizada correctamente.", categoria)
                : ResultadoOperacion.error("No se pudo actualizar la categoría.");
    }

    public ResultadoOperacion<Void> eliminar(int id) {
        if (id <= 0) return ResultadoOperacion.error("Seleccione una categoría.");
        if (categoriaDAO.categoriaTieneProductos(id)) return ResultadoOperacion.error("No se puede eliminar: la categoría tiene productos asociados.");
        return categoriaDAO.eliminar(id)
                ? ResultadoOperacion.exito("Categoría eliminada correctamente.", null)
                : ResultadoOperacion.error("No se pudo eliminar la categoría.");
    }

    private String limpiar(String nombre) {
        return nombre == null ? "" : nombre.trim().replaceAll("\\s+", " ");
    }
}

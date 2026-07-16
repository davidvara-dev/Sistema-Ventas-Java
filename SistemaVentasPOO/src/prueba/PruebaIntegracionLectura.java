package prueba;

import controlador.CategoriaControlador;
import controlador.ClienteControlador;
import controlador.LoginControlador;
import controlador.ProductoControlador;

public class PruebaIntegracionLectura {
    public static void main(String[] args) {
        boolean login = new LoginControlador().autenticar("admin", "1234").isExitoso();
        int categorias = new CategoriaControlador().listar().size();
        int clientes = new ClienteControlador().listar().size();
        int productos = new ProductoControlador().listar().size();

        if (!login || categorias == 0 || clientes == 0 || productos == 0) {
            throw new IllegalStateException("Falló la prueba de integración de lectura");
        }
        System.out.println("INTEGRACION_OK login=true categorias=" + categorias
                + " clientes=" + clientes + " productos=" + productos);
    }
}

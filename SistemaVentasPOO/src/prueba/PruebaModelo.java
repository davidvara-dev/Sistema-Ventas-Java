package prueba;

import modelo.Categoria;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Usuario;
import modelo.Venta;

public class PruebaModelo {

    public static void main(String[] args) {

        Categoria categoria = new Categoria(1, "Bebidas");

        Producto producto = new Producto(
                1,
                "Agua mineral",
                "Botella de agua 625 ml",
                2.50,
                100,
                categoria
        );

        Cliente cliente = new Cliente(
                1,
                "12345678",
                "David Vara",
                "999888777",
                "Lima",
                "david@email.com"
        );

        Usuario usuario = new Usuario(
                1,
                "87654321",
                "Administrador",
                "900111222",
                "admin",
                "1234",
                "Administrador"
        );

        Venta venta = new Venta();
        venta.setIdVenta(1);
        venta.setCliente(cliente);
        venta.setUsuario(usuario);
        venta.setFecha("2026-06-30");
        venta.setSubtotal(10.00);
        venta.calcularTotal();

        DetalleVenta detalle = new DetalleVenta(
                1,
                venta,
                producto,
                4,
                producto.getPrecio()
        );

        System.out.println(categoria);
        System.out.println(producto);
        System.out.println(cliente);
        System.out.println(usuario);
        System.out.println(venta);
        System.out.println(detalle);
    }
}
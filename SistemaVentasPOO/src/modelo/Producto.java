

package modelo;


public class Producto {
private int idProducto;
private String nombre;
private String Descripcion;
private double precio;
private int stock;
private Categoria categoria;

public Producto(){
    
}

    public Producto(int idProducto, String nombre, String Descripcion, double precio, int stock, Categoria categoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
 public void disminuirStock(int cantidad) {
        this.stock = this.stock - cantidad;
    }
 
 
  @Override
    public String toString() {
        return "Producto: " + nombre +
               " | Precio: S/ " + precio +
               " | Stock: " + stock +
               " | Categoría: " + categoria;
    }

}

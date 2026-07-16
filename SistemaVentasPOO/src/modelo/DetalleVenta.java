

package modelo;


public class DetalleVenta {

    private int idDetalle;
    private Venta venta;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
    public DetalleVenta(){
        
    }

    public DetalleVenta(int idDetalle, Venta venta, Producto producto, int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        calcularSubtotal();
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
       public void calcularSubtotal() {
        this.subtotal = this.cantidad * this.precioUnitario;
    }
       
     @Override
    public String toString() {
        return "Producto: " + producto.getNombre() +
               " | Cantidad: " + cantidad +
               " | Precio: S/ " + precioUnitario +
               " | Subtotal: S/ " + subtotal;
    }
}



package modelo;


public class Venta {

    private int idVenta;
    private Cliente cliente;
    private Usuario usuario;
    private String fecha;
    private double subtotal;
    private double igv;
    private double total;
    
    public Venta(){
        
    }

    public Venta(int idVenta, Cliente cliente, Usuario usuario, String fecha, double subtotal, double igv, double total) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.usuario = usuario;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
        public void calcularTotal() {
        this.igv = this.subtotal * 0.18;
        this.total = this.subtotal + this.igv;
    }
    @Override
    public String toString() {
        return "Venta N° " + idVenta +
               " | Cliente: " + cliente.getNombres() +
               " | Fecha: " + fecha +
               " | Total: S/ " + total;
    }
}

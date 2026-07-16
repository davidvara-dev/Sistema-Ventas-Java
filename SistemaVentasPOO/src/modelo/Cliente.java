

package modelo;


public class Cliente extends Persona {
private String direccion;
private String correo;
    public Cliente(){
        
    }


    public Cliente( int id, String DNI, String nombres, String telefono, String direccion, String correo) {
        super(id, DNI, nombres, telefono);
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
         return "Cliente: " + nombres +
               " | DNI: " + DNI +
               " | Teléfono: " + telefono +
               " | Dirección: " + direccion +
               " | Correo: " + correo;
    }
    
    
}

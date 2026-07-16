

package modelo;


public class Persona {
    
    protected int id;
    protected String DNI;
    protected String nombres;
    protected String telefono;
    public Persona(){
        
    }

    public Persona(int id, String DNI, String nombres, String telefono) {
        this.id = id;
        this.DNI = DNI;
        this.nombres = nombres;
        this.telefono = telefono;
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
        return "Persona{" + "id=" + id + ", DNI=" + DNI + ", nombres=" + nombres + ", telefono=" + telefono + '}';
    }

    
}

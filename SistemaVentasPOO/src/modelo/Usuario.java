

package modelo;


public class Usuario extends Persona{

     private String usuario;
    private String password;
    private String rol;

    public Usuario() {
    }

    public Usuario(int id, String DNI, String nombres, String telefono, String usuario, String password, String rol) {
        super(id, DNI, nombres, telefono);
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", rol=" + rol + '}';
    }
    
}

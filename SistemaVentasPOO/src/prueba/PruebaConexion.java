

package prueba;

import java.sql.Connection;
import conexion.Conexion;



public class PruebaConexion {
    public static void main(String[] args) {     
        
        Conexion conexionBD = new Conexion();

        Connection cn = conexionBD.conectar();
        if (cn != null) {
            System.out.println("La conexion funciona correctamente");
        } else{
            System.out.println("No se pudo conectar");
        }
    }
}

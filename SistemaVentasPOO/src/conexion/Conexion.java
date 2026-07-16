package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_sistema_ventas";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "admin123";

    public Connection conectar() {

        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de MySQL");
            System.out.println("Error: " + e.getMessage());

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            System.out.println("Error: " + e.getMessage());
        }

        return conexion;
    }
}
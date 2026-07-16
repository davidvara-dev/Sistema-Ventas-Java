

package util;


public class Validaciones {
public static boolean campoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean esDNIValido(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }

    public static boolean esTelefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d{9}");
    }

    public static boolean esCorreoValido(String correo) {
        return correo != null && correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean esNombreValido(String nombre) {
        return nombre != null && nombre.trim().matches("[\\p{L} .'-]{2,100}");
    }

    public static boolean esUsuarioValido(String usuario) {
        return usuario != null && usuario.trim().matches("[A-Za-z0-9._-]{4,50}");
    }

    public static boolean esPasswordValido(String password) {
        return password != null && password.length() >= 4 && password.length() <= 50;
    }

    public static boolean esEntero(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esDecimal(String texto) {
        try {
            Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esMayorQueCero(double numero) {
        return numero > 0;
    }

    public static boolean esMayorIgualCero(int numero) {
        return numero >= 0;
    }
}

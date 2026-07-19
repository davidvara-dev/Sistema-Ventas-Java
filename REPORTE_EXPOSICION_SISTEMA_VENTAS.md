# Reporte de exposición: Sistema de Ventas POO

## 1. Presentación del proyecto

Buenos días, profesor. El proyecto que presento es un sistema de ventas desarrollado en Java, con interfaces gráficas Swing y persistencia en una base de datos MySQL. Su objetivo es administrar usuarios, clientes, categorías y productos, registrar ventas, actualizar el stock y consultar reportes.

El proyecto aplica programación orientada a objetos porque el problema real se representa mediante clases como `Cliente`, `Usuario`, `Producto`, `Categoria`, `Venta` y `DetalleVenta`. Cada objeto conserva un estado mediante atributos y ofrece operaciones mediante métodos.

La aplicación está dividida en paquetes para separar responsabilidades:

```text
app           → inicia el programa
vista         → formularios Swing y eventos del usuario
controlador   → coordina las reglas y el acceso a datos
dao           → ejecuta instrucciones SQL
conexion      → crea conexiones con MySQL
modelo        → representa las entidades del negocio
util          → validaciones, estilos y resultados
prueba        → pruebas independientes e integrales
```

La comunicación principal es:

```text
Usuario → Formulario → Controlador → DAO → Conexion → MySQL
                       ↓             ↓
                    Modelo ← datos devueltos
```

Una vista no debería escribir SQL directamente. La vista recoge datos y llama al controlador. El controlador decide qué operación realizar y delega al DAO. El DAO conoce la base de datos y convierte sus filas en objetos del modelo.

## 2. Conceptos de POO aplicados

### 2.1 Clases y objetos

Una clase es el molde y un objeto es una instancia concreta. `Producto` es una clase; una botella de agua con precio, stock y categoría es un objeto de esa clase.

Cuando aparece:

```java
Producto producto = new Producto();
```

`Producto` es el tipo, `producto` es la variable de referencia, `new Producto()` crea el objeto y el constructor lo inicializa.

### 2.2 Encapsulamiento

Los atributos de los modelos se mantienen principalmente como `private`. No se manipulan directamente desde otras clases, sino mediante getters y setters:

```java
private double precio;

public double getPrecio() { return precio; }
public void setPrecio(double precio) { this.precio = precio; }
```

Esto protege el estado interno y crea puntos controlados de lectura y modificación.

### 2.3 Herencia

`Cliente` y `Usuario` heredan de `Persona`:

```java
public class Cliente extends Persona
public class Usuario extends Persona
```

Los atributos comunes `id`, `DNI`, `nombres` y `telefono` se definen una vez en `Persona`. Así se evita repetir estructura y se representa la relación “un cliente es una persona” y “un usuario es una persona”.

### 2.4 Abstracción

Cada capa esconde detalles. Por ejemplo, la vista llama `controlador.listar()` sin conocer el `SELECT`, la conexión o el recorrido del `ResultSet`.

### 2.5 Polimorfismo y sobrescritura

Los modelos sobrescriben `toString()`, que originalmente pertenece a `Object`:

```java
@Override
public String toString() {
    return nombreCategoria;
}
```

El mismo método `toString()` produce una representación distinta según el objeto. En `Categoria` también permite que un `JComboBox<Categoria>` muestre el nombre sin perder el objeto completo.

### 2.6 Composición y asociación

`Producto` contiene una `Categoria`; `Venta` contiene un `Cliente` y un `Usuario`; `DetalleVenta` contiene una `Venta` y un `Producto`. Estas referencias permiten navegar entre objetos relacionados.

## 3. Inicio del programa: `app.Main`

`Main` es el punto de entrada oficial.

```java
public final class Main
```

`final` evita que otra clase herede de `Main`, porque esta clase solo sirve para iniciar la aplicación.

```java
private Main() { }
```

El constructor es privado para impedir `new Main()`. No se necesita crear un objeto, pues sus operaciones son estáticas.

```java
public static void main(String[] args)
```

La JVM busca este método para iniciar el programa. `public` permite que la JVM lo llame, `static` evita tener que crear un objeto, `void` indica que no retorna un resultado y `String[] args` recibe argumentos externos.

Primero se llama `aplicarApariencia()`. Este método recorre los estilos Swing instalados y selecciona Nimbus. El `try/catch` impide que un problema visual detenga todo el sistema.

Después se ejecuta:

```java
SwingUtilities.invokeLater(() -> new FrmLogin().setVisible(true));
```

`invokeLater` coloca la creación de la interfaz en el Event Dispatch Thread, el hilo recomendado por Swing. La expresión lambda crea `FrmLogin` y lo hace visible.

## 4. Conexión: `conexion.Conexion`

La clase guarda URL, usuario y contraseña como constantes privadas y estáticas:

```java
private static final String URL = "jdbc:mysql://localhost:3306/bd_sistema_ventas";
```

`private` encapsula el valor, `static` lo asocia con la clase y `final` impide reasignarlo.

El método `conectar()`:

1. Declara una referencia `Connection` inicialmente en `null`.
2. Carga el controlador JDBC mediante `Class.forName`.
3. Llama a `DriverManager.getConnection` con las credenciales.
4. Captura por separado la ausencia del driver y los errores SQL.
5. Retorna la conexión o `null` si falla.

Para una exposición se debe reconocer que las credenciales escritas en el código son aceptables solo en un proyecto académico local. En producción se guardarían en variables de entorno o configuración protegida.

## 5. Capa modelo

### 5.1 `Persona`

Es la superclase de `Cliente` y `Usuario`. Sus atributos son `protected`, por lo que son accesibles desde las subclases. Tiene constructor vacío para crear objetos y asignar datos después, y constructor completo para inicializarlos de una vez.

La palabra `this` diferencia el atributo del parámetro:

```java
this.id = id;
```

El valor recibido en `id` se almacena en el atributo `id` del objeto actual.

### 5.2 `Cliente`

Hereda los datos personales y agrega `direccion` y `correo`. Su constructor llama:

```java
super(id, DNI, nombres, telefono);
```

`super` ejecuta el constructor de `Persona`. Después se inicializan los atributos propios de `Cliente`.

### 5.3 `Usuario`

También hereda de `Persona` y agrega `usuario`, `password` y `rol`. El rol se utiliza para limitar opciones del menú. La contraseña actualmente se maneja como texto; en un sistema real debería almacenarse como hash seguro.

### 5.4 `Categoria`

Contiene `idCategoria` y `nombreCategoria`. Su `toString()` retorna solamente el nombre, decisión especialmente útil cuando el objeto se muestra dentro del selector de categorías.

### 5.5 `Producto`

Contiene identificador, nombre, descripción, precio, stock y una referencia a `Categoria`.

```java
public void disminuirStock(int cantidad) {
    this.stock = this.stock - cantidad;
}
```

Este es un método de negocio: cambia el estado del producto. Sin embargo, el descuento definitivo en la base de datos se realiza de forma transaccional desde `ProductoDAO.descontarStock`.

### 5.6 `Venta`

Es la cabecera de una operación comercial. Guarda cliente, usuario, fecha, subtotal, IGV y total.

```java
public void calcularTotal() {
    this.igv = this.subtotal * 0.18;
    this.total = this.subtotal + this.igv;
}
```

El objeto conoce su propia regla de cálculo. Esto es más orientado a objetos que calcular siempre desde la interfaz.

### 5.7 `DetalleVenta`

Representa una línea de la venta. Relaciona un producto con cantidad y precio unitario.

```java
public void calcularSubtotal() {
    this.subtotal = this.cantidad * this.precioUnitario;
}
```

El constructor completo llama a este método para que el objeto nazca con un subtotal coherente.

## 6. Utilidades

### 6.1 `Validaciones`

Centraliza reglas reutilizables y evita duplicar expresiones regulares en los formularios.

- `campoVacio`: acepta `null` como vacío y elimina espacios externos.
- `esDNIValido`: exige exactamente ocho dígitos.
- `esTelefonoValido`: exige nueve dígitos.
- `esCorreoValido`: verifica una estructura básica de correo.
- `esNombreValido`: permite letras Unicode, espacios y ciertos signos.
- `esUsuarioValido`: permite de 4 a 50 caracteres seleccionados.
- `esPasswordValido`: controla la longitud.
- `esEntero` y `esDecimal`: intentan convertir y capturan `NumberFormatException`.
- `esMayorQueCero` y `esMayorIgualCero`: validan rangos numéricos.

Son métodos `static` porque no dependen del estado de un objeto `Validaciones`.

### 6.2 `ResultadoOperacion<T>`

Encapsula tres datos: si la operación fue exitosa, un mensaje y un dato opcional.

`<T>` es un genérico. Permite retornar un `ResultadoOperacion<Usuario>`, `ResultadoOperacion<Categoria>` o cualquier otro tipo sin duplicar la clase.

El constructor es privado. Los objetos se crean mediante métodos fábrica:

```java
ResultadoOperacion.exito("Mensaje", objeto)
ResultadoOperacion.error("Mensaje")
```

Esto obliga a crear resultados consistentes. En un error, `dato` queda en `null`.

### 6.3 `EstiloUI`

Centraliza colores y configuración de tablas. La clase es `final` y su constructor es privado porque funciona como conjunto de utilidades estáticas.

`prepararTabla(JTable tabla, int... anchos)` usa varargs. `int...` permite recibir cualquier cantidad de anchos. Configura altura, selección única, ordenamiento, edición desactivada y ancho de columnas.

`alinearDerecha` instala un renderer en columnas numéricas. `estado` cambia texto y color de una etiqueta. `resaltarError` usa `instanceof` para confirmar que el componente admite un fondo y foco.

## 7. Patrón DAO y JDBC

DAO significa Data Access Object. Cada DAO concentra el SQL de una entidad.

El patrón general de una inserción es:

```java
String sql = "INSERT ... VALUES (?, ?)";
Connection cn = new Conexion().conectar();
PreparedStatement ps = cn.prepareStatement(sql);
ps.setString(1, valor);
int filas = ps.executeUpdate();
```

Los signos `?` son parámetros. `PreparedStatement` evita concatenar directamente entradas del usuario y reduce el riesgo de inyección SQL.

`executeUpdate()` se usa para `INSERT`, `UPDATE` y `DELETE`; retorna las filas afectadas. `executeQuery()` se usa para `SELECT` y retorna un `ResultSet`.

`rs.next()` avanza a la siguiente fila. En una búsqueda individual se usa `if`; en un listado se usa `while`.

### 7.1 `CategoriaDAO`

- `registrar`: inserta el nombre.
- `actualizar`: modifica por ID.
- `eliminar`: elimina por ID.
- `buscarPorNombre`: realiza una comparación sin distinguir mayúsculas.
- `existeNombre`: reutiliza `buscarPorNombre` y comprueba si el resultado no es `null`.
- `existeNombreEnOtraCategoria`: permite actualizar sin considerar duplicado el mismo registro.
- `categoriaTieneProductos`: protege la relación antes de eliminar.
- `listar`: construye un `ArrayList<Categoria>` desde todas las filas.
- `buscarPorId`: retorna una categoría o `null`.

### 7.2 `ClienteDAO`

Implementa registrar, actualizar, eliminar, listar y buscar. También verifica duplicados de DNI, teléfono y correo. Los métodos “EnOtroCliente” excluyen el ID actual durante una actualización.

### 7.3 `UsuarioDAO`

`validarLogin` busca una fila que coincida con usuario y contraseña. Los demás métodos implementan CRUD y verificaciones de duplicidad. `usuarioTieneVentas` comprueba relaciones antes de eliminar.

Existe una línea que conviene corregir antes de exponer:

```java
usuarioEncontrado.setNombres("nombres");
```

Actualmente asigna el texto literal `nombres`. Lo correcto sería `rs.getString("nombres")`. También debe revisarse el espacio antes de `WHERE` en el SQL de actualización de usuario.

### 7.4 `ProductoDAO`

Además del CRUD, carga la categoría relacionada para reconstruir el objeto completo. `productoTieneVentas` protege el historial. `descontarStock(Connection cn, ...)` recibe una conexión externa porque debe participar en la misma transacción de la venta.

La actualización atómica del stock sigue la idea:

```sql
UPDATE productos
SET stock = stock - ?
WHERE idProducto = ? AND stock >= ?
```

La condición `stock >= cantidad` evita stock negativo incluso si dos operaciones intentan vender simultáneamente.

### 7.5 `DetalleVentaDAO`

Registra cada línea de venta y puede listar los detalles de una venta. Tiene una versión que abre su conexión y otra que recibe `Connection`. La segunda existe para integrarse con la transacción administrada por `VentaDAO`.

### 7.6 `VentaDAO` y la transacción

`registrarVenta(Venta venta, ArrayList<DetalleVenta> detalles)` es uno de los métodos más importantes.

1. Abre una conexión.
2. Desactiva `autoCommit`.
3. Inserta la cabecera de venta.
4. Solicita la clave primaria generada.
5. Asigna ese ID al objeto `Venta`.
6. Recorre los detalles con un `for-each`.
7. Asocia cada detalle con la venta.
8. Inserta el detalle usando la misma conexión.
9. Descuenta el stock usando la misma conexión.
10. Ejecuta `commit()` solamente si todo termina bien.
11. Ante una excepción ejecuta `rollback()`.

Esto garantiza atomicidad: se registra todo o no se registra nada. No debe quedar una venta sin detalles ni descontarse stock si la venta falla.

`listarVentas` usa `INNER JOIN` para recuperar simultáneamente datos de venta, cliente y usuario. Los alias como `dniUsuario` evitan conflictos entre columnas con nombres iguales.

## 8. Controladores

Los controladores sirven como intermediarios entre vista y DAO.

### 8.1 `LoginControlador`

`autenticar` limpia el usuario, verifica campos vacíos y llama `usuarioDAO.validarLogin`. Retorna `ResultadoOperacion<Usuario>` para que la vista reciba simultáneamente estado, mensaje y usuario autenticado.

### 8.2 `CategoriaControlador`

Es el controlador con reglas más completas. `limpiar` elimina espacios externos y reemplaza varios espacios internos por uno. Antes de registrar verifica nombre vacío y duplicado. Antes de actualizar verifica ID y duplicado en otra categoría. Antes de eliminar comprueba productos asociados.

El operador ternario:

```java
condicion ? valorSiVerdadero : valorSiFalso
```

permite convertir el booleano retornado por el DAO en un resultado de éxito o error.

### 8.3 `ClienteControlador`, `ProductoControlador` y `UsuarioControlador`

Exponen métodos de la capa DAO a la vista. Las validaciones detalladas de estos módulos están principalmente en los formularios. Para una arquitectura futura más estricta, dichas reglas podrían trasladarse al controlador, como ya ocurre en categorías.

### 8.4 `VentaControlador`

Permite buscar cliente por DNI, buscar producto por ID, registrar la venta con sus detalles y listar ventas. La vista no necesita conocer los DAO implicados.

### 8.5 `ReporteControlador`

Agrupa consultas de clientes, productos, ventas y detalles. Es utilizado por los formularios de reportes y detalle de venta.

## 9. Vistas Swing

Los formularios extienden `JFrame`. Cada constructor normalmente sigue este orden:

```java
initComponents();
configurarDatos();
listarRegistros();
setLocationRelativeTo(null);
```

`initComponents()` es generado o administrado por NetBeans. Crea controles, define layouts y registra listeners. No conviene editar manualmente el bloque protegido; el código propio debe colocarse en métodos separados.

Un método `ActionPerformed` es un manejador de eventos. Swing lo llama cuando el usuario presiona el botón asociado. El parámetro `ActionEvent evt` contiene información del evento, aunque no siempre sea necesario usarlo.

### 9.1 `FrmLogin`

Contiene un `LoginControlador`. Al pulsar Ingresar:

1. Lee usuario y contraseña.
2. Llama `controlador.autenticar`.
3. Si falla, muestra el mensaje.
4. Si tiene éxito, obtiene el `Usuario` desde el resultado.
5. Crea `FrmPrincipal(usuario)`.
6. Muestra la ventana principal y cierra el login.

De esta manera, el usuario autenticado se transporta como objeto, no como variables globales sueltas.

### 9.2 `FrmPrincipal`

Recibe el usuario de la sesión. `configurarSesion()` muestra su nombre y rol y restringe módulos según permisos. Cada botón crea el formulario correspondiente, lo centra y lo muestra.

Cerrar sesión vuelve a `FrmLogin`; salir solicita confirmación y termina la interfaz.

### 9.3 `FrmCategorias`

El constructor llama `initComponents`, `aplicarEstilos`, `prepararTabla`, `listarCategorias` y `limpiarFormulario`.

- `aplicarEstilos`: mantiene colores personalizados fuera del bloque generado.
- `prepararTabla`: crea un modelo no editable y configura columnas.
- `listarCategorias`: limpia el modelo, consulta al controlador y agrega filas.
- `limpiarFormulario`: borra campos y selección.
- `idSeleccionado`: convierte el texto del ID o retorna cero.
- `mostrarResultado`: presenta mensajes con color verde o rojo.
- `btnGuardarActionPerformed`: registra y, si tiene éxito, recarga y limpia.
- `btnActualizarActionPerformed`: modifica el registro seleccionado.
- `btnEliminarActionPerformed`: confirma, elimina y actualiza la tabla.
- `tblCategoriasMouseClicked`: obtiene la fila seleccionada y carga sus datos.

`convertRowIndexToModel` es importante porque la tabla puede estar ordenada visualmente. Convierte el índice visible al índice real del modelo.

### 9.4 `FrmClientes`

`listarClientes` crea o llena el modelo de tabla. `obtenerClienteFormulario` reúne los campos en un objeto `Cliente`. Los eventos Guardar y Actualizar validan nombre, DNI, teléfono, correo y duplicados antes de llamar al controlador. Buscar consulta por DNI. El clic en tabla carga los datos. Nuevo y `limpiarCampos` restauran el estado.

### 9.5 `FrmProductos`

`cargarCategorias` obtiene objetos `Categoria` y los coloca en el combo. `listarProductos` carga la tabla. `obtenerProductoFormulario` convierte texto a números y asocia la categoría seleccionada. Guardar y Actualizar validan campos, precio, stock, categoría y nombre duplicado. Eliminar evita borrar productos con ventas relacionadas.

### 9.6 `FrmUsuarios`

Recibe opcionalmente al usuario actual para proteger la sesión. `obtenerUsuarioFormulario` construye un `Usuario`. Los eventos validan datos personales, credenciales, rol y duplicados. Al eliminar se controla que el usuario no tenga ventas y que no se elimine indebidamente la cuenta activa.

### 9.7 `FrmVentas`

Mantiene el usuario vendedor, cliente seleccionado, producto seleccionado, lista de detalles y modelo de tabla.

- `configurarAtajos`: registra teclas para agilizar acciones.
- `prepararTablaDetalle`: configura las columnas del carrito.
- `limpiarTotales`: coloca valores monetarios iniciales.
- `calcularTotales`: suma subtotales, calcula IGV y total.
- `limpiarProducto`: limpia la selección del producto actual.
- `limpiarVenta`: restablece toda la operación.
- `productoYaAgregado`: evita líneas duplicadas.
- Buscar cliente: consulta por DNI.
- Buscar producto: consulta por ID.
- Agregar producto: valida cantidad y stock, crea `DetalleVenta` y lo agrega.
- Quitar producto: elimina la línea seleccionada.
- Registrar venta: construye `Venta`, llama al controlador y abre el comprobante si todo fue exitoso.

El `ArrayList<DetalleVenta>` funciona como carrito temporal en memoria hasta confirmar la venta.

### 9.8 `FrmComprobante`

Recibe una `Venta` y sus detalles mediante un constructor sobrecargado. `generarComprobante` forma el contenido textual con cabecera, productos y totales. Imprimir utiliza la capacidad de impresión del componente Swing y Cerrar libera la ventana.

### 9.9 `FrmReportes`

Permite alternar entre reportes de productos, clientes y ventas. Cada botón solicita una lista al `ReporteControlador` y cambia las columnas del modelo. Ver detalle toma el ID de la venta seleccionada y abre `FrmDetalleVenta`.

### 9.10 `FrmDetalleVenta`

El constructor sobrecargado recibe `idVenta`. `listarDetalleVenta` llama `controlador.detalles(idVenta)` y llena la tabla con productos, cantidades, precios y subtotales.

## 10. Recorrido completo de una venta

1. `Main.main` abre `FrmLogin`.
2. El usuario escribe credenciales.
3. `FrmLogin` llama `LoginControlador.autenticar`.
4. El controlador llama `UsuarioDAO.validarLogin`.
5. El DAO consulta MySQL y retorna `Usuario`.
6. Se abre `FrmPrincipal` con ese usuario.
7. El usuario abre `FrmVentas`.
8. Se busca al cliente por DNI a través de `VentaControlador` y `ClienteDAO`.
9. Se busca el producto por ID mediante `ProductoDAO`.
10. Se crea un `DetalleVenta` por cada producto agregado.
11. La vista calcula los totales y construye `Venta`.
12. `VentaControlador.registrar` llama `VentaDAO.registrarVenta`.
13. `VentaDAO` inicia una transacción.
14. Inserta cabecera, detalles y descuenta stock.
15. Si todo sale bien ejecuta `commit`; si algo falla, `rollback`.
16. Se muestra `FrmComprobante`.

## 11. Pruebas incluidas

- `PruebaConexion`: confirma que `Conexion.conectar()` no retorne `null`.
- `PruebaModelo`: crea objetos relacionados, calcula totales y muestra sus `toString()`.
- `PruebaUsuarioDAO`: prueba el acceso directo al login del DAO.
- `PruebaIntegracionLectura`: comprueba conjuntamente login, categorías, clientes y productos; lanza una excepción si algún resultado esperado falla.

Las pruebas con `main` son sencillas y apropiadas para demostrar funcionamiento. En una evolución del proyecto se podrían convertir en pruebas JUnit automatizadas.

## 12. Decisiones defendibles ante el profesor

- Se separó la interfaz del acceso a datos para reducir acoplamiento.
- Se usó herencia solamente para datos verdaderamente comunes entre cliente y usuario.
- Se emplearon objetos relacionados en vez de guardar únicamente IDs en memoria.
- Se usó `PreparedStatement` para parámetros SQL.
- Se utilizó una transacción en ventas porque participan varias tablas.
- Se encapsularon resultados con mensajes usando un genérico.
- Se centralizaron validaciones y estilos reutilizables.
- Se utilizó el hilo de eventos de Swing para iniciar la interfaz.
- Se protegieron eliminaciones cuando existen registros relacionados.

## 13. Observaciones honestas y mejoras futuras

El sistema cumple una finalidad académica, pero conviene reconocer estas mejoras:

1. Corregir en `UsuarioDAO.validarLogin` la asignación literal de nombres.
2. Revisar el espacio del SQL antes de `WHERE` al actualizar usuarios.
3. Guardar contraseñas con hash, nunca en texto plano.
4. Extraer credenciales de conexión a configuración externa.
5. Usar `try-with-resources` para cerrar conexiones incluso ante errores.
6. Trasladar más validaciones de formularios a controladores.
7. Usar `BigDecimal` para importes monetarios en lugar de `double`.
8. Agregar restricciones y claves foráneas adecuadas en MySQL.
9. Incorporar JUnit y pruebas de transacciones.
10. Unificar nombres según convenciones Java, por ejemplo `dni` y `descripcion` en minúscula inicial.

Reconocer estas mejoras no invalida el proyecto; demuestra comprensión técnica y capacidad crítica.

## 14. Guía para explicar cualquier línea

Para explicar una línea durante la exposición conviene responder cinco preguntas:

1. ¿En qué clase y capa está?
2. ¿Qué objeto o dato recibe?
3. ¿Qué método está llamando?
4. ¿Qué devuelve o qué estado modifica?
5. ¿Por qué esa responsabilidad pertenece a esa clase?

Ejemplo:

```java
ResultadoOperacion<Usuario> resultado = controlador.autenticar(usuario, password);
```

- Está en la vista de login.
- Envía dos cadenas al controlador.
- Llama al método `autenticar`.
- Recibe un objeto genérico con éxito, mensaje y usuario.
- La vista delega la autenticación para no consultar la base de datos directamente.

## 15. Cierre sugerido de la exposición

En conclusión, el sistema modela un proceso real de ventas mediante objetos y separa presentación, reglas y persistencia. La herencia evita repetir datos personales; la composición representa relaciones entre productos, categorías, clientes, usuarios y ventas; los DAO encapsulan JDBC; y la transacción protege la consistencia de la venta y el stock. El proyecto funciona como una base completa que puede evolucionar en seguridad, pruebas y mantenimiento.


-- =====================================================
-- DATOS DE EJEMPLO PARA EL SISTEMA DE VENTAS
-- Ejecutar después de crear las tablas de la base de datos.
-- =====================================================

USE bd_sistema_ventas;

-- 1. REGISTRO DE CATEGORÍAS
INSERT INTO categorias (idCategoria, nombreCategoria) VALUES
(1, 'Bebidas'),
(2, 'Abarrotes'),
(3, 'Limpieza');

-- 2. REGISTRO DE CLIENTES
INSERT INTO clientes
    (idCliente, dni, nombres, telefono, direccion, correo)
VALUES
    (1, '74851236', 'Carlos Mendoza Ruiz', '987654321',
     'Av. Los Olivos 245, Lima', 'carlos.mendoza@gmail.com'),
    (2, '70234567', 'Ana Torres Salazar', '956123478',
     'Jr. Las Flores 180, Lima', 'ana.torres@gmail.com'),
    (3, '76543210', 'Luis Ramirez Castro', '923456781',
     'Calle Los Pinos 315, Lima', 'luis.ramirez@gmail.com');

-- 3. REGISTRO DE USUARIOS DEL SISTEMA
INSERT INTO usuarios
    (idUsuario, dni, nombres, telefono, usuario, password, rol)
VALUES
    (1, '70112233', 'Administrador del Sistema', '900111222',
     'admin', '1234', 'Administrador'),
    (2, '70445566', 'Maria Lopez Vega', '900333444',
     'mlopez', '1234', 'Vendedor');

-- 4. REGISTRO DE PRODUCTOS
-- Cada producto se relaciona con una categoría mediante idCategoria.
INSERT INTO productos
    (idProducto, nombre, descripcion, precio, stock, idCategoria)
VALUES
    (1, 'Agua mineral', 'Botella de agua mineral de 625 ml', 2.50, 100, 1),
    (2, 'Gaseosa cola', 'Botella de gaseosa de 1.5 litros', 7.50, 60, 1),
    (3, 'Arroz extra', 'Bolsa de arroz extra de 1 kilogramo', 5.20, 80, 2),
    (4, 'Aceite vegetal', 'Botella de aceite vegetal de 1 litro', 11.90, 45, 2),
    (5, 'Detergente', 'Bolsa de detergente de 800 gramos', 9.80, 50, 3);

-- 5. REGISTRO DE LA PRIMERA VENTA
-- El cliente 1 fue atendido por el usuario 2.
INSERT INTO ventas
    (idVenta, fecha, subtotal, igv, total, idCliente, idUsuario)
VALUES
    (1, '2026-07-18', 20.00, 3.60, 23.60, 1, 2);

-- Productos pertenecientes a la primera venta.
INSERT INTO detalle_venta
    (idDetalle, idVenta, idProducto, cantidad, precioUnitario, subtotal)
VALUES
    (1, 1, 1, 2, 2.50, 5.00),
    (2, 1, 3, 1, 5.20, 5.20),
    (3, 1, 5, 1, 9.80, 9.80);

-- 6. REGISTRO DE LA SEGUNDA VENTA
-- El cliente 2 fue atendido por el usuario administrador.
INSERT INTO ventas
    (idVenta, fecha, subtotal, igv, total, idCliente, idUsuario)
VALUES
    (2, '2026-07-18', 31.30, 5.63, 36.93, 2, 1);

-- Productos pertenecientes a la segunda venta.
INSERT INTO detalle_venta
    (idDetalle, idVenta, idProducto, cantidad, precioUnitario, subtotal)
VALUES
    (4, 2, 2, 1, 7.50, 7.50),
    (5, 2, 4, 2, 11.90, 23.80);

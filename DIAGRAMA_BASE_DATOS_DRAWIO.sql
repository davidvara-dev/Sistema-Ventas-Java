CREATE TABLE categorias (
    idCategoria INT NOT NULL AUTO_INCREMENT,
    nombreCategoria VARCHAR(100) NOT NULL,
    PRIMARY KEY (idCategoria)
);

CREATE TABLE clientes (
    idCliente INT NOT NULL AUTO_INCREMENT,
    dni VARCHAR(8) NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(150),
    correo VARCHAR(100),
    PRIMARY KEY (idCliente),
    UNIQUE (dni),
    UNIQUE (telefono),
    UNIQUE (correo)
);

CREATE TABLE usuarios (
    idUsuario INT NOT NULL AUTO_INCREMENT,
    dni VARCHAR(8),
    nombres VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    usuario VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    rol VARCHAR(30) NOT NULL,
    PRIMARY KEY (idUsuario),
    UNIQUE (dni),
    UNIQUE (telefono),
    UNIQUE (usuario)
);

CREATE TABLE productos (
    idProducto INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    idCategoria INT,
    PRIMARY KEY (idProducto),
    UNIQUE (nombre),
    CONSTRAINT fk_producto_categoria
        FOREIGN KEY (idCategoria)
        REFERENCES categorias (idCategoria)
);

CREATE TABLE ventas (
    idVenta INT NOT NULL AUTO_INCREMENT,
    fecha DATE NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    igv DECIMAL(10,2) NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    idCliente INT,
    idUsuario INT,
    PRIMARY KEY (idVenta),
    CONSTRAINT fk_venta_cliente
        FOREIGN KEY (idCliente)
        REFERENCES clientes (idCliente),
    CONSTRAINT fk_venta_usuario
        FOREIGN KEY (idUsuario)
        REFERENCES usuarios (idUsuario)
);

CREATE TABLE detalle_venta (
    idDetalle INT NOT NULL AUTO_INCREMENT,
    idVenta INT,
    idProducto INT,
    cantidad INT NOT NULL,
    precioUnitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (idDetalle),
    CONSTRAINT fk_detalle_venta
        FOREIGN KEY (idVenta)
        REFERENCES ventas (idVenta),
    CONSTRAINT fk_detalle_producto
        FOREIGN KEY (idProducto)
        REFERENCES productos (idProducto)
);

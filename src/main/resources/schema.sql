DROP TABLE IF EXISTS linea_comprobante;
DROP TABLE IF EXISTS comprobante;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS cliente;

CREATE TABLE categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),  -- Agrega esta línea
    mail VARCHAR(255),
    direccion VARCHAR(255),
    telefono_de_contacto VARCHAR(20),
    numero_de_cuit VARCHAR(20)
);

CREATE TABLE producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DOUBLE NOT NULL,
    cantidad INT NOT NULL,
    categoria_id BIGINT,
    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE comprobante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT,
    fecha TIMESTAMP,
    total_venta DOUBLE,
    cantidad_total_productos INT,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE linea_comprobante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    producto_id BIGINT,
    comprobante_id BIGINT,
    cantidad INT,
    FOREIGN KEY (producto_id) REFERENCES producto(id),
    FOREIGN KEY (comprobante_id) REFERENCES comprobante(id)
);

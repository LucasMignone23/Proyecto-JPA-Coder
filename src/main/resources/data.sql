INSERT INTO categoria (nombre) VALUES 
('Electrónica'),
('Accesorios');

INSERT INTO cliente (nombre, mail, direccion, telefono_de_contacto, numero_de_cuit) VALUES 
('Cliente 1', 'cliente1@example.com', 'Calle Falsa 123', '123456789', '20-12345678-9'),
('Cliente 2', 'cliente2@example.com', 'Avenida Siempre Viva 742', '987654321', '20-98765432-1');


INSERT INTO producto (nombre, precio, cantidad, categoria_id) VALUES 
('Laptop', 999.99, 50, 1),
('Smartphone', 599.49, 150, 1),
('Teclado', 49.99, 75, 2),
('Joystick', 29.99, 200, 2),
('Monitor', 199.99, 30, 1);

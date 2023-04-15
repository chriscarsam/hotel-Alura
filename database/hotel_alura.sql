CREATE DATABASE hotel_alura;
USE hotel_alura;

CREATE TABLE reservas (
id INT UNSIGNED AUTO_INCREMENT, 
fecha_entrada DATE NOT NULL,
fecha_salida DATE NOT NULL,
valor double NOT NULL,
forma_pago VARCHAR(35) NOT NULL,
PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE huespedes (
id INT UNSIGNED AUTO_INCREMENT, 
id_reserva INT UNSIGNED NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
fecha_nacimiento DATE NOT NULL,
nacionalidad VARCHAR(50) NOT NULL,
telefono VARCHAR(35) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (id_reserva) REFERENCES reservas(id)
)ENGINE=InnoDB;

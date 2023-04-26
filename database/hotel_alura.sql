DROP DATABASE IF EXISTS hotel_alura;
CREATE DATABASE IF NOT EXISTS hotel_alura;
USE hotel_alura;

CREATE TABLE IF NOT EXISTS reservas (
id INT UNSIGNED AUTO_INCREMENT, 
fecha_entrada DATE NOT NULL,
fecha_salida DATE NOT NULL,
valor double NOT NULL,
forma_pago VARCHAR(35) NOT NULL,
PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS huespedes (
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

SELECT *FROM reservas;
SELECT *FROM huespedes ORDER BY id DESC;

SELECT *FROM reservas WHERE id = 1;
SELECT *FROM huespedes WHERE apellido LIKE "%nay%";
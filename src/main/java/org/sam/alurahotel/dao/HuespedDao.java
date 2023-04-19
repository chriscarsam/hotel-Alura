package org.sam.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sam.alurahotel.modelo.Huesped;

public class HuespedDao {
	
	final private Connection con;

	public HuespedDao(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huesped huesped) {
		
		try {
			final PreparedStatement statement = con.prepareStatement("INSERT INTO huespedes(id_reserva, nombre, apellido, fecha_nacimiento, nacionalidad, telefono)"
					+ " VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				
				ejecutarReserva(huesped, statement);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void ejecutarReserva(Huesped huesped, PreparedStatement statement) throws SQLException {
		
		statement.setLong(1,  huesped.getIdReserva());
		statement.setString(2, huesped.getNombre());
		statement.setString(3, huesped.getApellido());
		statement.setString(4, huesped.getFechaNacimiento());
		statement.setString(5, huesped.getNacionalidad());
		statement.setString(6, huesped.getTelefono());
		
		statement.execute();
		
		final ResultSet resultSet = statement.getGeneratedKeys();
		
		try(resultSet){
			while(resultSet.next()) {
				huesped.setId(resultSet.getLong(1));
				System.out.println(String.format("Fue insertado el huesped %s", huesped));
			}
		}
		
	}
	
	
}

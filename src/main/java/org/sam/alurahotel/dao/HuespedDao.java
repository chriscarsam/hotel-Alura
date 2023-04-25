package org.sam.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sam.alurahotel.factory.ConnectionFactory;
import org.sam.alurahotel.modelo.Huesped;

public class HuespedDao {
	
	final private Connection con;

	public HuespedDao(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huesped huesped) {
		
		try {
			final PreparedStatement statement = con.prepareStatement("INSERT INTO huespedes(id_reserva, nombre, apellido, fecha_nacimiento, nacionalidad, telefono)"
					+ " VALUES(?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			
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
	
public List<Huesped> listarHuespedes(String campo){
		
		List<Huesped> resultado = new ArrayList<>();
		
		ConnectionFactory factory = new ConnectionFactory();
		
		final Connection con = factory.recupetaConexion();
		
		try(con){
			
			var querySelect = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes ";
			
			if(!campo.isEmpty()) {
			    querySelect	+= "WHERE apellido LIKE ? ";
			}
			
				querySelect	+= "ORDER BY id DESC; ";
				
			System.out.println(querySelect);
			
			final PreparedStatement statement = con.prepareStatement(querySelect);
			
			try(statement){
				
				if(!campo.isEmpty()) {
					statement.setString(1, "%" + campo + "%");
				}
				
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet) {
					while(resultSet.next()) {
						Huesped fila = new Huesped(
								resultSet.getLong("id"), 
								resultSet.getString("nombre"), 
								resultSet.getString("apellido"), 
								resultSet.getString("fecha_nacimiento"), 
								resultSet.getString("nacionalidad"),
								resultSet.getString("telefono"),
								resultSet.getLong("id_reserva")
								);
						
						resultado.add(fila);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return resultado;
	}

public int modificar(String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String telefono, Long id) {
	
	try {			

		final PreparedStatement statement = con.prepareStatement("UPDATE huespedes SET "
				+ "nombre = ?, "
				+ "apellido = ?, "
				+ "fecha_nacimiento = ?, "
				+ "nacionalidad = ?, "
				+ "telefono = ? "
				+ "WHERE id = ?");
		
		try(statement) {
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setString(3, fecha_nacimiento);
			statement.setString(4, nacionalidad);
			statement.setString(5, telefono);
			statement.setLong(6, id);
			
			statement.execute();	
			
			int updateCount = statement.getUpdateCount();
						
			return updateCount;
		}
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
	
}

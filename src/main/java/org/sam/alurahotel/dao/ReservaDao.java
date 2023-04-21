package org.sam.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sam.alurahotel.factory.ConnectionFactory;
import org.sam.alurahotel.modelo.Reserva;

public class ReservaDao {
	
	final private Connection con;

	public ReservaDao(Connection con) {
		this.con = con;
	}
	
	public void guardar(Reserva reserva) {
		
		try {
			final PreparedStatement statement = con.prepareStatement("INSERT INTO reservas(fecha_entrada, fecha_salida, valor, forma_pago)"
					+ " VALUES(?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				
				ejecutarReserva(reserva, statement);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void ejecutarReserva(Reserva reserva, PreparedStatement statement) throws SQLException {
		
		statement.setString(1,  reserva.getFechaEntrada());
		statement.setString(2, reserva.getFechaSalida());
		statement.setLong(3, reserva.getValor());
		statement.setString(4, reserva.getFormaPago());
		
		statement.execute();
		
		final ResultSet resultSet = statement.getGeneratedKeys();
		
		try(resultSet){
			while(resultSet.next()) {
				reserva.setId(resultSet.getLong(1));
				System.out.println(String.format("Fue insertado el producto %s", reserva));
			}
		}
		
	}
	
	public List<Reserva> listarReservas(String campo){
		
		List<Reserva> resultado = new ArrayList<>();
		
		ConnectionFactory factory = new ConnectionFactory();
		
		final Connection con = factory.recupetaConexion();
		
		try(con){
			
			var querySelect = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas ";
			
			if (!campo.isEmpty()) {
				querySelect += "WHERE id = ? ";
			}
			
				querySelect += "ORDER BY id DESC; ";
			
			System.out.println(querySelect);
			
			final PreparedStatement statement = con.prepareStatement(querySelect);
			
			try(statement){
				
				if (!campo.isEmpty()) {
					statement.setLong(1, Long.valueOf(campo));
				}
				
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet) {
					while(resultSet.next()) {
						Reserva fila = new Reserva(
								resultSet.getLong("id"), 
								resultSet.getString("fecha_entrada"), 
								resultSet.getString("fecha_salida"), 
								resultSet.getLong("valor"), 
								resultSet.getString("forma_pago")
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
}

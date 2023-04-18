package org.sam.alurahotel.modelo;

import java.time.LocalDate;
import java.util.List;

public class Reserva {	
	
	private Long id;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private Long valor;
	private String formaPago;
	private List<Huesped> huespedes;
		
	public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Long valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	@Override
	public String toString() {
		return "Reserva [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", valor=" + valor
				+ ", formaPago=" + formaPago + "]";
	}
	
	
	
}

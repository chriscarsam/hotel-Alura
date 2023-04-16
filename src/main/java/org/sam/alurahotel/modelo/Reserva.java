package org.sam.alurahotel.modelo;

import java.time.LocalDate;
import java.util.List;

public class Reserva {
	
	private Long id;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private Long valor;
	private String formaPafo;
	private List<Huesped> huespedes;
		
	
}

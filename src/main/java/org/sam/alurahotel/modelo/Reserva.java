package org.sam.alurahotel.modelo;

import java.time.LocalDate;
import java.util.List;

public class Reserva {	
	
	private Long id;
	private String fechaEntrada;
	private String fechaSalida;
	private Long valor;
	private String formaPago;
	private List<Huesped> huespedes;
		
	public Reserva(String fechaEntrada, String fechaSalida, Long valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}	

	public Reserva(Long id, String fechaEntrada, String fechaSalida, Long valor, String formaPago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public List<Huesped> getHuespedes() {
		return huespedes;
	}

	public void setHuespedes(List<Huesped> huespedes) {
		this.huespedes = huespedes;
	}
	
	@Override
	public String toString() {
		return "Reserva [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", valor=" + valor
				+ ", formaPago=" + formaPago + "]";
	}
	
}

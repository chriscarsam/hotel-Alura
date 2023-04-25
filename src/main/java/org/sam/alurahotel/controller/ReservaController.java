package org.sam.alurahotel.controller;

import java.util.List;

import org.sam.alurahotel.dao.ReservaDao;
import org.sam.alurahotel.factory.ConnectionFactory;
import org.sam.alurahotel.modelo.Reserva;

public class ReservaController {

	private ReservaDao reservaDao;
	
	public ReservaController() {
		this.reservaDao = new ReservaDao(new ConnectionFactory().recupetaConexion());
	}
	
	public void guardar(Reserva reserva) {
		reservaDao.guardar(reserva);
	}
	
	public List<Reserva> listar(String campo) {
		return reservaDao.listarReservas(campo);
	}
	
	public int modificar(String fecha_entrada, String fecha_salida, Double valor, String forma_pago, Long id){
		return reservaDao.modificar(fecha_entrada, fecha_salida, valor, forma_pago, id);	
	}
}

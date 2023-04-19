package org.sam.alurahotel.controller;

import java.util.List;

import org.sam.alurahotel.dao.HuespedDao;
import org.sam.alurahotel.factory.ConnectionFactory;
import org.sam.alurahotel.modelo.Huesped;

public class HuespedController {

	private HuespedDao huespedDao;
	
	public HuespedController() {
		this.huespedDao = new HuespedDao(new ConnectionFactory().recupetaConexion());
	}
	
	public void guardar(Huesped huesped) {
		huespedDao.guardar(huesped);
	}
	
	public List<Huesped> listar() {
		return huespedDao.listarHuespedes();
	}
}

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
	
	public List<Huesped> listar(String campo) {
		return huespedDao.listarHuespedes(campo);
	}

	public int modificar(String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String telefono, Long id){
		return huespedDao.modificar(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id);	
	}
}

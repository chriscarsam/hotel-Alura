package org.sam.alurahotel.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import org.sam.alurahotel.factory.ConnectionFactory;

public class PruebaConexion {

	 public static void main(String[] args) throws SQLException {
	    	Connection con = new ConnectionFactory().recupetaConexion();		

	        System.out.println("Cerrando la conexión");

	        con.close();
	    }
	 
}

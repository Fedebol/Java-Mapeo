package com.boldrini.federico.reunion;

import java.util.List;

import com.boldrini.federico.reunion.dao.SalaDao;
import com.boldrini.federico.reunion.dominio.Sala;

public class AppConsultas {
	
	public static void main (String [] args) {
		SalaDao salaDao = new SalaDao();
		
		List<Sala> salasPara4 = salaDao.findSalasParaN(4);
		System.out.println("Salas para 4: " + salasPara4);
		
		List<Sala> salasPara3 = salaDao.findSalasParaN(3);
		System.out.println("Salas para 4: " + salasPara3);
	}

}

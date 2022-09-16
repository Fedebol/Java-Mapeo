package com.boldrini.federico.reunion;

import java.util.List;

import com.boldrini.federico.reunion.dao.ActaDao;
import com.boldrini.federico.reunion.dominio.Acta;

public class AppActas {

	public static void main(String[] args) {
		ActaDao actaDao = new ActaDao();
		List<Acta> actasAntiguas = actaDao.findActasReunionesAntiguasQuery();
		System.out.println("Actas antiguas: " + actasAntiguas);

		List<Acta> actasAntiguas2 = actaDao.findActasReunionesAntiguasCriteria();
		System.out.println("Actas antiguas: " + actasAntiguas2);

	}

}

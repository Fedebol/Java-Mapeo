package com.boldrini.federico.reunion;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.NoResultException;

import com.boldrini.federico.reunion.dao.ReunionDao;
import com.boldrini.federico.reunion.dominio.Reunion;
import com.boldrini.federico.reunion.dao.AbstracDao;
import com.boldrini.federico.reunion.dao.ActaDao;
import com.boldrini.federico.reunion.dao.SalaDao;
import com.boldrini.federico.reunion.dominio.Acta;
import com.boldrini.federico.reunion.dominio.Persona;
import com.boldrini.federico.reunion.dominio.Sala;

public class App 
{
    public static void main(String[] args){
		ReunionDao reunionDao = new ReunionDao();
		ActaDao actaDao = new ActaDao();
		SalaDao salaDao = new SalaDao();

		// Creación de objetos
		
		Sala s109 = new Sala("S109", "Entrevistas primera planta", 3);
		
		salaDao.save(s109);
	
		Persona luisa = new Persona("E001", "Luisa", "Gutiérrez González");

		Reunion r0 = new Reunion(LocalDateTime.now(), "Reunión de Test");
	
		r0.addParticipante(Luisa);
		r0.setSala(s109);
		reunionDao.save(r0);
		Acta a0 = new Acta("Luisa se reúne sola", r0);
		actaDao.save(a0);
		reunionDao.update(r0);
	
		// Recuperación de datoss
		List<Reunion> reuniones = reunionDao.getAll();
		System.out.println("Todas las reuniones: " + reuniones);

		try {
			System.out.println("Tu próxima reunión es: " + reunionDao.proximaReunion());
		} catch (NoResultException nre) {
			System.out.println("No tienes ninguna reunión a la vista");
		}
		List<Reunion> reunionesManana = reunionDao.reunionesManana();
		System.out.println("Para mañana: " + reunionesManana);

	}
}

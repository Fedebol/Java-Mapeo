package com.boldrini.federico.reunion;



import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.boldrini.federico.reunion.dao.PersonaDao;
import com.boldrini.federico.reunion.dominio.Acta;
import com.boldrini.federico.reunion.dominio.Persona;
import com.boldrini.federico.reunion.dominio.Reunion;
import com.boldrini.federico.reunion.dominio.Sala;



public class AppTodoPersona {

	public static void main(String[] args) {
		PersonaDao personaDao = new PersonaDao();

		Optional<Persona> optPersona = personaDao.get(1);
		if (optPersona.isPresent()) {
			Persona p = optPersona.get();
			System.out.println("Persona: " + p);

			Set<Reunion> reuniones = p.getReunion();
			System.out.println("Reuniones: " + reuniones);

			Set<Sala> salas = new HashSet();
			Set<Persona> compis = new HashSet();
			Set<Acta> actas = new HashSet();
			for (Reunion reunion : reuniones) {
				salas.add(reunion.getSala());
				compis.addAll(reunion.getParticipantes());
				actas.add(reunion.getActa());
			}
			System.out.println("Salas: " + salas);
			System.out.println("Compis: " + compis);
			System.out.println("Actas: " + actas);

		}
	}

}


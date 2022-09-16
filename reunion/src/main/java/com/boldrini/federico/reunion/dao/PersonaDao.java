package com.boldrini.federico.reunion.dao;

import com.boldrini.federico.reunion.dominio.Persona;

public class PersonaDao extends AbstracDao<Persona>{

	public PersonaDao() {
		setClazz(Persona.class);
	}
}

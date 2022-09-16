package com.boldrini.federico.reunion.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String numeroEmpleado;
	
	private String nombre;
	private String apellido;
	
	@ManyToMany
	private Set<Reunion> reuniones;
	
	public Set<Reunion> getReunion() {
		return reuniones;
	}

	public void addReunion(Reunion reunion) {
		reuniones.add(reunion);
		if(!reunion.getParticipantes().contains(this)){
			reunion.addParticipante(this);
		}
	}
	
	

	public Persona() {
		reuniones = new HashSet();
	}

	public Persona(String numeroEmpleado, String nombre, String apellido) {
		this();
		this.numeroEmpleado = numeroEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	


	@Override
	public String toString() {
		return "Persona [id=" + id + ", numeroEmpleado=" + numeroEmpleado + ", nombre=" + nombre + ", apellido="
				+ apellido + "]";
	}
}

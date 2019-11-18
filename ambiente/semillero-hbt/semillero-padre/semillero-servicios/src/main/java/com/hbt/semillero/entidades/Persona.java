/**
 * Persona.java
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad persona
 * <b>Caso de Uso:<b> 
 * @author Cesar
 * @version 
 */
@Entity
@Table(name = "TC_PERSONA")
public class Persona implements Serializable {

	/**
	 * Atributo que determina  el serializado de la clase
	 */
	private static final long serialVersionUID = -8125585681165136154L;

	/**
	 * id de la persona
	 */
	private Long id;
	/**
	 * nombre de la persona
	 */
	private String nombre;
	/**
	 * numero de identificacion de la persona
	 */
	private Long numIdentificacion;
	
	/**
	 * Constructor de la clase.
	 */
	public Persona() {
	}
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SPID")
	public Long getId() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SCNOMBRE")
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo numIdentificacion
	 * @return El numIdentificacion asociado a la clase
	 */
	@Column(name = "SCNUMIDENTIFICACION")
	public Long getNumIdentificacion() {
		return numIdentificacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo numIdentificacion
	 * @param numIdentificacion El nuevo numIdentificacion a modificar.
	 */
	public void setNumIdentificacion(Long numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	
	
	
}

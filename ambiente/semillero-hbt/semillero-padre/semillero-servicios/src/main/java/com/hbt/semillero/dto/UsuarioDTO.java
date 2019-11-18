/**
 * PersonaDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Cesar
 * @version 
 */
public class UsuarioDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1052198432091617689L;
	private Long id;
	private String nombre;
	private LocalDate fechaCreacion;
	private String estado;	
	private Long idPersona;
	
	/**
	 * Constructor de la clase.
	 */
	public UsuarioDTO() {
	}
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param fechaCreacion
	 * @param estado
	 * @param idPersona
	 */
	public UsuarioDTO(Long id, String nombre, LocalDate fechaCreacion, String estado, Long idPersona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.idPersona = idPersona;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
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
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo idPersona
	 * @return El idPersona asociado a la clase
	 */
	public Long getIdPersona() {
		return idPersona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado
				+ ", idPersona=" + idPersona + "]";
	}
	
	
}

/**
 * Usuario.java
 */
package com.hbt.semillero.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Cesar
 * @version 
 */
@Entity
@Table(name = "TC_USUARIO")
public class Usuario {

	/**
	 * id del usuario
	 */
	private Long id;
	/**
	 * nombre del usuario
	 */
	private String nombre;
	/**
	 * fecha de creacion del usuario
	 */
	private LocalDate fechaCreacion;
	/**
	 * estado del usuario
	 */
	private EstadoUsuarioEnum estado;
	/**
	 * persona asociada al usuario
	 */
	@OneToOne
	private Persona persona;
	
	
	/**
	 * Constructor de la clase.
	 */
	public Usuario() {
	}
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SUID")
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
	@Column(name = "SUNOMBRE")
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
	@Column(name = "SUFECHA_CREACION")
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
	@Column(name = "SUESTADO")
	@Enumerated(value = EnumType.STRING)
	public EstadoUsuarioEnum getEstado() {
		return estado;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoUsuarioEnum estado) {
		this.estado = estado;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo persona
	 * @return El persona asociado a la clase
	 */
	@Column(name = "SUIDPERSONA")
	public Persona getPersona() {
		return persona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo persona
	 * @param persona El nuevo persona a modificar.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}

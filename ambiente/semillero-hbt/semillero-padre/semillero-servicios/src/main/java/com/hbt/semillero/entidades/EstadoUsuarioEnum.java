/**
 * EstadoUsuarioEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina los estados de un usuario
 * <b>Caso de Uso:<b> 
 * @author Cesar
 * @version 
 */
public enum EstadoUsuarioEnum {

	ACTIVO("enum.usuario.activo"),
	INACTIVO("enum.usuario.inactivo");
	
	private String codigoMensaje;
	
	/**
	 * Constructor de la clase.
	 * @param codigoMensaje
	 */
	private EstadoUsuarioEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigoMensaje
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigoMensaje
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
}

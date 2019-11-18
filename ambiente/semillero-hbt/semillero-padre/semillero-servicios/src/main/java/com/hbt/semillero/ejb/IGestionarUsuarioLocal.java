/**
 * IGestionarUsuarioLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;
import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.UsuarioDTO;

/**
 * <b>Descripción:<b> Clase que determina la interfaz local del bean de gestionar usuario
 * <b>Caso de Uso:<b> 
 * @author Cesar
 * @version 
 */
@Local
public interface IGestionarUsuarioLocal {

	/**
	 * 
	 * Metodo encargado de crear a una persona inicialmente <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param personaDTO
	 */
	public void crearPersona(PersonaDTO personaDTO);

	/**
	 * 
	 * Metodo encargado de consultar todas las personas <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @return
	 */
	public List<PersonaDTO> consultarPersonas() ;
	/**
	 * 
	 * Metodo encargado de obtener a la persona <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idPersona
	 * @return
	 */
	public PersonaDTO consultarPersona(Long idPersona) ;
	
	/**
	 * 
	 * Metodo encargado de consultar todas las personas <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarios();

	/**
	 * 
	 * Metodo encargado de crear un usuario a partir de un usuario DTO <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param usuarioDTO
	 * @throws Exception
	 */
	public void crearUsuario(UsuarioDTO usuarioDTO) throws Exception;
	/**
	 * 
	 * Metodo encargado de consultar un usuario <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idUsuario
	 * @return
	 */
	public UsuarioDTO consultarUsuario(Long idUsuario) ;
	/**
	 * 
	 * Metodo encargado de modificar un usuario a partir de un usuarioDTO modificado
	 * <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param usuarioDTOModificado
	 */
	public void modificarUsuario(UsuarioDTO usuarioDTOModificado);

	/**
	 * 
	 * Metodo encargado de eliminar un usuario de acuerdo al id provisto <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idUsuario
	 */
	public void eliminarUsuario(Long idUsuario) ;

	/**
	 * 
	 * Metodo encargado de validar si la fecha de creacion de un usuario es menor a un año
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param idUsuario
	 * @return verdadero si el usuario se creo hace menos de un año, falso de lo contrario
	 */
	public Boolean validarEstado(Long idUsuario);
	/**
	 * 
	 * Metodo encargado de generar un nombre unico utilizando la estructura
	 * solicitada <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @return
	 */
}

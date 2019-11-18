/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.ejb.IGestionarUsuarioLocal;
import com.hbt.semillero.entidades.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que se utiliza para que gestionarUsuarioBean se
 * comunique con el mundo exterior <b>Caso de Uso:<b>
 * 
 * @author Cesar Cardozo
 * @version
 */
@Path("/GestionarUsuarios")
public class GestionarUsuariosRest {

	/**
	 * Atriburo que permite gestionar un comic
	 */
	@EJB
	private IGestionarUsuarioLocal gestionarUsuarioEJB;

	/**
	 * 
	 * Metodo encargado de ser el servicio que consulta personas <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas() {
		return gestionarUsuarioEJB.consultarPersonas();
	}

	/**
	 * 
	 * Metodo encargado de de ser el servicio que consulta una persona deacuerdo al
	 * id provisto <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idPersona
	 * @return
	 */
	@GET
	@Path("/consultarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarPersona(@QueryParam("idPersona") Long idPersona) {
		if (idPersona != null) {
			PersonaDTO personaDTO = gestionarUsuarioEJB.consultarPersona(idPersona);
			return personaDTO;
		}
		return null;
	}

	/**
	 * 
	 * Metodo encargado de ser el servicio que consulta usuarios <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> consultarUsuarios() {
		return gestionarUsuarioEJB.consultarUsuarios();
	}

	/**
	 * 
	 * Metodo encargado de ser el servicio que consulta un usuario deacuerdo al id
	 * provisto <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idUsuario
	 * @return
	 */
	@GET
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO consultarUsuario(@QueryParam("idUsuario") Long idUsuario) {
		if (idUsuario != null) {
			UsuarioDTO usuarioDTO = gestionarUsuarioEJB.consultarUsuario(idUsuario);
			return usuarioDTO;
		}
		return null;
	}

	/**
	 * 
	 * Metodo encargado de crear una persona y posteriormente un usuario y los
	 * asocia <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param personaDTO
	 * @param usuarioDTO
	 * @return si se pudo o no crear la persona y el usuario y la unica excepcion
	 *         posible conocida que es la de la fecha de creacion que excede la
	 *         fecha actual
	 */
	@POST
	@Path("/crearUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearUsuario(PersonaDTO personaDTO) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(personaDTO.getId());
		usuarioDTO.setFechaCreacion(LocalDate.of(1999, 10, 10));
		usuarioDTO.setIdPersona(personaDTO.getId());
		usuarioDTO.setEstado(EstadoEnum.ACTIVO.name());
		usuarioDTO.setIdPersona(personaDTO.getId());
		try {
			gestionarUsuarioEJB.crearPersona(personaDTO);
			// se asocian la persona y el usuario
			gestionarUsuarioEJB.crearUsuario(usuarioDTO); // el nombre se autogenera dentro de la creacion de usuario
			return new ResultadoDTO(Boolean.TRUE, usuarioDTO.toString() + "Persona y usuario, creados exitosamente");
		} catch (Exception e) {
			return new ResultadoDTO(Boolean.FALSE, usuarioDTO.toString() + "Fecha de creacion excede la fecha actual");
		}
	}

	/**
	 * 
	 * Metodo encargado ser el servicio de modificar el nombre del usuario provisto
	 * <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param usuarioDTO
	 */
	@POST
	@Path("/modificarUsuario")
	public void modificarUsuario(UsuarioDTO usuarioDTOModificado) {
		gestionarUsuarioEJB.modificarUsuario(usuarioDTOModificado);
	}

	/**
	 * 
	 * Metodo encargado de ser el servicio que inactiva a un usario <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idUsuario
	 */
	@GET
	@Path("/eliminarUsuario")
	public void eliminarUsuario(@QueryParam("idUsuario") Long idUsuario) {
		if (idUsuario != null) {
			gestionarUsuarioEJB.eliminarUsuario(idUsuario);
		}
	}

	/**
	 * 
	 * Metodo encargado de validar el estado de un usuario deacuerdo a si expiro o
	 * no <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idUsuario
	 * @return si el usuario ya expiro o no en conjunto con un mensaje
	 */
	@GET
	@Path("/validarUsuario")
	public ResultadoDTO validarUsuario(@QueryParam("idUsuario") Long idUsuario) {
		if (idUsuario != null) {
			if (gestionarUsuarioEJB.validarEstado(idUsuario)) {
				return new ResultadoDTO(Boolean.TRUE, "El usuario se encuentra activo");
			}
		}
		return new ResultadoDTO(Boolean.FALSE, "El usuario no se encuentra activo");
	}
}
/**
 * GestionarUsuarioBean.java
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidades.EstadoUsuarioEnum;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Usuario;

/**
 * <b>Descripción:<b> Clase que determina el bean que permite gestionar a usuarios y personas
 * en esta se crean los metodos de creacion y consulta de personas, junto con la creacion
 * edicion eliminacion y consulta de usuarios y tambien se tienen los metodos que permiten crear
 * los nombres de los usuarios deacuerdo a las condiciones provistas
 * 
 * @author Cesar Cardozo
 * @version
 */
@Stateless
public class GestionarUsuarioBean implements IGestionarUsuarioLocal{

	/**
	 * contexto de presistencia
	 */
	@PersistenceContext
	private EntityManager em;

//------------Persona-------------------------------------------------------
	/**
	 * 
	 * Metodo encargado de crear a una persona inicialmente <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param personaDTO
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
		Persona persona = crearPersonaFromPersonaDTO(personaDTO);
		em.persist(persona);
	}

	/**
	 * 
	 * Metodo encargado de consultar todas las personas <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosPersonasDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultados = em.createQuery("select p from Persona p").getResultList();
		for (Persona persona : resultados) {
			resultadosPersonasDTO.add(crearPersonaDTOFromPersona(persona));
		}
		return resultadosPersonasDTO;
	}

	/**
	 * 
	 * Metodo encargado de obtener a la persona <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idPersona
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonaDTO consultarPersona(Long idPersona) {
		return crearPersonaDTOFromPersona(em.find(Persona.class, idPersona));
	}

//------------Usuario-------------------------------------------------------

	/**
	 * 
	 * Metodo encargado de consultar todas las personas <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UsuarioDTO> consultarUsuarios() {
		List<UsuarioDTO> resultadosUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> resultados = em.createQuery("select u from Usuario u").getResultList();
		for (Usuario usuario : resultados) {
			resultadosUsuarioDTO.add(crearUsuarioDTOFromUsuario(usuario));
		}
		return resultadosUsuarioDTO;
	}

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
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearUsuario(UsuarioDTO usuarioDTO) throws Exception {
		// si la fecha de creacion es despues de la fecha actual salta una excepcion
		if (usuarioDTO.getFechaCreacion().isAfter(LocalDate.now())) {
			throw new Exception("La fecha de creacion no puede ser mayor a la fecha actual");
		}
		Usuario usuario = crearUsuarioFromUsuarioDTO(usuarioDTO);
		// se asigna el nombre de usuario deacuerdo a las condiciones solicitadas
		usuario.setNombre(this.generateUniqueName());
		em.persist(usuario);
	}

	/**
	 * 
	 * Metodo encargado de consultar un usuario <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idUsuario
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UsuarioDTO consultarUsuario(Long idUsuario) {
		return crearUsuarioDTOFromUsuario(em.find(Usuario.class, idUsuario));
	}

	/**
	 * 
	 * Metodo encargado de modificar un usuario a partir de un usuarioDTO modificado
	 * <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param usuarioDTOModificado
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarUsuario(UsuarioDTO usuarioDTOModificado) {
		Usuario usuarioAModificar = em.find(Usuario.class, usuarioDTOModificado.getId());
		usuarioAModificar.setNombre(usuarioDTOModificado.getNombre());
		em.merge(usuarioAModificar);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un usuario de acuerdo al id provisto <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param idUsuario
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarUsuario(Long idUsuario) {
		Usuario usuario = em.find(Usuario.class, idUsuario);
		usuario.setEstado(EstadoUsuarioEnum.INACTIVO); //se vuelve inactivo el usuario 
		em.merge(usuario);
	}

	/**
	 * 
	 * Metodo encargado de validar si la fecha de creacion de un usuario es menor a un año
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param idUsuario
	 * @return verdadero si el usuario se creo hace menos de un año, falso de lo contrario
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Boolean validarEstado(Long idUsuario) {
		Usuario usuario = em.find(Usuario.class, idUsuario);
		if (ChronoUnit.DAYS.between(usuario.getFechaCreacion(), LocalDate.now())>365) {
			usuario.setEstado(EstadoUsuarioEnum.INACTIVO);//se cambia el estado de usuario a inactivo si expiro
			em.persist(usuario);
			return false;
		}
		return true;
	}
	
// -----------Generacion-de-nombres-de-usuarios----------------------------------

	/**
	 * 
	 * Metodo encargado de generar un nombre unico utilizando la estructura
	 * solicitada <b>Caso de Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @return
	 */
	private String generateUniqueName() {
		List<UsuarioDTO> usuarios = consultarUsuarios();
		String posibleName = GestionarUsuarioBean.generateName();
		for (UsuarioDTO usuarioDTO : usuarios) {
			// si se encuentra un usuario con nombre igual se hace un llamdo recursivo al
			// metodo
			if (usuarioDTO.getNombre().equals(posibleName)) {
				return generateUniqueName();
			}
		}
		// si no se encontro un usuario con nombre igual se retorna el nombre generado.
		return posibleName;
	}

	/**
	 * Metodo encargado de generar un nombre de maximo 7 caracteres con el primero
	 * letra mayus, el segundo un digito y los demas en letras minusculas <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 */
	private static String generateName() {
		StringBuilder stringbuilder = new StringBuilder();
		Random r = new Random();
		stringbuilder.append((char) (r.nextInt(25) + 65));// se asigna la primera letra mayuscula
		stringbuilder.append(r.nextInt(9));// se asigna el numero del segundo digito
		for (int i = 0; i < r.nextInt(5); i++) { // se llenan maximo 5 caracteres de forma aleatoria
			stringbuilder.append((char) (r.nextInt(25) + 97));// se asignan letras minusculas
		}
		return stringbuilder.toString();
	}

//-------------Metodos de creacion de entiedades y dtos-----------------------------	
	/**
	 * Metodo encargado de crear una persona a partir de una personaDTO <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param personaDTO
	 * @return
	 */
	private Persona crearPersonaFromPersonaDTO(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if (personaDTO.getId() != null) {
			persona.setId(personaDTO.getId());
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setNumIdentificacion(personaDTO.getNumIdentificacion());
		return persona;
	}

	/**
	 * Metodo encargado de crear una personaDTO a partir de una persona <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param personaDTO
	 * @return
	 */
	private PersonaDTO crearPersonaDTOFromPersona(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if (persona.getId() != null) {
			personaDTO.setId(persona.getId());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumIdentificacion(persona.getNumIdentificacion());
		return personaDTO;
	}

	/**
	 * 
	 * Metodo encargado de crear un usuario DTO a partir de un usuario <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param usuario
	 * @return
	 */
	private UsuarioDTO crearUsuarioDTOFromUsuario(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		if (usuario.getId() != null) {
			usuarioDTO.setId(usuario.getId());
		}
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
		usuarioDTO.setEstado(usuario.getEstado().name());
		usuarioDTO.setIdPersona(usuario.getPersona().getId());
		return usuarioDTO;
	}

	/**
	 * Metodo encargado de crear un usuario a partir de un usuario DTO <b>Caso de
	 * Uso</b>
	 * 
	 * @author Cesar
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	private Usuario crearUsuarioFromUsuarioDTO(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		if (usuarioDTO.getId() != null) {
			usuario.setId(usuarioDTO.getId());
		}
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		usuario.setEstado(EstadoUsuarioEnum.valueOf(usuarioDTO.getEstado()));
		usuario.setPersona(em.find(Persona.class, usuarioDTO.getIdPersona()));
		return usuario;
	}

}

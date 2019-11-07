/**
 * GestionarComicRest.java
 */
package com.hbt.sermillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Cesar
 * @version 
 */
@Path("/GestionarComic")
public class GestionarComicRest {

	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	/**
	 * 
	 * Metodo encargado de realizar hola mundo de servicios ret
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @return
	 */
	@GET//tipo de envio
	@Path("/saludo") //ruta de acceso
	@Produces(MediaType.APPLICATION_JSON) //define el dato que se va a retornar
	public String primerRest() {
		return "hola mundo";
	}
	
	/**
	 * 
	 * Metodo encargado de recibir la petición para la consulta de un comic
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic") //ruta de acceso
	@Produces (MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if(idComic != null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}
}
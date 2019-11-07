/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

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
 * @author Viviana
 * @version 
 */

@Path("/GestionarComic")
public class GestionarComicRest {
	
	@EJB
	private IGestionarComicLocal iGestionarComicLocal;
	
	@GET
	@Path("/saludo")
	@Produces
	public String miPrimerRest() {
		return "Hola Mundo";
	}

	@GET
	@Path("/consultar")
	@Produces(MediaType.APPLICATION_JSON)
	@QueryParam("idComic")
	public ComicDTO consultarComic(Long  idComic) {
		if (idComic != null) {
			return iGestionarComicLocal.consultarComic(idComic.toString());
		}
		return null;
	}
}

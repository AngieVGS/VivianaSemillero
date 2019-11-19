/**
 * GestionarPersonaRest.java
 */
package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarPersonaLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest 
 * que permite gestionar Personas
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */
@Path("/GestionarPersonas")
public class GestionarPersonaRest {
	
	/**
	 *  Atriburo que permite gestionar Personas
	 */
	@EJB
	private IGestionarPersonaLocal gestionarPersonaEJB;
	
	/**
	 * Crea las personas.
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/crear
	 * @param persona
	 * @return
	 */
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	}
	
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic(PersonaDTO persona) {
		gestionarPersonaEJB.crearPersona(persona);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Persona creada exitosamente");
		return resultadoDTO;
		
	}
	
	
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(){
		return gestionarPersonaEJB.consultarPersonas();
	}
	

	@GET
	@Path("/consultarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarPersona(@QueryParam("pid") Long pid){
		if(pid != null) {
			return gestionarPersonaEJB.consultarPersona(pid.toString());
		}
		return null;
	}
	

}

/**
 * GestionarUsuarioRest.java
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

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.ejb.IGestionarPersonaLocal;
import com.hbt.semillero.ejb.IGestionarUsuarioLocal;


/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un usuario
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */
@Path("/GestionarUsuario")
public class GestionarUsuarioRest {

	/**
	 * Atriburo que permite gestionar un Usuario
	 */
	@EJB
	private IGestionarUsuarioLocal gestionarUsuarioEJB;
	
	
	/**
	 * 
	 * Metodo encargado de traer la lista de usuarios
	 * http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuarios
	 * 
	 * @param idUsuario
	 * @return
	 */
	@GET
	@Path("/consultarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> consultaUsuarios() {
		return gestionarUsuarioEJB.consultarUsuarios();

	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un Usuario determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuario?idUsuario=1
	 * 
	 * @param uid
	 * @return
	 */
	@GET
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO consultarUsuario(@QueryParam("uid") Long uid) {
		if (uid != null) {
			UsuarioDTO usuarioDTO = gestionarUsuarioEJB.consultarUsuario(uid.toString());
			return usuarioDTO;
		}
		return null;
	}
	
	/**
	 * Crea las Usuario 
	 * http://localhost:8085/semillero-servicios/rest/GestionarUsuario/crear
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearUsuario(UsuarioDTO usuarioDTO, PersonaDTO personaDTO) {
		try {
			usuarioDTO.setPersona(Long.parseLong(personaDTO.getPid()));
			gestionarUsuarioEJB.crearUsuario(usuarioDTO);
			return new ResultadoDTO(Boolean.TRUE, "El Usuario se han creado exitosamente");
		} catch (Exception e) {
			return new ResultadoDTO(Boolean.FALSE, "Fecha de creacion debe ser igual o anterios a la fecha actual");
		}
		
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un usuario
	 * http://localhost:8085/semillero-servicios/rest/GestionarUsuario/modificar?idUsuario=1&nombre=nuevonombre
	 * @param 
	 * @param 
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarUsuario(@QueryParam("uid") Long uid, @QueryParam("nombre") String nombre) {
		try {
			gestionarUsuarioEJB.modificarUsuario(uid, nombre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Metodo encargado de cambiar estado de un usuario dado el id
	 * 
	 * @param uid identificador del usuario
	 */
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarUsuario(@QueryParam("uid") Long uid) {
		if (uid != null) {
			gestionarUsuarioEJB.eliminarUsuario(uid);
		}
	}
	
}

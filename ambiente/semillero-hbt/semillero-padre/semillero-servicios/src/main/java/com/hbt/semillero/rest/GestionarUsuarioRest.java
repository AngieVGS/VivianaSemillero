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

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UsuarioDTO;
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
	 * Atriburo que permite gestionar un comic
	 */
	@EJB
	private IGestionarUsuarioLocal gestionarUsuarioEJB;
	
	
	/**
	 * 
	 * Metodo encargado de traer la lista de usuarios
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> consultaUsuarios() {
		return gestionarUsuarioEJB.consultarUsuarios();

	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComic?idComic=1
	 * 
	 * @param uid
	 * @return
	 */
	@GET
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO consultarComic(@QueryParam("uid") Long uid) {
		if (uid != null) {
			UsuarioDTO usuarioDTO = gestionarUsuarioEJB.consultarUsuario(uid.toString());
			return usuarioDTO;
		}
		return null;
	}
	
	/**
	 * Crea las Usuario 
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/crear
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearUsuario(UsuarioDTO usuarioDTO) {
		gestionarUsuarioEJB.crearUsuario(usuarioDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Usuario creado exitosamente");
		return resultadoDTO;
		
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un usuario
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar?idComic=1&nombre=nuevonombre
	 * @param 
	 * @param 
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarComic(@QueryParam("uid") Long uid, @QueryParam("nombre") String nombre) {
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
	@Path("/cambiarEstado")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarComic(@QueryParam("uid") Long uid) {
		if (uid != null) {
			gestionarUsuarioEJB.cambiarEstadoUsuario(uid);
		}
	}
	
}

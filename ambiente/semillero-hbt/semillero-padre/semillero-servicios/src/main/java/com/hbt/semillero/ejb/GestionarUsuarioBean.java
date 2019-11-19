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
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.From;

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.Persona;
import com.hbt.semillero.entidad.Usuario;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarUsuarioBean  implements IGestionarUsuarioLocal{

	/**
	 * Atributo em que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearUsuario(com.hbt.semillero.dto.UsuarioDTO)
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearUsuario(UsuarioDTO usuarioDTO) {
		if (ChronoUnit.DAYS.between(usuarioDTO.getFechaDeCreacion(), LocalDate.now()) < 0) {
			Usuario usuario = convertirUsuarioDTOToUsuario(usuarioDTO);
			em.persist(usuario);	
		}
		
	}



	/** 
	 * @throws Exception 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#modificarUsuario(java.lang.Long, java.lang.String)
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarUsuario(Long uid, String nombre) throws Exception {
		Usuario modificar = em.find(Usuario.class, uid);
		if (!existeNombre(nombre)) {
			modificar.setNombreDeUsuario(nombre);
			em.merge(modificar);
		}else {
			throw new Exception("El nombre de usuario ya existe");
		}
	}

	private boolean existeNombre(String nombreUsuario) {
		List<UsuarioDTO> usuarios = consultarUsuarios();
		for (UsuarioDTO usuarioDTO : usuarios) {
			if (usuarioDTO.getNombreDeUsuario().equals(nombreUsuario)) {
				return true;
			}
		}
		return false;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#cambiarEstadoUsuario(java.lang.Long)
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)	
	public void cambiarEstadoUsuario(Long uid) {
		Usuario usuario = em.find(Usuario.class, uid);
		if (usuario != null) {
			if (usuario.getEstado().equals(EstadoEnum.ACTIVO)) {
				usuario.setEstado(EstadoEnum.INACTIVO);
			}else if (usuario.getEstado().equals(EstadoEnum.INACTIVO)) {
				usuario.setEstado(EstadoEnum.ACTIVO);
			}
			em.merge(usuario);
		}
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarComic(java.lang.String)
	 */
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UsuarioDTO consultarUsuario(String uid) {
		Usuario usuario = new Usuario();
		usuario = em.find(Usuario.class, Long.parseLong(uid));
		return convertirUsuarioToUsuarioDTO(usuario);
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarComics()
	 */
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UsuarioDTO> consultarUsuarios() {
		List<UsuarioDTO> resultadosUsuariosDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> resultado = em.createQuery("select u from TC_USUARIO u").getResultList();
		for (Usuario usuario : resultado) {
			resultadosUsuariosDTO.add(convertirUsuarioToUsuarioDTO(usuario));
		}
		return resultadosUsuariosDTO;
	}

	/**
	 * Metodo encargado de Usuario a UsuarioDTO
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @return
	 */
	
	private UsuarioDTO convertirUsuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		if (usuario.getUid() != null) {
			usuarioDTO.setUid(usuario.getUid());
		}
		usuarioDTO.setNombreDeUsuario(usuario.getNombreDeUsuario());
		usuarioDTO.setFechaDeCreacion(usuario.getFechaDeCreacion());
		usuarioDTO.setPersona(usuarioDTO.getPersona());
		usuarioDTO.setEstado(usuario.getEstado());
		return usuarioDTO;
	}

	/**
	 * Metodo encargado de Usuario a UsuarioDTO
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @return
	 */
	private Usuario convertirUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		if (usuarioDTO.getUid() != null) {
			usuario.setUid(usuario.getUid());
		}
		usuario.setNombreDeUsuario(usuarioDTO.getNombreDeUsuario());
		usuario.setFechaDeCreacion(usuarioDTO.getFechaDeCreacion());
		usuario.setPersona(em.find(Persona.class, usuarioDTO.getUid()));
		usuario.setEstado(usuarioDTO.getEstado());
		return usuario;
	}



	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#eliminarUsuario(java.lang.Long)
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminarUsuario(Long uid) {
		Usuario usuario = em.find(Usuario.class, uid);
		usuario.setEstado(EstadoEnum.INACTIVO); 
		em.persist(usuario);
	}



	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#activarUsuario(java.lang.Long)
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void activarUsuario(Long uid) {
		Usuario usuario = em.find(Usuario.class, uid);
		usuario.setEstado(EstadoEnum.ACTIVO); 
		em.persist(usuario);
	}



	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#validarEstadoDelUsuario(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean validarEstadoDelUsuario(Long uid) {
		Usuario usuario = em.find(Usuario.class, uid);
		if (ChronoUnit.DAYS.between(usuario.getFechaDeCreacion(), LocalDate.now())>365) {
			usuario.setEstado(EstadoEnum.INACTIVO);
			em.persist(usuario);
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * Metodo encargado de generar un nombre de Usuario
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @return
	 */
	
	private  String generarNombreUsuario(){
		StringBuilder nombreUsuario = new StringBuilder();
		Random numeroAleatorio = new Random();
		nombreUsuario.append((char) (numeroAleatorio.nextInt(25) + 65));
		nombreUsuario.append(numeroAleatorio.nextInt(9));
		for (int i = 0; i < numeroAleatorio.nextInt(5); i++) { 
			nombreUsuario.append((char) (numeroAleatorio.nextInt(25) + 97));
		}
		return nombreUsuario.toString();
	}
}

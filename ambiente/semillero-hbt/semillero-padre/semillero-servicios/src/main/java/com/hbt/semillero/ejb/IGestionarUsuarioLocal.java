/**
 * IGestionarUsuarioLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.UsuarioDTO;

/**
 * <b>Descripción:<b> Clase que determina el bean
 *  para realizar la gestion de los usuarios
 * @author Viviana
 * @version 
 */

public interface IGestionarUsuarioLocal {
	/**
	 * 
	 * Metodo encargado de un usuario y persistirlo
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @param usuarioDTO informacion nueva a crear
	 */
	public void crearUsuario(UsuarioDTO usuarioDTO);

	/**
	 * 
	 * Metodo encargado de  modificar el nombre del usuario.
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @param uid
	 * @param nombre
	 * @throws Exception 
	 */
	public void modificarUsuario(Long uid, String nombre) throws Exception;

	/**
	 * 
	 * Metodo encargado de cambiar el estado deL Usuario
	 * esto por que el usuario no puede ser eliminado.
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @param uid
	 */
	public void cambiarEstadoUsuario(Long uid);

	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @return Usuario Resultado de la consulta
	 * @throws Exception si no se recibe uid
	 */
	public UsuarioDTO consultarUsuario(String uid);

	/**
	 * 
	 * Metodo encargado de retornar una lista de usuarios
	 * 
	 * @return lista de usuarios
	 */
	public List<UsuarioDTO> consultarUsuarios();


}
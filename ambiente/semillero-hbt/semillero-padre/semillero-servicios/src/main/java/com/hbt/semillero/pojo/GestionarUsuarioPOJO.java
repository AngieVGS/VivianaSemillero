/**
 * GestionarUsuarioPOJO.java
 */
package com.hbt.semillero.pojo;

import java.util.List;

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidad.EstadoEnum;


/**
 * <b>Descripción:<b>Clase que determina el uso de metodos para manipular
 * informacion POJO «Plain Old Java Object», que puede interpretarse como «Un
 * objeto Java Plano». Es una instancia de una clase que no extiende ni
 * implementa nada en particular. 
 * @author Viviana
 * @version 
 */
public class GestionarUsuarioPOJO {

	/**
	 * Lista que permite reunir un conjunto de usuarios
	 */
	private List<UsuarioDTO> listaUsuarios= null;

	public void crearUsuario() {

	}
	/**
	 * 
	 * Metodo encargado de modificar Usuario
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @param usuarioModificar
	 */

	public void modificarUsuarioDTO(UsuarioDTO usuarioModificar) {
		if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
			int i = 0;
			while ( i <= listaUsuarios.size()) {
				if (listaUsuarios.get(i).getUid().equals(usuarioModificar.getUid())) {
					listaUsuarios.get(i).setNombreDeUsuario(usuarioModificar.getNombreDeUsuario());
				}
				i++;
			}
		}
	}
/**
 * 
 * Metodo encargado de cambiar el estado de un usuario
 * <b>Caso de Uso</b>
 * @author Viviana
 * 
 * @param usuarioDTO
 */
	
	public void cambiarDeEstadoUsuarioDTO(UsuarioDTO usuarioDTO) {
		if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
			for (UsuarioDTO usuario : listaUsuarios) {
				if (usuario.getUid().equals(usuarioDTO.getUid())) {
					if (usuario.getEstado().equals(EstadoEnum.ACTIVO)) {
						usuario.setEstado(EstadoEnum.INACTIVO);
					}else if(usuario.getEstado().equals(EstadoEnum.INACTIVO)) {
						usuario.setEstado(EstadoEnum.ACTIVO);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * Metodo encargado de consultar un usuario por uid
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @param uid
	 * @return un usuario si coincide con el id o un null si no encuentra ningun usuario
	 */
	public UsuarioDTO consultarUsuarioDTO(String uid) {
		if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
			for (UsuarioDTO usuario : listaUsuarios) {
				if (usuario.getUid().equals(uid)) {
					return usuario;
				}	
			}
		}
		return null;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo listaUsuarios
	 * @return El listaUsuarios asociado a la clase
	 */
	public List<UsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo listaUsuarios
	 * @param listaUsuarios El nuevo listaUsuarios a modificar.
	 */
	public void setListaUsuarios(List<UsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	
}

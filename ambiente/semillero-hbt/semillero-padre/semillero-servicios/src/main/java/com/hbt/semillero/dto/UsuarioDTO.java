/**
 * UsuarioDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.entidad.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina el dto a usar para modificar,
 * consultar y posteriormente eliminar un usuario
 * @author Viviana
 * @version 
 */
public class UsuarioDTO implements Serializable{
	
	/**
	 * Atributo que determina
	 */
	private static final long serialVersionUID = 1L;
	
	private Long uid;
	private String nombreDeUsuario;
	private LocalDate fechaDeCreacion;
	private EstadoEnum estado;
	private Long idPersona;
	/**
	 * Metodo encargado de retornar el valor del atributo uid
	 * @return El uid asociado a la clase
	 */
	public Long getUid() {
		return uid;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo uid
	 * @param uid El nuevo uid a modificar.
	 */
	public void setUid(Long uid) {
		this.uid = uid;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo nombreDeUsuario
	 * @return El nombreDeUsuario asociado a la clase
	 */
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombreDeUsuario
	 * @param nombreDeUsuario El nuevo nombreDeUsuario a modificar.
	 */
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo fechaDeCreacion
	 * @return El fechaDeCreacion asociado a la clase
	 */
	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fechaDeCreacion
	 * @param fechaDeCreacion El nuevo fechaDeCreacion a modificar.
	 */
	public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstado() {
		return estado;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo persona
	 * @return El persona asociado a la clase
	 */
	public Long getPersona() {
		return idPersona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo persona
	 * @param persona El nuevo persona a modificar.
	 */
	public void setPersona(Long persona) {
		this.idPersona = persona;
	}
	
	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo ComicDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static UsuarioDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, UsuarioDTO.class);
	}
	
	/**
	 * Método encargado de convertir los datos recibidos en ComicDTO al JSON
	 * esperado
	 * 
	 * @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return "UsuarioDTO [uid=" + uid + ", nombreDeUsuario=" + nombreDeUsuario + ", fechaDeCreacion="
				+ fechaDeCreacion + ", estado=" + estado + ", persona=" + idPersona + "]";
	}
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaDeCreacion == null) ? 0 : fechaDeCreacion.hashCode());
		result = prime * result + ((nombreDeUsuario == null) ? 0 : nombreDeUsuario.hashCode());
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime * result + (int) (uid ^ (uid >>> 32));
		return result;
	}
	/** 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		if (estado != other.estado)
			return false;
		if (fechaDeCreacion == null) {
			if (other.fechaDeCreacion != null)
				return false;
		} else if (!fechaDeCreacion.equals(other.fechaDeCreacion))
			return false;
		if (nombreDeUsuario == null) {
			if (other.nombreDeUsuario != null)
				return false;
		} else if (!nombreDeUsuario.equals(other.nombreDeUsuario))
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	
	
	
	
}

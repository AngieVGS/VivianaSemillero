/**
 * PersonaDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * <b>Descripción:<b> Clase que determina el dto a
 *  usar para modificar consultar y posteriormente eliminar una persona 
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */
public class PersonaDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	
	private String pid; 
	private String nombre;
	private Long numeroIdentificacion;
	/**
	 * Metodo encargado de retornar el valor del atributo pid
	 * @return El pid asociado a la clase
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo pid
	 * @param pid El nuevo pid a modificar.
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo numeroIdentificacion
	 * @return El numeroIdentificacion asociado a la clase
	 */
	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo numeroIdentificacion
	 * @param numeroIdentificacion El nuevo numeroIdentificacion a modificar.
	 */
	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	
	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo PersonaDTO.
	 * <b>Caso de Uso:</b>
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static PersonaDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, PersonaDTO.class);
	}
	
	/** 
	 * Método encargado de convertir los datos recibidos en ComicDTO al JSON
	 * esperado
	 *  @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return "PersonaDTO [pid=" + pid + ", nombre=" + nombre + ", numeroIdentificacion=" + numeroIdentificacion + "]";
	}
	
	/** 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroIdentificacion == null) ? 0 : numeroIdentificacion.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
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
		PersonaDTO other = (PersonaDTO) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroIdentificacion == null) {
			if (other.numeroIdentificacion != null)
				return false;
		} else if (!numeroIdentificacion.equals(other.numeroIdentificacion))
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		return true;
	}
	
	

}

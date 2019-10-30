/**
 * EstadoEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */
public enum EstadoEnum {
	
	ACTIVO(),
	INACTIVO();

	/**
	 * Mensaje Descrptivo de enum
	 */
	private String codigoMensaje;
	
	/**
	 * Constructor de la clase.
	 */
	private EstadoEnum() {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * Constructor de la clase.
	 * @param codigoMensaje
	 */
	private EstadoEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo codigoMensaje
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigoMensaje
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}	
}

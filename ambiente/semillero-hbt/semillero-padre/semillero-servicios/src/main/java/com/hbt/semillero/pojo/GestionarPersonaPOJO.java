/**
 * GestionarPersonaPOJO.java
 */
package com.hbt.semillero.pojo;

import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonaDTO;

/**
 * <b>Descripción:<b> Clase que determina el uso de metodos para manipular
 * informacion POJO «Plain Old Java Object», que puede interpretarse como «Un
 * objeto Java Plano». Es una instancia de una clase que no extiende ni
 * implementa nada en particular
 * @author Viviana
 * @version 1.0
 */
public class GestionarPersonaPOJO {
	
	/**
	 *  Lista que permite reunir un conjunto de personas
	 */
	private List<PersonaDTO> listaDePersonas = null;
	 
	/**
	 * 
	 * Metodo encargado de crear una persona con informacion por defecto
	 * 
	 * @author Viviana
	 *
	 */
	public void crearPersonDTO() {
		// Se crea e instancia un objeto de tipo PersonaDTO
		PersonaDTO personaDTO = new PersonaDTO();
		//TO-DO
		
	}
	
	/**
	 * 
	 * Metodo encargado de retornar un comic dado un pid determinado 
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @param pid identificador de la persona a ser buscada
	 * @return persona encontrada
	 */
	
	public PersonaDTO consultarPersonaDTO(String pid) {
		if (listaDePersonas != null && !listaDePersonas.isEmpty()) {
			for (int i = 0; i < listaDePersonas.size(); i++) {
				if (listaDePersonas.get(i).getPid().equals(pid)) {
					return listaDePersonas.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaDePersonas
	 * @return El listaDePersonas asociado a la clase
	 */
	public List<PersonaDTO> getListaDePersonas() {
		return listaDePersonas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaDePersonas
	 * @param listaDePersonas El nuevo listaDePersonas a modificar.
	 */
	public void setListaDePersonas(List<PersonaDTO> listaDePersonas) {
		this.listaDePersonas = listaDePersonas;
	}
}

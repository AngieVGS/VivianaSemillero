/**
 * GestionarComicLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;

/**
 * 
 * Expone los métodos del EJB GestionarPersona Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements> 
 *
 * @author Viviana
 * @version 
 */
@Local
public interface IGestionarPersonaLocal {

	/**
	 * 
	 * Metodo encargado de crear una persona y persistirla
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @param persona
	 */
	public void crearPersona(PersonaDTO persona);
	
	/**
	 * 
	 * Metodo encargado de retornar la informacion de una persona
	 * 
	 * @param pid identificador de la persona a ser consultada
	 * @return persona Resultado de la consulta
	 * @throws Exception si no se recibe un PID
	 */
	public PersonaDTO consultarPersona(String pid);

	/**
	 * 
	 * Metodo encargado de retornar una lista de personas
	 * 
	 * @return
	 */
	public List<PersonaDTO> consultarPersonas();
	
}

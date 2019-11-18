/**
 * GestionarPersonaDTO.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.entidad.Persona;

/**
 * <b>Descripción:<b> Clase que determina el bean para realizar las gestion de
 * las personas
 *  
 * @author Viviana
 * @version 
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarPersonaBean implements IGestionarPersonaLocal {

	/**
	 * Atributo que se usa para interacturar con el contexto de persistencia.
	 */
	@PersistenceContext
	private EntityManager em;

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarPersonaLocal#crearPersona(com.hbt.semillero.dto.PersonaDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaNueva) {
		// Entidad nueva
		Persona persona = convertirPersonaDTOToPersona(personaNueva);
		// Se almacena la informacion y se maneja la enidad comic
		em.persist(persona);
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarPersonaLocal#consultarPersona(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonaDTO consultarPersona(String pid) {
		Persona persona = new Persona();
		persona = em.find(Persona.class, Long.parseLong(pid));
		PersonaDTO personaDTO = convertirPersonaToPersonaDTO(persona);
		return personaDTO;
	}

	
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarPersonaLocal#consultarPersonas()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosPersonaDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultado = em.createQuery("SELECT p FROM TC_PERSONA").getResultList();
		for (Persona persona:resultado) {
			resultadosPersonaDTO.add(convertirPersonaToPersonaDTO(persona));
		}
		return resultadosPersonaDTO;
	}

	/**
	 * 
	 * Metodo encargado de transformar un personaDTO a un persona
	 * 
	 * @param persona
	 * @return
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if(persona.getPid()!=null) {
			persona.setPid(Long.parseLong(personaDTO.getPid()));
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		return persona;
	}
	
	/**
	 * Metodo encargado de transformar una persona a una PersonaDTO
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 * 
	 * @param persona
	 * @return
	 */
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if (persona.getPid() != null) {
			personaDTO.setPid(persona.getPid().toString());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
		return personaDTO;
	}

}

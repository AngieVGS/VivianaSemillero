/**
 * Persona.java
 */
package com.hbt.semillero.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar la
 * tabla "DB_SEMILLERO"."COMIC"
 * 
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */
@Entity
@Table(name = "TC_PERSONA")
public class Persona implements Serializable{
	
	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. mediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	 
	private Long pid; 
	private String nombre;
	private Long numeroIdentificacion;
	
	
	
	/**
	 * Constructor de la clase.
	 */
	public Persona() {

	}


	/**
	 * Constructor de la clase.
	 * @param pid
	 * @param nombre
	 * @param numeroIdentificacion
	 */
	public Persona(Long pid, String nombre, Long numeroIdentificacion) {
		this.pid = pid;
		this.nombre = nombre;
		this.numeroIdentificacion = numeroIdentificacion;
	}


	@Id
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_SCPID_GENERATOR", sequenceName = "SEQ_PERSONA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SCPID_GENERATOR")
	@Column(name = "SCPID")
	public Long getPid() {
		return pid;
	}


	/**
	 * Metodo encargado de modificar el valor del atributo pid
	 * @param pid El nuevo pid a modificar.
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SCNOMBRE")
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
	@Column(name = "SCNUMIDENTIFICACION")
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
	 * @see java.lang.Object#toString() Metodo que permite asociar al objeto un
	 *      texto representativo
	 */
	@Override
	public String toString() {
		return "Persona [pid=" + pid + ", nombre=" + nombre + ", numeroIdentificacion=" + numeroIdentificacion + "]";
	}


	/** 
	 * @see java.lang.Object#hashCode() Este método viene a complementar al método
	 *      equals y sirve para comparar objetos de una forma más rápida en
	 *      estructuras Hash ya que únicamente nos devuelve un número entero. Cuando
	 *      Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet
	 *      etc) primero invoca al método hashcode y luego el equals
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
	 * @see java.lang.Object#equals(java.lang.Object) Metodo que permite comparar
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
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

/**
 * Usuario.java
 */
package com.hbt.semillero.entidad;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que determina la entidad que permite representar 
 * la tabla "DB_SEMILLERO"."TC_USUARIO " 
 * @author Viviana
 * @version 
 */
@Entity
@Table(name = "TC_USUARIO")
public class Usuario implements Serializable{

	/**
	 * Serializar es pasar un Objeto a un array de bytes y viceversa. Atributo que
	 * determina serialVersionUID es el id único que identifica una clase cuando lo
	 * serializamos. ;ediante este id podemos identificar el objeto convertido en un
	 * array de bytes.
	 */
	private static final long serialVersionUID = 1L;
	private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String abc = "abcdefghijklmnopqrstuvwxyz";
	private static String nameAUTO = "A0a" ;
	
	private Long uid;
	private String nombreDeUsuario;
	private LocalDate fechaDeCreacion;
	private EstadoEnum estado;
	private Long idpersona;

	/**
	 * Constructor de la clase.
	 */
	public Usuario() {
	}

	/**
	 * Metodo encargado de retornar el valor del atributo uid
	 * @return El uid asociado a la clase
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "USUARIO_SUID_GENERATOR", sequenceName = "SEQ_UID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SUID_GENERATOR")
	@Column(name = "SUID")
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
	@Column(name = "SUFECHA_CREACION")
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
	@Column(name ="SUESTADO")
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
	@Column(name = "SUIDPERSONA")
	public long getPersona() {
		return idpersona;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo persona
	 * @param persona El nuevo persona a modificar.
	 */
	public void setPersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [uid=" + uid + ", nombreDeUsuario=" + nombreDeUsuario + ", fechaDeCreacion=" + fechaDeCreacion
				+ ", estado=" + estado + ", idpersona=" + idpersona + "]";
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
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaDeCreacion == null) ? 0 : fechaDeCreacion.hashCode());
		result = prime * result + (int) (idpersona ^ (idpersona >>> 32));
		result = prime * result + ((nombreDeUsuario == null) ? 0 : nombreDeUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (estado != other.estado)
			return false;
		if (fechaDeCreacion == null) {
			if (other.fechaDeCreacion != null)
				return false;
		} else if (!fechaDeCreacion.equals(other.fechaDeCreacion))
			return false;
		if (idpersona != other.idpersona)
			return false;
		if (nombreDeUsuario == null) {
			if (other.nombreDeUsuario != null)
				return false;
		} else if (!nombreDeUsuario.equals(other.nombreDeUsuario))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

//	Generar nombre de usuario
//	private String generarNombreDeUsuario(){
//		Character uno = nameAUTO.charAt(0);
//		Character dos = nameAUTO.charAt(1);
//		String name = new String();
//		for (int i = 0; i < nameAUTO.length(); i++) {
//			if (nameAUTO.charAt(nameAUTO.length()-1) == 'z') {
//				
//			}
//		}
//
//	}
//	
}

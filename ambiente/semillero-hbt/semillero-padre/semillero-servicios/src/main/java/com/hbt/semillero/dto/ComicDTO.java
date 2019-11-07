package com.hbt.semillero.dto;
/**
 * 
 * <b>Descripción:<b> Clase que determina larepresentacion de los datos de un comic 
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.entidades.TematicaEnum;
public class ComicDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 7069004965618852673L;

	/**
	 * Identificador del comic o revista grafica
	 */
	private Long id;

	/**
	 * Nombre o titulo del comic o revista grafica
	 */
	private String nombre;
	/**
	 * Editorial comic o revista grafica
	 */
	private String editorial;
	/**
	 * Tematica del comic o revista grafica
	 */
	
	private String tematicaEnum;
	/**
	 * Coleccion del comic o revista grafica
	 */
	private String coleccion;
	/**
	 * Numero de Paginas del comic  revista grafica
	 */
	private Integer numeroDePaginas;
	/**
	 * Precio del comic o revista grafica
	 */
	private BigDecimal precio;
	/**
	 * Autor o revista grafica
	 */
	private String autor;
	/**
	 * Nombre o titulo del comic o revista grafica
	 */
	//-TODO

	private Boolean colores;
	/**
	 * Nombre o titulo del comic o revista grafica
	 */

	private LocalDate fechaVenta;
	/**
	 * Nombre o titulo del comic o revista grafica
	 */
	//-TODO

	private String estado;
	/**
	 * Nombre o titulo del comic o revista grafica
	 */
	private Long cantidad;

	/**
	 * 
	 * Constructor de la clase.
	 */
	public ComicDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroDePaginas
	 * @param precio
	 * @param autor
	 * @param colores
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 */
	public ComicDTO(Long id, String nombre, String editorial, String tematica, String coleccion,
			Integer numeroDePaginas, BigDecimal precio, String autor, Boolean colores, LocalDate fechaVenta,
			String estado, Long cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematicaEnum = tematica;
		this.coleccion = coleccion;
		this.numeroDePaginas = numeroDePaginas;
		this.precio = precio;
		this.autor = autor;
		this.colores = colores;
		this.fechaVenta = fechaVenta;
		this.estado = estado;
		this.cantidad = cantidad;
	}

	/**
	 * 
	 * Constructor de la clase.
	 * @param id -> identificador del Comic
	 * @param nombre -> Nombre del comic
	 */
	public ComicDTO(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Metodo encargado de retornar el valor del atributo editorial
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tematica
	 * @return El tematica asociado a la clase
	 */
	
	public String getTematicaEnum() {
		return tematicaEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematica(String tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroDePaginas
	 * @return El numeroDePaginas asociado a la clase
	 */
	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroDePaginas
	 * @param numeroDePaginas El nuevo numeroDePaginas a modificar.
	 */
	public void setNumeroDePaginas(Integer numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo autor
	 * @return El autor asociado a la clase
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo autor
	 * @param autor El nuevo autor a modificar.
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo colores
	 * @return El colores asociado a la clase
	 */
	public Boolean getColores() {
		return colores;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo colores
	 * @param colores El nuevo colores a modificar.
	 */
	public void setColores(Boolean colores) {
		this.colores = colores;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	
}

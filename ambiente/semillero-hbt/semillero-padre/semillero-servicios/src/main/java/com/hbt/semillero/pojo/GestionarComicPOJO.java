/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */
public class GestionarComicPOJO {

	/**
	 * lista que hara las veces de persistencia en un caso de practica
	 */
	private List<ComicDTO> listaComics = null;

	/**
	 * 
	 * Metodo encargado de crear un comic a partir de ciertos parametros
	 * <b>Caso de Uso</b>
	 * @author angie
	 * 
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 * @return
	 */
	public ComicDTO crearComicDTO(Long id, String nombre, String editorial, String tematica, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta,
			String estado, Long cantidad) {
		return new ComicDTO(id, nombre, editorial, tematica, coleccion, numeroPaginas, precio, autores, color,
				fechaVenta, estado, cantidad);
	}
	
	/**
	 * 
	 * Metodo encargado de agregar los comics pasados por parametro a listacomics 
	 * <b>Caso de Uso</b>
	 * @author angie
	 * 
	 * @param comicDTO
	 */
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de metodo que crear un comic y lo agrega a la lista listacomics
	 * <b>Caso de Uso</b>
	 * @author angie
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(100L);
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematica("AVENTURAS");
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroDePaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutor("Dragon Garow Lee");;
		comicDTO.setColores(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstado("ACTIVO");
		comicDTO.setCantidad(20L);
		if (listaComics == null) {
			listaComics = new ArrayList<>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un comic 
	 * <b>Caso de Uso</b>
	 * @author angie
	 * 
	 * @param id del comic que se desea modificar
	 * @param nombre nuevo que se asignara al comic
	 */
	public void modificarComicDTO(String id, String nombre) {
		ComicDTO comicAModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {//ciclo que recorre la lista de comics para buscar el comic que se desea editar
			comicAModificar = listaComics.get(i);
			if(comicAModificar.getId().equals(id)) {				
				comicAModificar.setNombre(nombre);	
				return;
			}
		}
	}
	
	/**
	 * 
	 * Metodo encargado de modificar un comic deacuerdo a su posicion en la lista 
	 * <b>Caso de Uso</b>
	 * @author angie
	 * 
	 * @param i
	 * @param comicDTO
	 */
	public void modificarComicDTO(int i, ComicDTO comicDTO) {
		listaComics.set(i, comicDTO);
	}
	
	/**
	 * 
	 * Metodo encargado de eliminar un comic de la lista deacuerdo a su id
	 * <b>Caso de Uso</b>
	 * @author Angie
	 * 
	 * @param idComic
	 */
	public void eliminarComicDTO(String idComic) {
		int size = this.listaComics.size();
		int counter = 0;
		while (counter<=size) {
			if (this.listaComics.get(counter).getId().equals(idComic)) {
				this.listaComics.remove(counter);
				return;
			}
			counter++;
		}
	}
	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
}
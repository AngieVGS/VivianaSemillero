/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.util.List;

import com.hbt.semillero.dto.ComicDTO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */
public class GestionarComicPOJO {

	/**
	 * Lista para emular la lista
	 */
	private List<ComicDTO> listaComics = null;

	//TO-DO
	//Continuar llenando para el comic DTN
	public void crearComicDTO(){
		ComicDTO comicDTO = new ComicDTO();
//		comicDTO
//		listaComics.add(comicDTO);
		
	} 
	
	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
	
}

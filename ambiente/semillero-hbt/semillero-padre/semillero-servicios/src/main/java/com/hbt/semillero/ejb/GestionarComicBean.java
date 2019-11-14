/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;


import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Viviana
 * @version 
 */

@Stateless
public class GestionarComicBean {

	@PersistenceContext
	private EntityManager em;

	// TODO
	/*
	 * Agregar interfaz
	 */
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {

		Comic comic = comicDTOToComic(comicDTO);

		// TODO
		/*
		 * Llenar con los demás datos
		 */

		em.persist(comic);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
//		comic.setId(comicModificar.getId());
		em.merge(comic);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ComicDTO consultarComic(String idComic) {
        Comic comic = null;
        comic = new Comic();
        comic = em.find(Comic.class, Long.parseLong(idComic));
        ComicDTO comicDTO = convertirComicToComicDTO(comic);
        return comicDTO;
    }

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarTodos() {
		em.createNativeQuery("SELECT c from Comic").getResultList();
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if (comicNuevo == null) {
			comicModificar = em.find(Comic.class, id);
		} else {
			comicModificar = comicDTOToComic(comicNuevo);
		}
		// TODO Hacer validación para ver si llegó con datos
		comicModificar.setNombre(nombre);
		em.merge(comicModificar);
	}

	/**
	 * Metodo que elimina el comic de la base de datos
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	public void eliminarComic(Long id) {
		Comic comic = em.find(Comic.class, id);
		if (comic != null) {
			em.remove(comic);

		}
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		return ((List<Comic>) em.createQuery("Select c from Comic c").getResultList()).stream()
				.map(comic -> convertirComicToComicDTO(comic)).collect(Collectors.toList());
	}

	private Comic comicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setAutores(comicDTO.getAutor());
		comic.setCantidad(comicDTO.getCantidad());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setColor(comicDTO.getColores());
		comic.setEditorial(comicDTO.getEditorial());
		// comic.setEstadoEnum(comicDTO.getEstado());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setNombre(comicDTO.getNombre());
		comic.setNumeroPaginas(comicDTO.getNumeroDePaginas());
		comic.setPrecio(comicDTO.getPrecio());
		// comic.setTematicaEnum(comicDTO.getTematica());

		return comic;
	}

	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setId(comic.getId());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		// comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroDePaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutor(comic.getAutores());
		comicDTO.setColores(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		// comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}
}
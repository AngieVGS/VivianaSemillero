package com.hbt.semillero.servicios;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.EstadoEnum;


public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test(enabled=false)
	public void primeraPU(){
		Long resultadoEsperado = 150L;
		Long sumandoUno = 100L;
		Long sumandoDos = 50L;
		Long resultado = sumandoUno+sumandoDos;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}

	/**
	 * 
	 * Metodo encargado de  probar la cadena invertida Sesion dos
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 *
	 */
	@Test(enabled=false)
	public void segundaPrueba(){
		//---- test resultado correcto de invertir cadena ---
		String resultadoEsperado = "aloH";
		String resultado = invertirCadena("Hola");
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = "anitalavalatina";
		resultado = invertirCadena("anitalavalatina");
		Assert.assertEquals(resultado, resultadoEsperado);
		//---- test resultado incorrecto de invertir cadena ---
		resultadoEsperado = "alHo";
		Assert.assertNotEquals(resultado, resultadoEsperado);
		//---- test resultado correcto de invertir cadena vacia ---
		resultado  = invertirCadena("");
		resultadoEsperado = "";
		Assert.assertEquals(resultado, resultadoEsperado);
		//---- test resultado incorrecto de invertir cadena vacia ---
		resultado  = invertirCadena("");
		resultadoEsperado =  " ";
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}


	/**
	 * 	
	 * Metodo encargado de testear el enumerado
	 * <b>Caso de Uso</b>
	 * @author Viviana
	 *
	 */
	
	@Test(enabled=false)
	public void pruebaEnumerado(){
		//		Instanciar un enum de la clase EstadoEnum
		EstadoEnum estado = EstadoEnum.ACTIVO;
		//		Devolver un String con el nombre de la constante (ACTIVO)
		estado.name();		
		//		Devolver un entero con la posición del enum según está declarada
		estado.ordinal();
		//		Comparar el enum con el parámetro según el orden en el que están declarados lo enum
		//con Activo
		Integer activo = 0;
		Integer resultado = estado.ordinal();
		Assert.assertEquals(activo,resultado);
		//con Inactivo
		Integer inactivo = 1;
		estado = EstadoEnum.INACTIVO;
		resultado = estado.ordinal();
		Assert.assertEquals(inactivo, resultado);
		//		Devolver un array que contiene todos los enum
		EstadoEnum[] numEnums =  EstadoEnum.values();
	}

	//TODO
    /**
     * Pediente hacer un método que use el método ToString de la entidad COMIC
     */
}
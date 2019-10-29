package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test
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
	
	@Test
	public void segundaPrueba(){
		//---- test resultado correcto de invertir cadena ---
		String resultadoEsperado = "aloH";
		String resultado = invertirCadena("Hola");
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

}
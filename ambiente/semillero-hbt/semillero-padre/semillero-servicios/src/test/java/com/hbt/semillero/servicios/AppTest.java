package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	private static String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}
	
	@Test
	private void invertirCadena() {
		String cadena = "prueba";
		String cadenaInvertidaEsperada = "abeurp";//inicializacion  de la cadena esperada invertida en un valor acertado
		Assert.assertEquals(AppTest.invertirCadena(cadena), cadenaInvertidaEsperada); //Prueba con cadena esperada invertida acertada 
		
		cadenaInvertidaEsperada = "praebu";//cambio de la cadena esperada invertida a un valor equivocado
		Assert.assertNotEquals(AppTest.invertirCadena(cadena), cadenaInvertidaEsperada); //Prueba con cadena esperada invertida equivocada 
		
		cadena = "";//cambio de la cadena esperada invertida a un valor vacio
		cadenaInvertidaEsperada = "";//cambio de la cadena esperada invertida a un valor acertado
		Assert.assertEquals(AppTest.invertirCadena(cadena), cadenaInvertidaEsperada); //Prueba con cadena esperada invertida acertada 
		
		cadena = "";//cambio de la cadena esperada invertida a un valor vacio
		cadenaInvertidaEsperada = " ";//cambio de la cadena esperada invertida a un valor equivocado
		Assert.assertNotEquals(AppTest.invertirCadena(cadena), cadenaInvertidaEsperada); //Prueba con cadena esperada invertida equivocada 
	}
}
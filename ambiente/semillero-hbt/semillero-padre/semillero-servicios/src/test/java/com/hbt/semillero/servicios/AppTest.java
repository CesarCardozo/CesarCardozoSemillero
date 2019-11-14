package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.EstadoEnum;

public class AppTest {


	@Test(enabled=false)
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	@Test(enabled=false)
	private static String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}
	
	@Test(enabled=false)
	private void invertirCadena() {
		String cadena = "prueba";
		String cadenaInvertidaEsperada = "abeurp";//inicializacion  de la cadena esperada invertida en un valor acertado
		Assert.assertEquals(AppTest.invertirCadena(cadena), cadenaInvertidaEsperada); //Prueba con cadena esperada invertida acertada 
		
		cadenaInvertidaEsperada = "praebu";//cambio de la cadena esperada invertida a un valor equivocado
		Assert.assertNotEquals(AppTest.invertirCadena(cadena), cadenaInvertidaEsperada); //Prueba con cadena esperada invertida equivocada 
		
		cadena = "";//cambio de la cadena esperada invertida a un valor vacio
		cadenaInvertidaEsperada = "";//cambio de la cadena esperada invertida a un valor acertado
		Assert.assertEquals(AppTest.invertirCadena(cadena), cadenaInvertidaEsperada); //Prueba con cadena esperada invertida acertada 
		
		cadenaInvertidaEsperada = " ";//cambio de la cadena esperada invertida a un valor equivocado
		Assert.assertNotEquals(AppTest.invertirCadena(cadena), cadenaInvertidaEsperada); //Prueba con cadena esperada invertida equivocada 
	}
	
	/**
	 * 
	 * Metodo encargado de realizar las pruebas concernientes al enumerado EstadoEnum
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	@Test(enabled=false)
    public void pruebaEstadoEnum() {
        EstadoEnum estadoActivo = EstadoEnum.ACTIVO;//Instanciar un enum de la clase EstadoEnum (estado activo)
        EstadoEnum estadoInactivo = EstadoEnum.INACTIVO;//Otra instancia del estado inactivo (para fines de pruebas)
        @SuppressWarnings("unused")
		String estadoActivoNombre = estadoActivo.name(); //nombre del estado activo
        @SuppressWarnings("unused")
		String estadoInactivoNombre = estadoInactivo.name();//nombr del estado inactivo
        int posEstadoActivo = estadoActivo.ordinal();//posicion del estado activo
        int posEstadoInactivo = estadoInactivo.ordinal();//posicion de estado inactivo
        int posicionEsperadaEstodoActivo = 0;//posicion esperada del estado activo
        int posicionEsperadaEstodoInactivo = 1;//posicion esperada del estado inactivo
        //Prueba en la que se comprueba que sean iguales las posiciones actuales y esperada del estado activo
        Assert.assertEquals(posEstadoActivo, posicionEsperadaEstodoActivo);
        //Prueba en la que se comprueba que sean iguales las posiciones actuales y esperada del estado inactivo
        Assert.assertEquals(posEstadoInactivo, posicionEsperadaEstodoInactivo);
        //Array que contiene todos los enum
        @SuppressWarnings("unused")
		EstadoEnum[] estados = EstadoEnum.values();
    }
	
	@Test
	public void probarStringIgual() {
		String s1 = "street";
		String s2;
		s2 = new String("street");
		if(s1==s2) {
			
		}
	}
	
	
}
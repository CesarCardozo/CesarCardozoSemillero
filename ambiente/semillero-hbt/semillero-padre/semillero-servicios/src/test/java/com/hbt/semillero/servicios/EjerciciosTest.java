/**
 * MaratonTest.java
 */
package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.Maraton;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Cesar
 * @version
 */
public class EjerciciosTest {

	@Test(enabled=false)
	public void identificadoresTest() {
		//valido
		int A$B = 0;
        Assert.assertEquals(A$B, 0);
        //valido
        String _helloWorld = "holamundo";
        Assert.assertEquals(_helloWorld, "holamundo");
  		//no valido (comentareado para evitar error)
//  		String true;
  		//no valido (comentareado para evitar error)
//  		String java.lang;
  		//valido
  		String pPublic = "pPublic";
        Assert.assertEquals(_helloWorld, "pPublic");
  		//no valido (comentareado para evitar error)
//  		String 1980S;
	}
	
	
	private String brand;
	private boolean empty;
	/**
	 * 
	 * Metodo encargado de probar el ejercicio 2
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	@Test(enabled=false)
	public void ejercicioDos() {
		System.out.println("Empty=" + empty);
		System.out.println(", Brand" + brand);
		Assert.assertEquals("Empty="+empty, "Empty="); 
		Assert.assertEquals(", Brand"+brand, ", Brandfalse");
	}
	
	/**
	 * 
	 * Metodo encargado de mirar si 5,222 y 0 son numeros primos o no
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	@Test
	public void ejercicioTres() {
		Assert.assertEquals(Maraton.verificarSiEsPrimo(5), true); //5 es primo 
		Assert.assertEquals(Maraton.verificarSiEsPrimo(222), false); //222 no es primo
		Assert.assertEquals(Maraton.verificarSiEsPrimo(0), false); //0 no es primo
	}
}

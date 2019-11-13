/**
 * MaratonTest.java
 */
package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

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
	@Test
	public void ejercicioDos() {
		WaterBottle wb = new WaterBottle();
		System.out.println("Empty=" + wb.empty);
		System.out.println(", Brand" + wb.brand);
		//saldra un error de compilacion pues la clase WaterBottle no existe
	}
}

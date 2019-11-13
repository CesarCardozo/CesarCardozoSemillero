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

	@Test
	public void identificadoresTest() {
		//valido
		int A$B = 0;
        Assert.assertEquals(A$B, 0);
        //valido
        String _helloWorld = "holamundo";
        Assert.assertEquals(_helloWorld, "holamundo");
  		//no valido
  		String true;
  		//no valido
  		String java.lang;
  		//valido
  		String pPublic = "pPublic";
        Assert.assertEquals(_helloWorld, "pPublic");
  		//no valido
  		String 1980S;
	}
}

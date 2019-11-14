/**
 * MaratonTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

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
        Assert.assertEquals(pPublic, "pPublic");
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
	@Test(enabled=false)
	public void ejercicioTres() {
		Assert.assertEquals(EjerciciosPOJO.verificarSiEsPrimo(5), true); //5 es primo 
		Assert.assertEquals(EjerciciosPOJO.verificarSiEsPrimo(222), false); //222 no es primo
		Assert.assertEquals(EjerciciosPOJO.verificarSiEsPrimo(0), false); //0 no es primo
	}
	
	/**
	 * Metodo encargado de validar que la suma de los años a la fecha de nacimiento sea la misma
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	public void ejercicioCuatro() {
		Assert.assertEquals(EjerciciosPOJO.sumarAniosAFechaNacimiento(LocalDate.of(2000, 1, 1), 19).getYear(), LocalDate.now().getYear());
	}
	
	/**
	 * 
	 * Metodo encargado de probar ele ejercicio numero 4
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	public void ejercicioCinco() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		ejerciciosPOJO.addValue(50);//agregar
		ejerciciosPOJO.addValue(1);//agregar
		ejerciciosPOJO.addValue(249);//agregar
		ejerciciosPOJO.addValue(-2);//agregar
		ejerciciosPOJO.sortValues();//organizar
		ArrayList<Integer> values = ejerciciosPOJO.getNumerosEjercicioCinco();
		Integer menor = -2;
		Integer mayor = 249;
		Integer tamanio = 4;
		Assert.assertEquals(values.get(0), menor);
		Assert.assertEquals(values.get(values.size()-1), mayor);
		Assert.assertEquals(values.get(values.size()), tamanio);
	}

	/**
	 * 
	 * Metodo encargado de probar el ejercicio numero 7
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	public void ejercicioSiete() {
		Integer[] pointsPlayerA = {1,6,2};
		Integer[] pointsPlayerB = {6,2,6};
		String playerA = "Federer";
		String playerB = "Thaim";
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		ejerciciosPOJO.establecerDatosSet(playerA, pointsPlayerA, playerB, pointsPlayerB);
		Assert.assertEquals(ejerciciosPOJO.returnWinner(playerA, playerB), playerB);
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejercicio numero 8
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	public void ejercicioOcho() {
		Assert.assertTrue(EjerciciosPOJO.returnBestPosibleCoins(1000, 1, 0, 0, 0, 0)); //cantidad de 1000, 1 de mil
		Assert.assertTrue(EjerciciosPOJO.returnBestPosibleCoins(5550, 5, 1, 0, 0, 1)); //cantidad de 5550, 5 de mil, 1 de quini, 1 de cincu
	}
	
	/**
	 * 
	 * Metodo encargado de probar el ejericio numero 11
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	public void ejercicioNueve() {
		Assert.assertEquals(EjerciciosPOJO.getNextNumber(3,6),new Integer(19));
	}
	
	public static void main(String[] args) {
	}
}

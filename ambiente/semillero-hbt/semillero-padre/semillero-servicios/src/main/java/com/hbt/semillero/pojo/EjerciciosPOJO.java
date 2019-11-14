/**
 * Maton.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Cesar
 * @version 
 */
public class EjerciciosPOJO {

	/**
	 * 
	 * Metodo encargado de verificar si un numero es primo 
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param number
	 * @return
	 */
	public static boolean verificarSiEsPrimo(int number) {
		int contador = 0;
		for (int i = 1; i <= number; i++) {
			if(number % i == 0) {
				contador++;
			}
		}
		return contador == 2; //si solo se pudo dividir entre 1 y el mismo es primo
	}
	
	/**
	 * 
	 * Metodo encargado de sumar los años a la fecha de nacimiento para obtener la fecha actual
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param birthDate
	 * @param years
	 * @return
	 */
	public static LocalDate sumarAniosAFechaNacimiento(LocalDate birthDate, int years) {
		return birthDate.plusYears(years);
	}
}

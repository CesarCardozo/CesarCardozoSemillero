/**
 * Maton.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
	
	/**
	 * coleccion que almacenara los valores del ejercicio 5
	 */
	public ArrayList<Integer> numerosEjercicioCinco = new ArrayList<Integer>();
	
	/**
	 * 
	 * Metodo encargado de agregar valores al array
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param value
	 */
	public void addValue(int value) {
		this.numerosEjercicioCinco.add(value);
	}
	
	/**
	 * 
	 * Metodo encargado de organizar la lista de valores del punto 5
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 *
	 */
	public void sortValues() {
		Collections.sort(this.numerosEjercicioCinco);
	}
	
	/**
	 * 
	 * Metodo encargado de devolver el valor en determinada posicion
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param index
	 * @return
	 */
	public Integer getValueAtIndex(int index) {
		return this.numerosEjercicioCinco.get(index);
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numerosEjercicioCinco
	 * @return El numerosEjercicioCinco asociado a la clase
	 */
	public ArrayList<Integer> getNumerosEjercicioCinco() {
		return numerosEjercicioCinco;
	}	
	
	/**
	 * mapa donde se almacenan los jugadores y sus puntos
	 */
	private Map<String, Integer[]> sets = new HashMap<>();
	
	/**
	 * 
	 * Metodo encargado de alimentar el mapa de puntos
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param playerA
	 * @param pointsPlayerA
	 * @param playerB
	 * @param pointsPlayerB
	 */
	public void establecerDatosSet(String playerA, Integer[] pointsPlayerA, String playerB, Integer[] pointsPlayerB) {
		this.sets.put(playerA, pointsPlayerA);
		this.sets.put(playerB, pointsPlayerB);
	}
	
	/**
	 * 
	 * Metodo encargado de devolver al ganador
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param playerA
	 * @param playerB
	 * @return
	 */
	public String returnWinner(String playerA, String playerB) {
		int setsA = 0;
		int setsB = 0;
		if (this.sets.get(playerA)[0]>this.sets.get(playerB)[0]) {
			setsA++;
		}else {
			setsB++;
		}
		if (this.sets.get(playerA)[1]>this.sets.get(playerB)[1]) {
			setsA++;
		}else {
			setsB++;
		}
		if (setsA==2 || setsB==2) {
			return (setsA>setsB)?playerA:playerB;
		}
		if (this.sets.get(playerA)[2]>this.sets.get(playerB)[2]) {
			setsA++;
		}else {
			setsB++;
		}
		return (setsA>setsB)?playerA:playerB;
	}
	
	/**
	 * 
	 * Metodo encargado de validar la cantidad optima de monedas para determinado valor monetario
	 * <b>Caso de Uso</b>
	 * @author Cesar
	 * 
	 * @param value
	 * @param deMilEsperada
	 * @param deQuinientosEsperada
	 * @param deDoscientosEsperada
	 * @param deCienEsperada
	 * @param deCincuentaEsperada
	 * @return
	 */
	public static boolean returnBestPosibleCoins(double value, int deMilEsperada, int deQuinientosEsperada, int deDoscientosEsperada, int deCienEsperada, int deCincuentaEsperada) {
		int deMil = 0;
		int deQuinientos = 0;
		int deDoscientos = 0;
		int deCien = 0;
		int deCincuenta = 0;
		deMil = (value/1000 >= 1) ?  (int)value/1000: 0;
		value = value - (deMil*1000);
		deQuinientos =  (value / 500 >= 1)?(int)value/500:0;
		value = value - (deQuinientos*500);
		deDoscientos = (value / 200 >= 1)?(int)value/200:0;
		value = value - (deDoscientos*200);
		deCien = (value / 100 >= 1)?(int)value/100:0;
		value = value - (deCien*100);
		deCincuenta = (value / 50 >= 1)? (int)value/50:0;
		value = value - (deCincuenta*50);
		return deMil == deMilEsperada && 
				deQuinientos == deQuinientosEsperada &&
				deDoscientos == deDoscientosEsperada && 
				deCien == deCienEsperada && 
				deCincuenta == deCincuentaEsperada;
	}
}

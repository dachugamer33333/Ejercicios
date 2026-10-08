package mx.unam.fes.cola.ColaCajeros;

import java.util.Random;

/**
 * Utilidad para generar numeros aleatorios de forma centralizada.
 *
 * <p>Mantiene una unica instancia de {@link Random} y expone un metodo estatico
 * para obtener enteros aleatorios dentro de un rango.</p>
 */
public  class RandomGeneral {
	/** Instancia compartida de {@link Random}. */
	public static Random ram = new Random();

	/**
	 * Genera un entero aleatorio dentro del rango [rangoInicial, rangoFinal).
	 *
	 * @param rangoInicial limite inferior (incluido).
	 * @param rangoFinal   limite superior (excluido).
	 * @return un entero aleatorio dentro del rango indicado.
	 */
	public static int randomInt(int rangoInicial,int rangoFinal) {

			return ram.nextInt(rangoInicial,rangoFinal);

	}
}

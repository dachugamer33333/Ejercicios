package mx.unam.fes.cola.ColaCajeros;

/**
 * Punto de entrada del programa.
 *
 * <p>Crea una simulacion de fila de cajeros y la ejecuta.</p>
 */
public class Main {

	/**
	 * Crea y arranca la simulacion con la cantidad de ciclos indicada.
	 *
	 * @param args argumentos de linea de comandos (no se usan).
	 */
	public static void main(String[] args) {
		System.out.println("--Simulacion Cajas--");

		Simulacion simulacion = new Simulacion(1000);
		simulacion.start();
	}

}

package mx.unam.fes.cola.ColaCajeros;

/**
 * Representa a una persona (cliente) que llega a la fila de cajeros.
 *
 * <p>Cada persona lleva el registro de su tiempo acumulado en el sistema,
 * es decir, el tiempo que ha esperado en la cola mas el tiempo que tarda
 * en ser atendida en caja.</p>
 */
public class Persona {
	/** Tiempo total acumulado (espera en cola + atencion en caja). */
	private int time;

	/**
	 * Crea una persona con tiempo inicial 0.
	 */
	public Persona() {
		super();
		this.time = 0;
	}

	/**
	 * Incrementa en 1 el tiempo de la persona. Se usa para contar cada ciclo
	 * que la persona permanece esperando en la cola.
	 */
	public void esperar()
	{
		time++;
	}

	/**
	 * @return el tiempo total acumulado de la persona.
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Establece el tiempo total de la persona.
	 *
	 * @param time nuevo valor del tiempo total.
	 */
	public void setTime(int time) {
		this.time = time;
	}

}

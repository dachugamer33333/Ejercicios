package mx.unam.fes.cola.ColaCajeros;

/**
 * Representa una caja registradora dentro de la simulacion.
 *
 * <p>Una caja puede estar libre u ocupada atendiendo a un cliente. Mientras
 * atiende, lleva la cuenta del tiempo que le resta para terminar, de la
 * cantidad de clientes que ha atendido y del tiempo total que ha trabajado.</p>
 */
public class CajaRegistradora {
	/** Tiempo restante para terminar de atender al cliente actual (0 = libre). */
	private int time;
	/** Cliente que se esta atendiendo (no se usa en la simulacion actual). */
	private Persona cliente;
	/** Cantidad de clientes que ha atendido esta caja. */
	private int numeroClientesAtendidos;
	/** Tiempo total trabajado (suma de todos los tiempos de servicio). */
	private int totalWorkTime;

	/**
	 * Crea una caja libre (sin clientes y con tiempo 0).
	 */
	public CajaRegistradora()
	{
		this.time=0;
	}

	/**
	 * @return el tiempo restante de atencion de la caja.
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Establece el tiempo restante de atencion de la caja.
	 *
	 * @param time nuevo tiempo restante.
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Asigna a la caja la atencion de un cliente.
	 *
	 * <p>Si el tiempo recibido es mayor que 0, se registra un cliente atendido.
	 * En cualquier caso, el tiempo recibido se suma al tiempo total trabajado.</p>
	 *
	 * @param time tiempo de servicio que tardara esta atencion.
	 */
	public void atenderCliente(int time)
	{
		this.time=time;
		if(time!=0)
		{
			numeroClientesAtendidos++;
		}
		totalWorkTime+=time;

	}

	/**
	 * Indica si la caja esta libre (sin atender a nadie).
	 *
	 * @return {@code true} si el tiempo restante es 0, {@code false} en caso contrario.
	 */
	public boolean disponible()
	{
		return time==0;
	}

	/**
	 * @return la cantidad de clientes atendidos por esta caja.
	 */
	public int getNumeroClientesAtendidos() {
		return numeroClientesAtendidos;
	}

	/**
	 * @return el tiempo total trabajado por esta caja.
	 */
	public int getTotalWorkTime() {
		return totalWorkTime;
	}

}

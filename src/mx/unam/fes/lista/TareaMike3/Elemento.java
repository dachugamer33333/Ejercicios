package mx.unam.fes.lista.TareaMike3;

/**
 * Creo esta clase para almacenar un elemento genérico junto con el seguimiento de su cantidad de repeticiones.
 */
public class Elemento<E> {
	private E valor;
	private int cantidad;

	/**
	 * Genero este constructor para inicializar el objeto asignándole su valor.
	 * Creo esta clase por si necesito almacenar un elemento especificando o controlando su cantidad de repeticiones.
	 * 
	 * @param valor El elemento que deseo guardar.
	 */
	public Elemento(E valor) {
		super();
		this.valor = valor;
	}

	/**
	 * Incremento en una unidad el contador de repeticiones de este elemento.
	 */
	public void aumentarCantidad() {
		cantidad++;
	}

	/**
	 * Consulto la cantidad total de veces que se ha registrado o repetido este elemento.
	 * 
	 * @return El número de repeticiones acumuladas.
	 */
	public int cantidadElementos() {
		return cantidad;
	}

	/**
	 * Sobrescribo el método toString para representar en texto el valor del elemento y sus repeticiones.
	 * 
	 * @return Una cadena con el estado interno del objeto.
	 */
	@Override
	public String toString() {
		return "Elemento [valor=" + valor + ", cantidad=" + cantidad + "]";
	}

	/**
	 * Obtengo el valor original almacenado en el objeto.
	 * 
	 * @return El elemento de tipo E.
	 */
	public E getValor() {
		return valor;
	}
}
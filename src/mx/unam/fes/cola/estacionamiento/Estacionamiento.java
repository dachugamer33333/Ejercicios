package mx.unam.fes.cola.estacionamiento;

import mx.unam.fes.dinamico.Cola;

/**
 * Representa un estacionamiento con cupo fijo.
 * Los autos se guardan en una cola y cada uno recibe un ticket unico.
 * Para sacar un auto especifico se mueven los autos que estan adelante
 * y, al final, la cola queda ordenada de forma ascendente.
 */
public class Estacionamiento {
	private static final int CUPO_POR_DEFECTO = 10;

	private final Cola<Integer> estacionamiento;
	private final int cupo;
	private int siguienteTicket;

	public Estacionamiento() {
		this(CUPO_POR_DEFECTO);
	}

	public Estacionamiento(int cupo) {
		this.cupo = cupo;
		this.estacionamiento = new Cola<>(cupo);
		this.siguienteTicket = 1;
	}

	/**
	 * Agrega un auto con el siguiente ticket disponible.
	 *
	 * @return el ticket asignado, o -1 si el estacionamiento esta lleno.
	 */
	public int agregar() {
		if (estaLleno()) {
			return -1;
		}
		int ticket = siguienteTicket++;
		estacionamiento.agregar(ticket);
		return ticket;
	}

	/**
	 * Saca el auto con el ticket indicado. Mueve los autos que estan
	 * adelante al final y reordena la cola antes de devolver el resultado.
	 *
	 * @param ticket numero de ticket del auto que se desea sacar.
	 * @return true si el ticket existia y se saco; false si no existe.
	 */
	public boolean sacarTicket(int ticket) {
		int n = estacionamiento.getLongitud();
		for (int i = 0; i < n; i++) {
			int frente = estacionamiento.sacar();
			if (frente == ticket) {
				reordenar();
				return true;
			}
			estacionamiento.agregar(frente);
		}
		return false;
	}

	/**
	 * Ordena la cola de menor a mayor usando otra cola auxiliar.
	 */
	public void reordenar() {
		Cola<Integer> colaAuxiliar = new Cola<>();
		while (!estacionamiento.esVacia()) {
			int n = estacionamiento.getLongitud();
			int elementoMenor = estacionamiento.recuperar();
			for (int i = 0; i < n; i++) {
				int valor = estacionamiento.sacar();
				if (valor < elementoMenor) {
					elementoMenor = valor;
				}
				estacionamiento.agregar(valor);
			}
			boolean quitado = false;
			for (int i = 0; i < n; i++) {
				int valor = estacionamiento.sacar();
				if (valor == elementoMenor && !quitado) {
					quitado = true;
				} else {
					estacionamiento.agregar(valor);
				}
			}
			colaAuxiliar.agregar(elementoMenor);
		}
		while (!colaAuxiliar.esVacia()) {
			estacionamiento.agregar(colaAuxiliar.sacar());
		}
	}

	public boolean estaLleno() {
		return estacionamiento.getLongitud() >= cupo;
	}

	public boolean esVacia() {
		return estacionamiento.esVacia();
	}

	public int getLongitud() {
		return estacionamiento.getLongitud();
	}

	public int getCupo() {
		return cupo;
	}

	public int getLibres() {
		return cupo - estacionamiento.getLongitud();
	}

	public void imprimir() {
		estacionamiento.imprimir();
	}
}

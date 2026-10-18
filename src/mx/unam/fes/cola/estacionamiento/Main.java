package mx.unam.fes.cola.estacionamiento;

import java.util.Random;

public class Main {
	private static final Random rand = new Random();
	private static final int NUM_ITERACIONES = 10;

	public static void main(String[] args) {
		Estacionamiento esta = new Estacionamiento(10);
		System.out.println("||Estacionamiento||");
		System.out.printf("Cupo: %d autos%n", esta.getCupo());
		int ultimoTicket = 0;

		for (int i = 1; i <= NUM_ITERACIONES; i++) {
			System.out.printf("%n||Vuelta %d||%n", i);

			if (seAgrega()) {
				int ticket = esta.agregar();
				if (ticket == -1) {
					System.out.println("No entra ningun auto: estacionamiento lleno.");
				} else {
					ultimoTicket = ticket;
					System.out.printf("Entra el auto con ticket %d.%n", ticket);
				}
			} else {
				System.out.println("No entra ningun auto.");
			}

			if (seSaca() && ultimoTicket > 0) {
				int ticket = rand.nextInt(1, ultimoTicket + 1);
				if (esta.sacarTicket(ticket)) {
					System.out.printf("Sale el auto con ticket %d.%n", ticket);
				} else {
					System.out.printf("No esta el ticket %d.%n", ticket);
				}
			} else {
				System.out.println("No sale ningun auto.");
			}

			System.out.print("Estacionamiento: ");
			esta.imprimir();
			System.out.printf("Ocupados: %d | Libres: %d%n", esta.getLongitud(), esta.getLibres());
		}

		System.out.printf("%nResumen final: %d ocupados, %d libres de %d.%n",
				esta.getLongitud(), esta.getLibres(), esta.getCupo());
	}

	public static boolean seAgrega() {
		return rand.nextBoolean();
	}

	public static boolean seSaca() {
		return rand.nextBoolean();
	}
}

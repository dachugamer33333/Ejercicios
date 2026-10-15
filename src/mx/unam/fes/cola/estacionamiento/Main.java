package mx.unam.fes.cola.estacionamiento;

import mx.unam.fes.dinamico.Cola;

public class Main {

	public static void main(String[] args) {
		Estacionamiento esta = new Estacionamiento(20);
		System.out.println("||Estacionamiento|| \n Entran 20 autos al estacionamiento");
		esta.getEstacionamiento().imprimir();
		esta.sacarTicket(3);
		System.out.println("Sale el ticket (3)");
		esta.getEstacionamiento().imprimir();
		esta.reordenar();
		System.out.println("se reordena el estacionamiento");
		esta.getEstacionamiento().imprimir();
		esta.sacarTicket(17);
		System.out.println("Sale el ticket (17)");
		esta.getEstacionamiento().imprimir();
		esta.reordenar();
		System.out.println("se reordena el estacionamiento");
		esta.getEstacionamiento().imprimir();
		

	}

}

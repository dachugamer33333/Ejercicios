package mx.unam.fes.cola.estacionamiento;

import mx.unam.fes.dinamico.Cola;

public class Main {

	public static void main(String[] args) {
		Estacionamiento esta = new Estacionamiento(20);
		esta.sacarTicket(3);
		esta.reordenar();
		esta.getEstacionamiento().imprimir();;
		

	}

}

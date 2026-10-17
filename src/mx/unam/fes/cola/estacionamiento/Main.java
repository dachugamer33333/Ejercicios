package mx.unam.fes.cola.estacionamiento;

import java.util.Random;

import mx.unam.fes.dinamico.Cola;

public class Main {
    private static final Random rand = new Random(); 
	public static void main(String[] args) {
		int numIteraciones = 3;
		Estacionamiento esta = new Estacionamiento();
		System.out.println("||Estacionamiento|| \n con cupo de 10 autos");
		int numAgregar =0;
		int numSacar=0;
		for(int i =1; i<=numIteraciones;i++)
		{
			System.out.printf("||Vuelta %d|| \n" ,i);
			if(seAgrega())
			{
				numAgregar=numeroAleatorio();
				esta.Agregar(numAgregar);
				System.out.printf("entra : %d \n",numAgregar);
				

			}
			else
			{
				System.out.println("no entra ningun carro");
			}
			System.out.print("Estacionamiento:");
			esta.imprimir();
			
			if(seSaca() && !esta.esVacia()) {
				numSacar=numeroAleatorio();
				esta.sacarTicket(numSacar);
				System.out.printf("Sale : %d \n",numSacar);
			}
			else {
				System.out.println("No sale ningun carro");
			}
			System.out.print("Estacionamiento:");
			esta.imprimir();
			
		}
		

	}
	public static boolean seAgrega()
	{
		return (rand.nextInt(101) >50)? true : false ;
	}
	public static boolean seSaca()
	{
		return (rand.nextInt(101) >50)? true : false ;
	}
	public static int numeroAleatorio()
	{
		return rand.nextInt(11) ;
	}

}

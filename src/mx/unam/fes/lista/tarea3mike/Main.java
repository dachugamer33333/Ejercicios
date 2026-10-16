package mx.unam.fes.lista.tarea3mike;

import java.util.Random;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;
/**
 * genera 1000 numeros aleatorios en una lista dice el mayor el segundo mayor y dice cuantas veces se repite el numero 
 * ademas filtra los numeros del 30, 150 como lo pidio el ejercicio inicial del pdf
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		//ejercicio 1
		Random ram = new Random();
		ListaEnlazada<Integer> listRandomNums = new ListaEnlazada<Integer>();
		for (int i=0; i< 1000; i++)
		{
			listRandomNums.agregarCola(ram.nextInt(1,301));
			
		}
		System.out.println("--Lista simple--");

		System.out.print("Lista de 1000 numeros: ");
		listRandomNums.imprimir();
		saberMayorYMenor(listRandomNums);
		
		
		FileManage.write("src/data.csv", listRandomNums);
		//ejercicio2
		//obtener lista
		ListaEnlazada<Integer> listaRecuperada = FileManage.read("src/data.csv");
		//filtrar lista
		listaRecuperada=main.filtrar(listaRecuperada, 30, 150);
		System.out.print("Lista Recuperada:");
		for (int i =0; i< listaRecuperada.getLongitud();i++)
		{
			System.out.print(listaRecuperada.obtenerNodo(i) + ",");
		}
		
		
		
		//contar cantidad de numeros
		
		
		
		ListaEnlazada<Elemento<Integer>> contadorNumeros = new ListaEnlazada<Elemento<Integer>>();
		for (int i = 0; i < listaRecuperada.getLongitud(); i++) {
			Integer valorActual = listaRecuperada.obtenerNodo(i);
			boolean encontrado = false;

			//contador para ver si el valor ya existe
			for (int j = 0; j < contadorNumeros.getLongitud(); j++) {
				if (valorActual.equals(contadorNumeros.obtenerNodo(j).getValor())) {
					contadorNumeros.obtenerNodo(j).aumentarCantidad();
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				Elemento<Integer> nuevo = new Elemento<Integer>(valorActual);
				nuevo.aumentarCantidad();
				contadorNumeros.agregarCola(nuevo);
			}
		}

		for (int i = 0; i < contadorNumeros.getLongitud(); i++) {
			System.out.println(contadorNumeros.obtenerNodo(i));
		}
		
	}
	
	public ListaEnlazada<Integer> filtrar(ListaEnlazada<Integer> lista,int rangoInicial,int rangoFinal)
	{
		ListaEnlazada<Integer> listaRango = new ListaEnlazada<Integer>();
		for(int i = 0 ; i < lista.getLongitud(); i++)
		{
			Integer valor = lista.obtenerNodo(i);
			if (valor != null && valor >= rangoInicial && valor <= rangoFinal)
			{
				listaRango.agregarCola(valor);
			}
		}
		return listaRango;
	}
	
	public static void saberMayorYMenor(ListaEnlazada<Integer> lista)
	{
		// Inicialización
				int numMayor = lista.getDatoCabeza();
				int numeroSegundoMayor = -1; 
				int cout = 0;
				
				// Un solo recorrido para buscar ambos valores
				while(cout < lista.getLongitud()) {
					int actual = lista.obtenerNodo(cout);
					
					if (actual > numMayor) {
						numeroSegundoMayor = numMayor; // El viejo mayor pasa a ser el segundo
						numMayor = actual; // Actualizamos el nuevo mayor
					} 
					else if (actual > numeroSegundoMayor && actual < numMayor) {
						numeroSegundoMayor = actual; // Actualizamos solo el segundo
					}
					
					cout++;
				}
				System.out.printf("""
						Numero mayor: %d
						Numero segundoMayor: %d
						""",numMayor,numeroSegundoMayor);
	}
	

}

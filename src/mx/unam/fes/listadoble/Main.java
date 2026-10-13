package mx.unam.fes.listadoble;

import java.util.Random;

import mx.unam.fes.dinamico.ListaDoble.ListaDoblementeEnlazada;

public class Main {

	public static void main(String[] args) {
		ListaDoblementeEnlazada<Integer> listanumeros = new ListaDoblementeEnlazada<Integer>();
		Random ran = new Random();
		for(int i =0 ; i<1000;i++)
		{
			listanumeros.agregarCola(ran.nextInt(101));
		}
		listanumeros.imprimir();
		System.out.println("-----------------------");
		// Inicialización
		int numMayor = listanumeros.getCabeza();
		int numeroSegundoMayor = -1;
		int cout = 0;
				
				// Un solo recorrido para buscar ambos valores
				while(cout <listanumeros.getLongitud()) {
					int actual = listanumeros.obtenerNodo(cout);
					
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
					Numero segundo mayor: %d
					""",numMayor,numeroSegundoMayor);
			System.out.println("||lista ordenada||");
			ListaDoblementeEnlazada<Integer> listaOrdenada = burbleSort(listanumeros, listanumeros.getLongitud());
			listaOrdenada.imprimir();
	}
	public static ListaDoblementeEnlazada<Integer> burbleSort(ListaDoblementeEnlazada<Integer> lista, int n) {
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = i + 1; j < n; j++) {
	            int valorI = lista.obtenerNodo(i);
	            int valorJ = lista.obtenerNodo(j);

	            if (valorI > valorJ) {
	                // Intercambio de valores en las posiciones i y j
	                lista.reemplazarEnIndice(valorJ, i);
	                lista.reemplazarEnIndice(valorI, j);
	            }
	        }
	    }
	    return lista;
	}
}

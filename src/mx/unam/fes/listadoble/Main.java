package mx.unam.fes.listadoble;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		System.out.println("||Lista de 1000 numeros aleatorios||");
		listanumeros.imprimir();
		
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
			ListaDoblementeEnlazada<Character> lineas = leerArchivo("/Users/dachu_dev/eclipse-workspace/Ejercicios/src/mx/unam/fes/listadoble/doc.txt");
			lineas.imprimir();
	}
	
	public static ListaDoblementeEnlazada<Character> leerArchivo(String direccion)
	{
		ListaDoblementeEnlazada<Character> listaRecuperada= new ListaDoblementeEnlazada<Character>();

		try {
			FileInputStream fis = new FileInputStream(direccion);
			int byteLeido;
			while ((byteLeido = fis.read()) != -1) {
                char c = (char) byteLeido;
                listaRecuperada.agregarCola(c); 
            }
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaRecuperada;
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
	public static void guardarArchivo(String ruta,ListaDoblementeEnlazada<Character> lista)
	{
		try {
			BufferedOutputStream br = new BufferedOutputStream(new FileOutputStream(ruta));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

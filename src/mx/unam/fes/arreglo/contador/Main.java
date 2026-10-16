package mx.unam.fes.arreglo.contador;

import java.util.Random;

import mx.unam.fes.estatico.Arreglo;
import mx.unam.fes.exepciones.IndicieFueraExeption;
/**
 * genera 1000 en un arreglo para saber cual es el mayor y el segundo mayoir y dice cuantas
 * veces se repite un numero
 */
public class Main {

	public static void main(String[] args) throws IndicieFueraExeption {
		int longitud = 1000;
		Arreglo<Integer> numeros = new Arreglo<Integer>(longitud);
		Random ran = new Random();
		int c;
		double promedio=0;
		// Llenado de la estructura
		while(!numeros.lleno()) {
			c=ran.nextInt(101);
			promedio+=c;
			numeros.insertar(c);
		}
		promedio=promedio/numeros.numElementos();
		numeros.imprimir();
		
		// Inicialización
		int numMayor = numeros.primero();
		int numeroSegundoMayor = -1; // Seguro, ya que los números generados van de 0 a 100
		int cout = 0;
		
		// Un solo recorrido para buscar ambos valores
		while(cout <= numeros.numElementos() - 2) {
			int actual = numeros.siguiente(cout);
			
			if (actual > numMayor) {
				numeroSegundoMayor = numMayor; // El viejo mayor pasa a ser el segundo
				numMayor = actual; // Actualizamos el nuevo mayor
			} 
			else if (actual > numeroSegundoMayor && actual < numMayor) {
				numeroSegundoMayor = actual; // Actualizamos solo el segundo
			}
			
			cout++;
		}
		
		
		Arreglo<Elemento> contadorNumeros = new Arreglo(numeros.numElementos());

		
		for (int i = 0; i < numeros.numElementos(); i++) {
		    Integer valorActual = numeros.recuperar(i);
		    boolean encontrado = false;
		    
		    // contador para ver si el valor ya existe
		    for (int j = 0; j < contadorNumeros.numElementos(); j++) {
		        if (valorActual.equals(contadorNumeros.recuperar(j).getValor())) {
		            contadorNumeros.recuperar(j).aumentarCantidad();
		            encontrado = true;
		            break; 
		        }
		    }
		    
		   
		    if (!encontrado) {
		        contadorNumeros.insertar(new Elemento(valorActual));
		    }
		}

		System.out.println("Mayor: " + numMayor + " | Segundo: " + numeroSegundoMayor);
		System.out.println("Promedio:" + promedio);
		contadorNumeros.imprimir();
		
		System.out.println("Mayor: " + numMayor + " | Segundo: " + numeroSegundoMayor);
		System.out.println("Promedio:" + promedio);
		contadorNumeros.imprimir();

	}

}

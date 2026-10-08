package mx.unam.fes.lista.Contador;

import java.util.Random;

import mx.unam.fes.estatico.Arreglo;
import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Contador {

	private Arreglo<Integer> numeros ;
	
	public Contador() throws IndicieFueraExeption {
		this.numeros= new Arreglo<Integer>(1000);
		Random ran = new Random();

		numeros.insertar(ran.nextInt(101));
		numeros.imprimir();
	}
	
	
	
	
	
}

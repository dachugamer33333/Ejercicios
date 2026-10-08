package mx.unam.fes.arreglo.TareaMike3;

import java.util.Random;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;
import mx.unam.fes.estatico.Elemento;

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
		FileManage.write("src/data.csv", listRandomNums);
		//ejercicio2
		//obtener lista
		ListaEnlazada<Integer> listaRecuperada = FileManage.read("src/data.csv");
		//filtrar lista
		listaRecuperada=main.filtrar(listaRecuperada, 30, 150);
		for (int i =0; i< listaRecuperada.getLongitud();i++)
		{
			System.out.println(listaRecuperada.obtenerNodo(i));
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
	

}

package mx.unam.fes.cola.estacionamiento;

import mx.unam.fes.dinamico.Cola;
/**
 * es una clase que representa todos los comportamientos del estacionamiento 
 * 1.generar una cantidad de espacios ocupados en una cola
 * 2.permite sacar un numero especifico del estacionamiento
 * 3.reordena la cola para que quede de manera acendente de nuevo
 */
public class Estacionamiento {
	private Cola<Integer> estacionamiento = new Cola<>(10);
	

	
	public boolean sacarTicket(int ticket)
	{
		int n = estacionamiento.getLongitud();
		if(!estacionamiento.esVacia())
		{
			for(int i = 0; i < n; i++)
			{
				int frente = estacionamiento.recuperar();
				if(frente == ticket)
				{
					estacionamiento.sacar();
					return true;
				}
				estacionamiento.agregar(estacionamiento.sacar());
			}
		}
		
		return false;
	}
	public void Agregar(int valor)
	{
		estacionamiento.agregar(valor);
	}
	public void reordenar()
	{
		Cola<Integer> colaAuxiliar = new Cola<>();
		while(!estacionamiento.esVacia())
		{
			int n = estacionamiento.getLongitud();
			int elementoMenor = estacionamiento.recuperar();
			for(int i = 0; i < n; i++)
			{
				int valor = estacionamiento.sacar();
				if(valor < elementoMenor)
				{
					elementoMenor = valor;
				}
				estacionamiento.agregar(valor);
			}
			boolean quitado = false;
			for(int i = 0; i < n; i++)
			{
				int valor = estacionamiento.sacar();
				if(valor == elementoMenor && !quitado)
				{
					quitado = true;
				}
				else
				{
					estacionamiento.agregar(valor);
				}
			}
			colaAuxiliar.agregar(elementoMenor);
		}
		while(!colaAuxiliar.esVacia())
		{
			estacionamiento.agregar(colaAuxiliar.sacar());
		}
	}

	public boolean esVacia()
	{
		return estacionamiento.esVacia();
	}
	
	public void imprimir()
	{
		estacionamiento.imprimir();
	}
	
	
	
}

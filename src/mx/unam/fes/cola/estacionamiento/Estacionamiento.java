package mx.unam.fes.cola.estacionamiento;

import mx.unam.fes.dinamico.Cola;

public class Estacionamiento {
	private Cola<Integer> estacionamiento = new Cola<>();
	private int cupo;
	public Estacionamiento(int cupo) {
		
		this.cupo = cupo;
		for(int i = 1; i<= cupo;i++)
		{
			estacionamiento.agregar(i);
		}
	}
	
	public boolean sacarTicket(int ticket)
	{
		int n = estacionamiento.getLongitud();
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
		return false;
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

	public Cola<Integer> getEstacionamiento() {
		return estacionamiento;
	}
	
	
	
}

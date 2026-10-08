package mx.unam.fes.cola.ColaCajeros;

import mx.unam.fes.dinamico.Cola;
import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;

 class Simulacion {
	/** Cola de personas que esperan ser atendidas. */
	private Cola<Persona> personas = new Cola<>();
	/** Lista de cajas registradoras disponibles. */
	private ListaEnlazada<CajaRegistradora> cajas = new ListaEnlazada<CajaRegistradora>();
	/** Mayor tiempo (espera + servicio) registrado entre todos los clientes. */
	private int tiempoMaximo;
	/** Cantidad de ciclos que se van a ejecutar. */
	private int numeroSimulaciones;
	/** Total de clientes atendidos por todas las cajas. */
	private int clientesAtendidos;

	/**
	 * Crea la simulacion con la cantidad de ciclos indicada.
	 *
	 * <p>La simulacion inicia siempre con una unica caja registradora abierta.</p>
	 *
	 * @param numeroSimulaciones cantidad de ciclos a ejecutar.
	 */
	public Simulacion(int numeroSimulaciones) {
		super();
		this.numeroSimulaciones = numeroSimulaciones;
		this.tiempoMaximo=0;
		cajas.agregarCabeza(new CajaRegistradora());

	}

	/**
	 * Ejecuta la simulacion completa y, al final, muestra los resultados.
	 */
	public void start()
	{
		for(int i=0;i <= numeroSimulaciones;i++)
		{


			for(int j=0;j<cajas.getLongitud();j++)
		{
			if(cajas.obtenerNodo(j).disponible())
			{
				cajas.obtenerNodo(j).atenderCliente(pasarCaja());
			}
		}



			esperar();

			determinarLlegarPersona();

		}
		calcularTotalClientes();
		informacion();

	}

	/**
	 * Decide aleatoriamente si llega una persona nueva a la cola.
	 *
	 * <p>Genera un numero aleatorio entre 1 y 100; si es menor o igual a 50
	 * (es decir, 50% de probabilidad), agrega una persona a la cola.</p>
	 */
	public void determinarLlegarPersona()
	{
		int numeroRandom=RandomGeneral.randomInt(1, 101);
		if(numeroRandom <= 50)
		{
			personas.agregar(new Persona());
		}

	}

	/**
	 * Avanza un ciclo de espera.
	 *
	 * <p>Por un lado, cada persona en la cola incrementa su tiempo de espera;
	 * si una persona supera el umbral de 10, se abre una caja nueva.
	 * Por otro lado, cada caja ocupada reduce en 1 su tiempo restante de atencion.</p>
	 */
	public void esperar()
	{
		int n = personas.getLongitud();
		for(int j=0; j<n;j++)
		{
			Persona persona=personas.sacar();
			persona.esperar();
			if(persona.getTime() > 15)
			{
				cajas.agregarCabeza(new CajaRegistradora());
			}
			personas.agregar(persona);
		}
		for(int i=0;i<cajas.getLongitud();i++)
		{
			if(cajas.obtenerNodo(i).getTime()>0)
			{
				cajas.obtenerNodo(i).setTime(cajas.obtenerNodo(i).getTime()-1);
			}
		}

	}

	/**
	 * Atiende a la persona que esta al final de la cola.
	 *
	 * <p>Calcula un tiempo de servicio aleatorio, lo suma al tiempo de la persona,
	 * actualiza el tiempo maximo registrado si corresponde y retira a la persona
	 * de la cola.</p>
	 *
	 * @return el tiempo de servicio que tomara atender a la persona, o 0 si la cola
	 *         esta vacia.
	 */
	public int pasarCaja()
	{
		if(!personas.esVacia())
		{
			Persona persona=personas.sacar();
			int tiempoCaja= RandomGeneral.randomInt(1, 16);
			persona.setTime(persona.getTime()+tiempoCaja);
			if(tiempoMaximo<persona.getTime())
			{
				tiempoMaximo=persona.getTime();
			}
			return tiempoCaja;
		}
		return 0;

	}

	/**
	 * Suma los clientes atendidos por todas las cajas y guarda el total.
	 */
	public void calcularTotalClientes()
	{
		for(int i=0;i<cajas.getLongitud();i++)
		{
			clientesAtendidos+=cajas.obtenerNodo(i).getNumeroClientesAtendidos();
		}
	}




	/**
	 * Imprime en consola las estadisticas finales de la simulacion:
	 * cantidad de cajas, personas en cola, tiempo maximo, clientes atendidos
	 * y tiempo trabajado por cada caja.
	 */
	public void informacion() {
		System.out.printf("""
				Cantidad de cajas : %d
				Gente en cola     : %d
				Tiempo Maximo     : %d
				Clientes Atendidos: %d
				
				
				 
				""",cajas.getLongitud(),personas.getLongitud(),tiempoMaximo,clientesAtendidos);

		for(int i=0;i<cajas.getLongitud();i++)
		{
			System.out.printf("""
					Caja %d:
						Tiempo trabajado: %d
						\n
					""",i,cajas.obtenerNodo(i).getTotalWorkTime());
		}
	}



}

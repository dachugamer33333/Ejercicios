package mx.unam.fes.pila.Notacion;

public class Main {
	/**
	 * Se realiza la operacion de posfijo 
	 * @param args
	 */
	public static void main(String[] args) {
		Posfijo pos = new Posfijo("4 2 * 4 / 5 +");
		System.out.println("||Calculo Posfijo||");
		System.out.println("Cadena posfija:" + pos);
		
		System.out.println("Resultado:"+pos.calcular());

		// Ejemplo con operandos de mas de un digito
		Posfijo posMulti = new Posfijo("12 3 * 4 +");
		System.out.println("\nCadena posfija:" + posMulti);
		System.out.println("Resultado:" + posMulti.calcular());
	}

}

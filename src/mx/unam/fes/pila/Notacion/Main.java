package mx.unam.fes.pila.Notacion;

public class Main {
	/**
	 * Se realiza la operacion de posfijo 
	 * @param args
	 */
	public static void main(String[] args) {
		Posfijo pos = new Posfijo("42*4/5+");
		System.out.println("||Calculo Posfijo||");
		System.out.println("Cadena posfija:" + pos);
		
		System.out.println("Resultado:"+pos.calcular());
	}

}

package mx.unam.fes.pila.Notacion;

public class main {

	public static void main(String[] args) {
		posfijo pos = new posfijo("42*4/5+");
		System.out.println("||Calculo Posfijo||");
		System.out.println("Cadena posfija:" + pos);
		
		System.out.println("Resultado:"+pos.calcular());
	}

}

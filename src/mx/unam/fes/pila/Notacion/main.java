package mx.unam.fes.pila.Notacion;

public class main {

	public static void main(String[] args) {
		posfijo pos = new posfijo("42*4/5+");
		System.out.println(pos.calcular());
	}

}

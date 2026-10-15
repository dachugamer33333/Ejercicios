package mx.unam.fes.pila.conversion;

public class Main {

	public static void main(String[] args) {
		String interfija = "3+5+6";
		ConversionPosfijo conv = new ConversionPosfijo(interfija);
		System.out.println("||Conversion Interfija Posfija||");
		System.out.println("interfija:" + interfija);
		System.out.println("conversion posfija: " + conv.calcular());

	}

}

package mx.unam.fes.pila.conversion;

public class Main {

	public static void main(String[] args) {
		// Casos de prueba: sin parentesis, con jerarquia y con parentesis
		String[] expresiones = {
				"3+5+6",
				"3+5*2",
				"(3+5)*2",
				"2^3^2",
				"a+b*c-d",
				"((a+b)*c)-d"
		};

		System.out.println("||Conversion Interfija a Posfija||");
		for (String interfija : expresiones) {
			ConversionPosfijo conv = new ConversionPosfijo(interfija);
			System.out.println("interfija: " + interfija + "  ->  posfija: " + conv.calcular());
		}
	}

}

package mx.unam.fes.pila.Notacion;

import mx.unam.fes.dinamico.Pila;
/**
 * Creamos una clase para calcular porsfijo
 */
public class posfijo {
    // La pila DEBE guardar los números intermedios calculados
    Pila<Double> pila = new Pila<>();
    String exprecionPosfija;
    /**
     * Es constructor recibe un dato y string y lo convierte a un arreglo de caracteres
     * @param String que recibe la clase y lo convierte a un arreglo de caracteres
     */
    public posfijo(String dato) {
        super();
        exprecionPosfija = dato.trim();
    }
    /**
     * Hace el calculo de posfijos en base al dato recibido por el constructor
     * @return retorna el resultado obtenido por las operaciones aritmeticas
     */

    public Double calcular() {
        for (int i = 0; i < exprecionPosfija.length(); i++) {
            char actual = exprecionPosfija.charAt(i);

            if (Character.isWhitespace(actual)) {
                continue;
            }

            if (Character.isDigit(actual)) {
                double valor = actual - '0'; // '5' - '0' = 5.0
                pila.agregar(valor);
            } 
            else if (actual == '+' || actual == '-' || actual == '*' || actual == '/') {
                double operando2 = pila.sacar();
                double operando1 = pila.sacar();
                double resultado = 0;

                switch (actual) {
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                }

                pila.agregar(resultado);
            }
        }

        return pila.sacar();
    }
	@Override
	public String toString() {
		return exprecionPosfija;
	}
    
}

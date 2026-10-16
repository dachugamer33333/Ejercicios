package mx.unam.fes.pila.Notacion;

import mx.unam.fes.dinamico.Pila;
/**
 * Evalua una expresion aritmetica escrita en notacion posfija (postfija).
 *
 * <p>Soporta los operadores {@code +}, {@code -}, {@code *} y {@code /} y operandos
 * de uno o mas digitos. Los digitos consecutivos forman un solo numero, por lo que se
 * deben separar los operandos con espacios para evitar ambiguedad. Por ejemplo
 * {@code "12 3 * 4 +"} se calcula como {@code (12 * 3) + 4 = 40} y
 * {@code "4 2 * 4 / 5 +"} como {@code ((4 * 2) / 4) + 5 = 7}.</p>
 */
public class Posfijo {
    // La pila DEBE guardar los números intermedios calculados
    Pila<Double> pila = new Pila<>();
    /** Expresion posfija que se va a evaluar. */
    String exprecionPosfija;
    /**
     * Es constructor recibe un dato y string y lo convierte a un arreglo de caracteres
     * @param String que recibe la clase y lo convierte a un arreglo de caracteres
     */
    public Posfijo(String dato) {
        super();
        exprecionPosfija = dato.trim();
    }
    /**
     * Hace el calculo de posfijos en base al dato recibido por el constructor.
     *
     * <p>Recorre la expresion tomando como operando cualquier numero de uno o mas
     * digitos (y punto decimal) y, al encontrar un operador, saca los dos ultimos
     * operandos de la pila, opera y devuelve el resultado a la pila.</p>
     *
     * @return retorna el resultado obtenido por las operaciones aritmeticas
     */

    public Double calcular() {
        int i = 0;
        while (i < exprecionPosfija.length()) {
            char actual = exprecionPosfija.charAt(i);

            if (Character.isWhitespace(actual)) {
                i++;
                continue;
            }

            if (Character.isDigit(actual) || actual == '.') {
                // Armo el numero completo (puede tener varios digitos y decimales)
                StringBuilder numero = new StringBuilder();
                while (i < exprecionPosfija.length()) {
                    char c = exprecionPosfija.charAt(i);
                    if (Character.isDigit(c) || c == '.') {
                        numero.append(c);
                        i++;
                    } else {
                        break;
                    }
                }
                pila.agregar(Double.parseDouble(numero.toString()));
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
                i++;
            }
            else {
                // Caracter no reconocido: se ignora
                i++;
            }
        }

        return pila.sacar();
    }
	@Override
	public String toString() {
		return exprecionPosfija;
	}
    
}

package mx.unam.fes.pila.conversion;

import mx.unam.fes.dinamico.Pila;

/**
 * Convierte una exprecion Interfija a Posfija
 */
public class ConversionPosfijo {
    private Pila<Character> pila = new Pila<>();
    private String exprecionInterfija;
    private String exprecionPosfija = ""; // Inicializar para evitar que arranque con "null"

    public ConversionPosfijo(String exprecionInterfija) {
        super();
        this.exprecionInterfija = exprecionInterfija.trim();
    }

    // Función auxiliar para determinar la prioridad del operador
    private int prioridad(char operador) {
        switch (operador) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default:  return 0; // Paréntesis o cualquier otro símbolo
        }
    }

    private boolean esOperador(char c) {
        return c == '^' || c == '*' || c == '/' || c == '+' || c == '-';
    }

    /**
     * Decide si el operador que se esta leyendo debe desplazar de la pila al
     * operador que esta en el tope.
     *
     * <p>Los operadores {@code +}, {@code -}, {@code *} y {@code /} son asociativos
     * a la izquierda, por lo que se saca el tope cuando su prioridad es mayor o igual
     * a la del operador actual. El operador {@code ^} es asociativo a la derecha, por
     * lo que solo se saca el tope cuando su prioridad es estrictamente mayor.</p>
     *
     * @param operador operador que se esta leyendo de la expresion
     * @param tope     simbolo que esta en el tope de la pila
     * @return true si hay que sacar el tope antes de meter el operador
     */
    private boolean debeSacar(char operador, char tope) {
        if (!esOperador(tope)) {
            return false; // El paréntesis '(' no se saca en este paso
        }
        int prioridadOperador = prioridad(operador);
        int prioridadTope = prioridad(tope);
        if (prioridadOperador < prioridadTope) {
            return true;
        }
        return prioridadOperador == prioridadTope && operador != '^';
    }

    public String calcular() {
        exprecionPosfija = ""; // Reiniciar por si el objeto se reutiliza
        while (!exprecionInterfija.isEmpty()) {
            char simboloizquierda = exprecionInterfija.charAt(0);
            exprecionInterfija = exprecionInterfija.substring(1);

        
            // 2. Paréntesis izquierdo
            if (simboloizquierda == '(') {
                pila.agregar(simboloizquierda);
            } 
            // 3. Paréntesis derecho
            else if (simboloizquierda == ')') {
                while (!pila.esVacia() && pila.recuperar() != '(') {
                    exprecionPosfija += pila.sacar();
                }
                if (!pila.esVacia() && pila.recuperar() == '(') {
                    pila.sacar(); // Descartar el '(' de la pila
                }
            } 
            // 4. Operador (^, *, /, +, -)
            else if (esOperador(simboloizquierda)) {
                while (!pila.esVacia() && debeSacar(simboloizquierda, pila.recuperar())) {
                    exprecionPosfija += pila.sacar();
                }
                pila.agregar(simboloizquierda);
            } 
            // 5. Operando (letras, números)
            else {
                exprecionPosfija += simboloizquierda;
            }
        }

        // Vaciar los operadores restantes en la pila
        while (!pila.esVacia()) {
            exprecionPosfija += pila.sacar();
        }

        return exprecionPosfija;
    }
}
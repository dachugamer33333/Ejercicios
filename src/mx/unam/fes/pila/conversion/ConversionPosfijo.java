package mx.unam.fes.pila.conversion;

import mx.unam.fes.dinamico.Pila;

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

    public String calcular() {
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
                while (!pila.esVacia() && prioridad(simboloizquierda) <= prioridad(pila.recuperar())) {
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
package mx.unam.fes.listadoble;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import mx.unam.fes.dinamico.ListaDoble.ListaDoblementeEnlazada;
import mx.unam.fes.dinamico.ListaDoble.Nodo;

/**
 * Genera 1000 numeros aleatorios en una listadoble y se indica cual es el mayor, el segundo mayor,
 * ordenar en burbuja, guardar cualquier archivo en la lista y despues volver a construirla.
 */
public class Main {

    public static void main(String[] args) {
        ListaDoblementeEnlazada<Integer> listanumeros = new ListaDoblementeEnlazada<Integer>();
        Random ran = new Random();
        for (int i = 0; i < 1000; i++) {
            listanumeros.agregarCola(ran.nextInt(101));
        }
        System.out.println("--Lista Doble--");

        System.out.println("||Lista de 1000 numeros aleatorios||");
        listanumeros.imprimir();

        // Inicialización
        int numMayor = listanumeros.getDatoCabeza();
        int numeroSegundoMayor = -1;
        int cout = 0;

        // Un solo recorrido para buscar ambos valores
        while (cout < listanumeros.getLongitud()) {
            int actual = listanumeros.obtenerNodo(cout);

            if (actual > numMayor) {
                numeroSegundoMayor = numMayor; // El viejo mayor pasa a ser el segundo
                numMayor = actual; // Actualizamos el nuevo mayor
            } else if (actual > numeroSegundoMayor && actual < numMayor) {
                numeroSegundoMayor = actual; // Actualizamos solo el segundo
            }

            cout++;
        }
        
        System.out.printf("""
                Numero mayor: %d
                Numero segundo mayor: %d
                """, numMayor, numeroSegundoMayor);
                
        System.out.println("||lista ordenada||");
        ListaDoblementeEnlazada<Integer> listaOrdenada = bubbleSort(listanumeros);
        listaOrdenada.imprimir();

        // --- LECTURA Y RECONSTRUCCIÓN DE CUALQUIER ARCHIVO EN LA CARPETA ---
        System.out.println("||Bytes Leidos||");
        String rutaCarpeta = System.getProperty("user.dir") + "/documento_esperado_mike";
        File carpeta = new File(rutaCarpeta);

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();

            if (archivos != null && archivos.length > 0) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        System.out.println("-> Procesando archivo: " + archivo.getName());
                        
                        // 1. Leer los bytes del archivo y meterlos a la lista doble
                        ListaDoblementeEnlazada<Integer> lineas = leerArchivo(archivo.getAbsolutePath());
                        
                        
                        // 2. Volver a construir el archivo a partir de la lista
                        guardarArchivo(archivo.getAbsolutePath(), lineas);
                    }
                }
            } else {
                System.out.println("La carpeta 'documento_esperado_mike' está vacía.");
            }
        } else {
            System.out.println("No se encontró la carpeta en: " + rutaCarpeta);
        }
    }

    /**
     * Ordena la lista de menor a mayor con el algoritmo de burbuja.
     * Recorre los nodos con sus referencias en lugar de usar obtenerNodo(indice),
     * por lo que el costo es 
     *
     * @param lista lista que se desea ordenar.
     * @return la misma lista, ya ordenada.
     */
    public static ListaDoblementeEnlazada<Integer> bubbleSort(ListaDoblementeEnlazada<Integer> lista) {
        if (lista == null || lista.esVacia()) {
            return lista;
        }

        boolean cambiado;
        do {
            cambiado = false;
            Nodo<Integer> actual = lista.getCabeza();

            while (actual != null && actual.getSiguiente() != null) {
                Nodo<Integer> siguiente = actual.getSiguiente();

                if (actual.getDato() > siguiente.getDato()) {
                    Integer temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    cambiado = true;
                }

                actual = siguiente;
            }
        } while (cambiado);

        return lista;
    }

    public static ListaDoblementeEnlazada<Integer> leerArchivo(String direccion) {
        ListaDoblementeEnlazada<Integer> listaRecuperada = new ListaDoblementeEnlazada<Integer>();

        // Usamos try-with-resources para que el FileInputStream se cierre solo
        try (FileInputStream fis = new FileInputStream(direccion)) {
            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                listaRecuperada.agregarCola(byteLeido);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaRecuperada;
    }

    public static void guardarArchivo(String ruta, ListaDoblementeEnlazada<Integer> lista) {
        try (BufferedOutputStream br = new BufferedOutputStream(new FileOutputStream(ruta))) {
            Nodo<Integer> actual = lista.getCabeza();
            while (actual != null) {
                br.write(actual.getDato());
                actual = actual.getSiguiente();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("||Se guardo documento||");
    }
}

package mx.unam.fes.lista.tarea3mike;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import mx.unam.fes.dinamico.ListaSimple.ListaEnlazada;
/**
 * es la modularizacion que permite al main funcionar
 */
public class FileManage {
	public static <T> void write(String rute,ListaEnlazada<T> datos)
	{
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rute));
			for(int i = 0 ; i < datos.getLongitud(); i++)
			{
				bw.write(datos.obtenerNodo(i).toString());
				bw.newLine();
			}
			bw.close();
		}catch (Exception e) {
			System.out.println(e + "errror");
		}
	}
	public static <T> ListaEnlazada<T> read(String rute){
		ListaEnlazada<T> listaRecuperada = new ListaEnlazada<T>();
		try(BufferedReader br = new BufferedReader(new FileReader(rute)) )
		{
			String line;
			while((line=br.readLine()) != null)
			{
				
				listaRecuperada.agregarCola((T) Integer.valueOf(line));
			}
			
			br.close();
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
		return listaRecuperada;
	}
}	

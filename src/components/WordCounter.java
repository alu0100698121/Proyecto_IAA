package components;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/** Esta clase hará de contador de palabras de un fichero */
public class WordCounter {

	/** Fichero a escanear */
	private File file;
	/** Almacenará pares tipo: <Palabra, apariciones> */
	private HashMap<String,Integer> hash;
	/** Escaner del fichero */
	private Scanner escaner;
	
	/** Constructor
	 * @param s Ruta hasta el fichero a escanear */
	public WordCounter(String s) throws FileNotFoundException {
		// Inicializando atributos
		hash = new HashMap<String,Integer>();
		file = new File(s);
		
		// Se inicializa el escaner para el fichero seleccionado
		escaner = new Scanner(file);
		
		// Mientras el escaner pueda seguir mirando...
		while(escaner.hasNext()) {
			String line = escaner.next(); // Se almacena el siguiente "token" (palabra, creo... (?))
				if (hash.containsKey(line)) // Si el hash ya contiene ese token...
					hash.put(line, hash.get(line)+1); // Se aumenta en uno las apariciones
				else // Si no...
					hash.put(line, 1); // Se pone el valor de las apariciones a 1
		}
		
		System.out.println(hash.get("film")); // Probando el hash (Imprime las apariciones de "film")
	}
}

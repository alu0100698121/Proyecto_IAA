/**
 * Este paquete contiene los distintos componentes que tendrá el sistema en conjunto.
 */
package components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author eliasib
 * Esta clase se encargará de crear el megadocumento con todas las opiniones.
 */
public class MegadocMaker {
	/** Ruta "raíz", donde estarán los directorios "neg" y "pos" con los ficheros respectivos*/
	private String root_path; 
	/** Ruta hasta los ficheros con opiniones negativas */ 
	private String negative_path;
	/** Ruta hasta los ficheros con opiniones positivas */ 
	private String positive_path;
	
	/** Idem positive_file, pero con tipo File de Java*/
	private File f_positive_path;
	/** Idem negative_file, pero con tipo File de Java*/
	private File f_negative_path;
	
	/** Almacena todos los ficheros, tanto positivos como negativos*/
	private ArrayList<File> all_files;
	
	/** Constructor
	 * @param root_path La ruta "raiz", donde estarán "neg" y "pos" */
	public MegadocMaker(String root_path) {
		this.root_path = root_path; // Ruta "raiz"
		this.negative_path = this.root_path+"/neg"; // Se construye la ruta a "neg" a partir de la "root"
		this.positive_path = this.root_path+"/pos"; // Se construye la ruta a "pos" a partir de la "root"
		
		f_positive_path = new File(positive_path); // Idem "positive_path" pero de tipo File de Java
		f_negative_path = new File(negative_path); // Idem "negative_path" pero de tipo File de Java
		
		File [] positive_files = f_positive_path.listFiles(); // Array que tiene todos los ficheros de "positive_path"
		File [] negative_files = f_negative_path.listFiles(); // Array que tiene todos los ficheros de "negative_path"
		
		all_files = new ArrayList<File>(); // inicializar arraylist
		
		for (int i = 0; i < positive_files.length; i++)
			all_files.add(positive_files[i]); // Se añaden los ficheros de positive_files al arraylist
		
		for (int i = 0; i < negative_files.length; i++)
			all_files.add(negative_files[i]); // Se añaden los ficheros de negative_files al arraylist
		
		try {
			BufferedReader br; // Lector de fichero
			String s; // Línea actual (en cada momento)
			PrintWriter pw = new PrintWriter(root_path+"/megadoc.txt","UTF-8"); // Escritor del megadocumento (en "root")
			pw.print(""); // Primero, el fichero se rellena con vacío.
			
			for (int i = 0; i < all_files.size(); i++) {
				File f = all_files.get(i); // Cada uno de los ficheros
			
				br = new BufferedReader(new FileReader(f)); // Se abre el fichero para leerlo
				s = br.readLine(); // Se almacena el comentario en la string s
				s = s.replaceAll("<.*?>",""); // Elimina las etiquetas HTML
				br.close(); // Cerrar el reader
				
				pw.append(s+"\n\n"); // Se anexiona la nueva cadena al megadocumento
			}
			
			pw.close(); // Ciera el flujo del megadocumento
			
		} catch (Exception e) {}
		
		System.out.println("Done."); // Aviso al terminar de leer
	}
}

package main;

import java.io.FileNotFoundException;

import components.MegadocMaker;
import components.WordCounter;

public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		MegadocMaker m = new MegadocMaker("/home/eliasib/Dropbox/3_Carrera/Inteligencia Artificial Avanzada/");
		WordCounter w = new WordCounter("/home/eliasib/Dropbox/3_Carrera/Inteligencia Artificial Avanzada/megadoc.txt");
	}

}

package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Juego;

public class Test {

	public static void main(String[] args) {
		
		//TEST de la creacion de juegos leyendo el fichro CSV y listando les en una ArrayList.
		String line = "";
		String splitBy = ",";
		ArrayList<Juego> listajuegos = new ArrayList<Juego>();
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(".\\src\\vgsales.csv"));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] juego = line.split(splitBy); // use comma as separator
				Juego videojuego = new Juego(Integer.parseInt(juego[0]), juego[1], juego[2], Integer.parseInt(juego[3]),
						juego[4], juego[5]);
				listajuegos.add(videojuego);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Juego juego:listajuegos) {
			System.out.println(juego);
		}
	}
	

}

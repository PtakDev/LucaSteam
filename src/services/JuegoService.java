package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.IJuegoService;
import modelo.Juego;

public class JuegoService implements IJuegoService {

	@Override
	public void anadir_juego() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listar_todos_juegos() {
		// TODO Auto-generated method stub
//prueba de cambios
		//prueba
	}

	@Override
	public ArrayList<Juego> cargar_datos() {
		String line = "";
		String splitBy = ",";
		ArrayList<Juego> listajuegos = new ArrayList<Juego>();
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(".\\datos\\vgsales.csv"));
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
		
		return listajuegos;
	}

}

package main.java.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.java.interfaces.IJuegoDatos;
import main.java.modelo.Juego;

public class JuegoDatos implements IJuegoDatos {

	public ArrayList<Juego> listajuegos = new ArrayList<Juego>();

	@Override
	public ArrayList<Juego> anadir_juego() {
		return listajuegos;
	}

	@Override
	public boolean anadir_juego(Juego juego) {
		if (juego == null)
			return false;
		else if (juego.getRango() != listajuegos.size() + 1)
			return false;
		else {
			listajuegos.add(juego);
			return true;
		}
	}

	@Override
	public ArrayList<Juego> listar_juegos_genero_plataforma() {
		return listajuegos;
	}

	@Override
	public ArrayList<Juego> listar_todos_juegos() {
		return listajuegos;
	}
	
	@Override
	public ArrayList<Juego> listar_juegos_pub_Nintendo() {
		return listajuegos;
	}

	@Override
	public ArrayList<Juego> cargar_datos(String ruta_fichero) {
		String line = "";
		String splitBy = ",";
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(ruta_fichero));
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

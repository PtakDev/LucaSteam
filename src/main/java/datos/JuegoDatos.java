package main.java.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.interfaces.IJuegoDatos;
import main.java.modelo.Juego;

public class JuegoDatos implements IJuegoDatos {

	public ArrayList<Juego> listajuegos = new ArrayList<Juego>();

	@Override
	public Juego crear_juego(Scanner sc) {
		Juego juego = new Juego();
		juego.setRango(listajuegos.size() + 1);
		System.out.println("¿Que nombre quieres ponerle? ");
		sc.nextLine();
		juego.setNombre(sc.nextLine());
		System.out.println("¿Para que plataforma es? ");
		juego.setPlataforma(sc.nextLine());
		System.out.println("¿En que año se publico? ");
		try {
			juego.setAnio(sc.nextInt());
		} catch (InputMismatchException e) {
			System.err.println("Solo aceptamos numeros");
			sc.nextLine();
		}
		sc.nextLine();
		System.out.println("¿De que genero es? ");
		juego.setGenero(sc.nextLine());
		System.out.println("¿Cual es el editor? ");
		juego.setEditor(sc.nextLine());
		return juego;
	}
	
	@Override
	public boolean anadir_juego(Juego juego) {
		if (juego == null)
			return false;
		else if (juego.getRango() < listajuegos.size() + 1)
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

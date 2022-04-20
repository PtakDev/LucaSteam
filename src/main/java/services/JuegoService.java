package main.java.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import main.java.interfaces.IJuegoService;
import main.java.modelo.Juego;

public class JuegoService implements IJuegoService {

	ArrayList<Juego> listajuegos = new ArrayList<Juego>();

	@Override
	public int anadir_juego(Scanner input) {
		Juego juego = new Juego();
		// Automaticamente le pongo el ultimo rango
		juego.setRango(listajuegos.size() + 1);
		System.out.println("�Que nombre quieres ponerle? ");
		input.nextLine();
		juego.setNombre(input.nextLine());
		System.out.println("�Para que plataforma es? ");
		juego.setPlataforma(input.nextLine());
		System.out.println("�En que a�o se publico? ");
		try {
		juego.setAnio(input.nextInt());
		}catch (InputMismatchException e) {
		    System.err.println("Solo aceptamos numeros");
		    input.nextLine();
		    return 0;
		}
		input.nextLine();
		System.out.println("�De que genero es? ");
		juego.setGenero(input.nextLine());
		System.out.println("�Cual es el editor? ");
		juego.setEditor(input.nextLine());
		listajuegos.add(juego);
		return 1;
	}
	
	@Override
	public int anadir_juego(Juego juego) {
		if(juego==null)
			return 2;
		else if(juego.getRango()!=listajuegos.size() + 1)
			return 3;
		else {
			listajuegos.add(juego);
			return 1;
		}
	}
	@Override
	public void listar_juegos_genero_plataforma() {
		for (Juego game : listajuegos) {
			if (game.getGenero().equals("Platform")) {
				System.out.println(game);
			}
		}

	}

	@Override
	public void listar_todos_juegos() {
		for (Juego j : listajuegos) {
			System.out.println(j);
		}

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

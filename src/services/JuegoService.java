package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import interfaces.IJuegoService;
import modelo.Juego;

public class JuegoService implements IJuegoService {

	ArrayList<Juego> listajuegos = new ArrayList<Juego>();

	@Override
	public void anadir_juego() {
		try (// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in)) {
			System.out.println("A�adiendo juego");
			Juego juego = new Juego();
			juego.setRango(listajuegos.size()+1);
			System.out.println("Que nombre quieres ponerle? ");
			juego.setNombre(input.nextLine());
			System.out.println("Para que plataforma es? ");
			juego.setPlataforma(input.nextLine());
//			this.plataforma = plataforma;
//			this.anio = anio;
//			this.genero = genero;
//			this.editor = editor;
		}
	}

	@Override
	public void listar_juegos_genero_plataforma() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listar_todos_juegos() {
		for (Juego j : listajuegos) {
			System.out.println(j);
		}

	}

	@Override
	public ArrayList<Juego> cargar_datos() {
		String line = "";
		String splitBy = ",";
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

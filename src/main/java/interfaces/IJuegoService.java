package main.java.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.modelo.Juego;

public interface IJuegoService {
	//Metodo en el que se introduce datos
	public int anadir_juego(Scanner input);
	//Metodo en el que se le da el juego directamente
	public int anadir_juego(Juego juego);

	public void listar_juegos_genero_plataforma();

	public void listar_todos_juegos();

	public ArrayList<Juego> cargar_datos(String ruta_fichero);

}

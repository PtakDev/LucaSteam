package main.java.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.modelo.Juego;

public interface IJuegoService {

	public int anadir_juego(Scanner input);

	public void listar_juegos_genero_plataforma();

	public void listar_todos_juegos();

	public ArrayList<Juego> cargar_datos(String ruta_fichero);

	

}

package interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Juego;

public interface IJuegoService {

	public void anadir_juego(Scanner input);

	public void listar_juegos_genero_plataforma();

	public void listar_todos_juegos();

	public ArrayList<Juego> cargar_datos(String ruta_fichero);

	

}

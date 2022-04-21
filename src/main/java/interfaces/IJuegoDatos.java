package main.java.interfaces;

import java.util.ArrayList;

import main.java.modelo.Juego;

public interface IJuegoDatos {
	//Metodo en el que se introduce datos
	public ArrayList<Juego> anadir_juego();
	//Metodo en el que se le da el juego directamente
	public boolean anadir_juego(Juego juego);

	public ArrayList<Juego> listar_juegos_genero_plataforma();
	public ArrayList<Juego> listar_juegos_pub_Nintendo();

	public ArrayList<Juego> listar_todos_juegos();

	public ArrayList<Juego> cargar_datos(String ruta_fichero);

	public ArrayList<Juego> getListajuegos();
	public ArrayList<String> getListadoEditores();

}

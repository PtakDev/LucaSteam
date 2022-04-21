package main.java.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.modelo.Juego;

public interface IJuegoDatos {

	public ArrayList<Juego> cargar_datos(String ruta_fichero);

	public ArrayList<Juego> listar_juegos_genero_plataforma();

	public ArrayList<Juego> listar_todos_juegos();

	public ArrayList<Juego> listar_juegos_genero();

	public ArrayList<Juego> listado_juegos_aniospares();

	public ArrayList<Juego> listado_juego_sigloXX();

	public ArrayList<Juego> listar_juegos_pub_Nintendo();

	public ArrayList<String> listadoEditores();

	public Juego crear_juego(Scanner sc);

	public Juego buscar_juego(String nombre);

	public boolean anadir_juego(Juego juego);

	public boolean editar_juego(Scanner sc);

	public boolean eliminar_juego(Scanner sc);
}

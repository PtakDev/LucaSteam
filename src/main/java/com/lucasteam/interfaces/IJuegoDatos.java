package com.lucasteam.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import com.lucasteam.modelo.Juego;

public interface IJuegoDatos {

	public ArrayList<Juego> cargar_datos(String ruta_fichero);

	public ArrayList<Juego> listar_juegos_genero_plataforma();

	public ArrayList<Juego> listar_todos_juegos();

	public ArrayList<Juego> listado_juegos_aniospares();

	public ArrayList<Juego> listado_juego_sigloXX();

	public ArrayList<Juego> listar_juegos_pub_Nintendo();

	public ArrayList<String> listadoEditores();

	public ArrayList<Juego> listar_juegos_genero(Scanner sc);

	public ArrayList<Juego> listar_juegos_genero(String genero);

	public Juego crear_juego(Scanner sc);

	public Juego buscar_juego(String nombre);

	public boolean anadir_juego(Juego juego);

	public boolean editar_juego(Scanner sc);

	public boolean editar_juego(String nombre_antiguo, String nombre_nuevo);// For Tests

	public boolean eliminar_juego(Scanner sc);

	public boolean eliminar_juego(String nombre);// For Tests

	public Juego crear_juego(int rango, String nombre, String plataforma, int anio, String genero, String editor);// For Tests

}

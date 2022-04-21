package main.java.services;

import java.util.Scanner;

public interface IJuegoService {
	
	public void recoger_datos(); 
	public void listar_todos_juegos();
	public void listar_juegos_genero_plataforma();
	public void listado_juego_sigloXX();
	public void listado_juegos_aniospares();
	public void listar_juegos_genero(Scanner sc);
	public void printListadoEditores();
	public void listar_juegos_pub_Nintendo();
	public boolean anadir_juego(Scanner sc);
	public void editar_juego(Scanner sc);
	public void eliminar_juego(Scanner sc);

}

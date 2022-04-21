package main.java.services;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.modelo.Juego;

public interface IJuegoService {
	
	public void recoger_datos(); 
	public void listar_todos_juegos();
	public ArrayList<Juego> listar_juegos_genero_plataforma();
	public ArrayList<Juego> listado_juego_sigloXX();
	public ArrayList<Juego> listado_juegos_aniospares();
	public void listar_juegos_genero();
	public void printListadoEditores();
	public void listar_juegos_pub_Nintendo();
	public boolean anadir_juego();
	public void editar_juego();
	public void eliminar_juego();

}

package main.java.services;

import java.util.ArrayList;

import main.java.datos.JuegoDatos;
import main.java.interfaces.IJuegoDatos;
import main.java.modelo.Juego;

public class JuegoService {

	IJuegoDatos juegodatos = new JuegoDatos();// Crear una instancia de la clase JuegoDatos

	public void recoger_datos() {
		// Llamamos el metodo y carga los datos al array
		juegodatos.cargar_datos(".\\datos\\vgsales.csv");
	}

	public ArrayList<Juego> listar_todos_juegos() {
		return juegodatos.getListajuegos();
	}

	public ArrayList<Juego> listar_juegos_genero_plataforma() {
		return juegodatos.listar_juegos_genero_plataforma();
	}

	public ArrayList<Juego> anadir_juego() {
		return juegodatos.anadir_juego();
	}

}

package main.java.services;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.datos.JuegoDatos;
import main.java.interfaces.IJuegoDatos;
import main.java.modelo.Juego;

public class JuegoService extends IJuegoService {

	IJuegoDatos juegodatos = new JuegoDatos();// Crear una instancia de la clase JuegoDatos

	public void recoger_datos() {
		// Llamamos el metodo y carga los datos al array
		juegodatos.cargar_datos(".\\datos\\vgsales.csv");
	}

	public void listar_todos_juegos() {
		for (Juego j : juegodatos.listar_todos_juegos()) {
			System.out.println(j);
		}
	}

	public ArrayList<Juego> listar_juegos_genero_plataforma() {
		return juegodatos.listar_juegos_genero_plataforma();
	}
	
	public ArrayList<Juego> listado_juego_sigloXX() {
		return juegodatos.listado_juego_sigloXX();
	}
	
	public ArrayList<Juego> listado_juegos_aniospares() {
		return juegodatos.listado_juegos_aniospares();
	}
	
	public void listar_juegos_genero(Scanner sc){
		for (Juego j : juegodatos.listar_juegos_genero(sc)) {
			System.out.println(j);
		}
	}

	public void printListadoEditores(){
		System.out.println(juegodatos.listadoEditores());
	}

	public void listar_juegos_pub_Nintendo() {
		for (Juego j : juegodatos.listar_juegos_pub_Nintendo()) {
			System.out.println(j);}
		}
	
	public boolean anadir_juego(Scanner sc) {
		return juegodatos.anadir_juego(juegodatos.crear_juego(sc));
	}
	
	public void editar_juego(Scanner sc) {
		if(juegodatos.editar_juego(sc)==true) {
			System.out.println("Juego editado con exito ");
		}
		else
			System.out.println("No se pudo editar el juego ");
	}
	
	public void eliminar_juego(Scanner sc) {
		if(juegodatos.eliminar_juego(sc)==true) {
			System.out.println("Juego eliminado con exito ");
		}
		else
			System.out.println("No se pudo eliminar el juego ");
	}
	
}

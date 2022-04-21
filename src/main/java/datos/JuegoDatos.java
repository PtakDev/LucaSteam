package main.java.datos;

import java.util.ArrayList;

import main.java.interfaces.IJuegoService;
import main.java.modelo.Juego;
import main.java.services.JuegoService;

public class JuegoDatos {
	IJuegoService juegoservice = new JuegoService();// Crear una instancia de la clase JuegoService
	ArrayList<Juego> listadojuegos = new ArrayList<Juego>(); // Creamos una lista vacia para guardar los objectos	
	
	public void recoger_datos() {											// Juego
	listadojuegos = juegoservice.cargar_datos(".\\datos\\vgsales.csv"); // Llamamos el metodo y carga los datos al array
	}
}

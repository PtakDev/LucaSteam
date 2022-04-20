package controller;

import java.util.ArrayList;

import interfaces.IJuegoService;
import modelo.Juego;
import services.JuegoService;

public class MyController {
	
	public static void main(String[] args) {
	IJuegoService juegoservice = new JuegoService(); //Crear una instancia de la clase JuegoService
	ArrayList<Juego> listadojuegos = new ArrayList<Juego>(); //Creamos una lista vacia para guardar los objectos Juego 
	listadojuegos = juegoservice.cargar_datos(); //Llamamos el metodo y cargamam
	juegoservice.listar_todos_juegos();
	juegoservice.anadir_juego(); 
	juegoservice.listar_juegos_genero_plataforma();
	}

}

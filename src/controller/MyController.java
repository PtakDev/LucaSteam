package controller;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.IJuegoService;
import modelo.Juego;
import services.JuegoService;

public class MyController {

	public static void main(String[] args) {
		IJuegoService juegoservice = new JuegoService(); // Crear una instancia de la clase JuegoService
		ArrayList<Juego> listadojuegos = new ArrayList<Juego>(); // Creamos una lista vacia para guardar los objectos
																	// Juego
		listadojuegos = juegoservice.cargar_datos(".\\datos\\vgsales.csv"); // Llamamos el metodo y carga los datos al array
		boolean seguir = true;
		int opcion = 0;
		try (Scanner sc = new Scanner(System.in)) {
			while (seguir) {
				System.out.println("Elige una opcion:");
				System.out.println("1 - Listado de todos los juegos");
				System.out.println("2 - Listado de todos los juegos de genero plataforma");
				System.out.println("3 - Añadir un juego");
				opcion = sc.nextInt();
				switch (opcion) {
				case 0:
					seguir = false;
					break;
				case 1:
					juegoservice.listar_todos_juegos();
					break;
				case 2:
					juegoservice.listar_juegos_genero_plataforma();
					break;
				case 3:
					juegoservice.anadir_juego(sc);
					break;
				default:
					System.out.println("Opcion incorrecta. Marca una nueva opcion.");
				}
			}
		}
	}

}

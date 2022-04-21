package main.java.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.modelo.Juego;
import main.java.services.JuegoService;

public class MyController {

	JuegoService juegosService = new JuegoService();

	public void menu() {
		//Recogo datos
		juegosService.recoger_datos();
		
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
					for (Juego j : juegosService.listar_todos_juegos()) {
						System.out.println(j);
					}
					break;
				case 2:
					for (Juego game : juegosService.listar_juegos_genero_plataforma()) {
						if (game.getGenero().equals("Platform")) {
							System.out.println(game);
						}
					}
					break;
				case 3:
					juegosService.anadir_juego(sc);
					break;
				default:
					System.out.println("Opcion incorrecta. Marca una nueva opcion.");
				}
			}
		}
	}

}

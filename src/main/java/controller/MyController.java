package main.java.controller;

import java.util.Scanner;

import main.java.modelo.Juego;
import main.java.services.JuegoService;

public class MyController {

	JuegoService juegosService = new JuegoService();

	public void menu() {
		// Recojo datos
		juegosService.recoger_datos();

		boolean seguir = true;
		int opcion = 0;
		try (Scanner sc = new Scanner(System.in)) {
			while (seguir) {
				System.out.println("Elige una opcion:");
				System.out.println("1 - Listado de todos los juegos");
				System.out.println("2 - Listado de todos los juegos de genero plataforma");
				System.out.println("4 - Listado de todos los juegos por publisher Nintendo");
				System.out.println("6 - Listado de todos los editores");
				System.out.println("7 - Listar todos los juegos del siglo XX");
				System.out.println("8 - Listar todos los juegos por genero");
				System.out.println("9 - Listar todos los juegos por anios pares");
				System.out.println("11 - Aniadir un juego");
				System.out.println("12 - Editar un juego");
				System.out.println("13 - Eliminar un juego");
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
					juegosService.listar_juegos_genero_plataforma();
					break;
				case 4:
					for (Juego j : juegosService.listar_juegos_pub_Nintendo()) {
						if (j.getEditor().equals("Nintendo")) {
							System.out.println(j);
						}
					}
					break;
				case 6:
					juegosService.printListadoEditores();
					break;
				case 7:
					juegosService.listado_juego_sigloXX();
					break;
				case 8:
					System.out.println("¿Que genero quieres? ");
					sc.nextLine();
					String tipo = sc.nextLine();
					for (Juego game : juegosService.listar_juegos_genero()) {
						if (game.getGenero().equals(tipo)) {
							System.out.println(game);
						}
					}
					break;
				case 9:
					juegosService.listado_juegos_aniospares();
					break;
				case 11:
					juegosService.anadir_juego(sc);
					break;
				case 12:
					juegosService.editar_juego(sc);
					break;
				case 13:
					juegosService.eliminar_juego(sc);
					break;
				default:
					System.out.println("Opcion incorrecta. Marca una nueva opcion.");
				}
			}
		}
	}

}

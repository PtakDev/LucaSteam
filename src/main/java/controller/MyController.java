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
				System.out.println("3 - Listado de todos los juegos por publisher Nintendo");
				System.out.println("4 - Listado de todos los editores");
				System.out.println("5 - Listar todos los juegos del siglo XX");
				System.out.println("6 - Listar todos los juegos por genero");
				System.out.println("7 - Listar todos los juegos por anios pares");
				System.out.println("8 - Aniadir un juego");
				System.out.println("9 - Editar un juego");
				System.out.println("10 - Eliminar un juego");
				opcion = sc.nextInt();
				switch (opcion) {
				case 0:
					seguir = false;
					break;
				case 1:
					juegosService.listar_todos_juegos();
					break;
				case 2:
					for (Juego game : juegosService.listar_juegos_genero_plataforma()) {
						if (game.getGenero().equals("Platform")) {
							System.out.println(game);
						}
					}
					break;
				case 3:
					juegosService.listar_juegos_pub_Nintendo();
					break;
				case 4:
					juegosService.printListadoEditores();
					break;
				case 5:
					for (Juego game : juegosService.listado_juego_sigloXX()) {
						if (game.getAnio() > 1899 && game.getAnio() < 2000) {
							System.out.println(game);
						}
					}
					break;
				case 6:
					juegosService.listar_juegos_genero(sc);
					break;
				case 7:
					juegosService.listado_juegos_aniospares();
				case 8:
					juegosService.anadir_juego(sc);
					break;
				case 9:
					juegosService.editar_juego(sc);
					break;
				case 10:
					juegosService.eliminar_juego(sc);
					break;
				default:
					System.out.println("Opcion incorrecta. Marca una nueva opcion.");
				}
			}
		}
	}

}

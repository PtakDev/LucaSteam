package main.java.controller;

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
//					for (Juego game : juegosdatos.listar_juegos_genero_plataforma()) {
//						if (game.getGenero().equals("Platform")) {
//							System.out.println(game);
//						}
//					}
					break;
				case 3:
//					Juego juego = new Juego();
//					// Automaticamente le pongo el ultimo rango
//					juego.setRango(juegosdatos.anadir_juego().size() + 1);
//					System.out.println("¿Que nombre quieres ponerle? ");
//					sc.nextLine();
//					juego.setNombre(sc.nextLine());
//					System.out.println("¿Para que plataforma es? ");
//					juego.setPlataforma(sc.nextLine());
//					System.out.println("¿En que año se publico? ");
//					try {
//						juego.setAnio(sc.nextInt());
//					} catch (InputMismatchException e) {
//						System.err.println("Solo aceptamos numeros");
//						sc.nextLine();
//					}
//					sc.nextLine();
//					System.out.println("¿De que genero es? ");
//					juego.setGenero(sc.nextLine());
//					System.out.println("¿Cual es el editor? ");
//					juego.setEditor(sc.nextLine());
//					juegosdatos.anadir_juego().add(juego);
//					///////////////////////////////
//					juegosdatos.anadir_juego(juego);
//					
					break;
				default:
					System.out.println("Opcion incorrecta. Marca una nueva opcion.");
				}
			}
		}
	}

}

package main.java.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.modelo.Juego;
import main.java.services.JuegoService;

public class MyController {

	private JuegoService juegosService = new JuegoService();

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
        System.out.println("4 - Listado de todos los juegos por publisher Nintendo");
        System.out.println("6 - Listado de todos los editores");
				System.out.println("7 - Listar todos los juegos del siglo XX");
				System.out.println("8 - Listar todos los juegos por genero");
				System.out.println("9 - Listar todos los juegos por a�os pares");

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
					Juego juego = new Juego();
					// Automaticamente le pongo el ultimo rango
					juego.setRango(juegosService.anadir_juego().size() + 1);
					System.out.println("¿Que nombre quieres ponerle? ");
					sc.nextLine();
					juego.setNombre(sc.nextLine());
					System.out.println("¿Para que plataforma es? ");
					juego.setPlataforma(sc.nextLine());
					System.out.println("¿En que año se publico? ");
					try {
						juego.setAnio(sc.nextInt());
					} catch (InputMismatchException e) {
						System.err.println("Solo aceptamos numeros");
						sc.nextLine();
					}
					sc.nextLine();
					System.out.println("¿De que genero es? ");
					juego.setGenero(sc.nextLine());
					System.out.println("¿Cual es el editor? ");
					juego.setEditor(sc.nextLine());
					juegosService.anadir_juego().add(juego);
				
					//juegosService.anadir_juego(juego);
					
					break;

				case 4:
					for (Juego j : juegosService.listar_juegos_pub_Nintendo()) {
						if (j.getEditor().equals("Nintendo")) {
							System.out.println(j);
						}
					}
        case 6:
					 juegosService.printListadoEditores();
					 break;
            
        case 7:
					for (Juego game : juegosService.listado_juego_sigloXX()) {
						if (game.getAnio()>1899 && game.getAnio()<2000) {
							System.out.println(game);
						}
					}

					break;
					
				case 8:
					System.out.println("�Que genero quieres? ");
					sc.nextLine();
					String tipo=sc.nextLine();
					for (Juego game : juegosService.listar_juegos_genero()) {
					if (game.getGenero().equals(tipo)) {
					System.out.println(game);
					}
					}
					break;
				case 9:
					for (Juego game : juegosService.listado_juegos_aniospares()) {
						if (game.getAnio()%2==0) {
							System.out.println(game);
						}
					}
          break;
				default:
					System.out.println("Opcion incorrecta. Marca una nueva opcion.");
				}
			}
		}
	}

}

package interfaces;

import java.util.ArrayList;

import modelo.Juego;

public interface IJuegoService {
	public ArrayList<Juego> cargar_datos();
	public void anadir_juego();
	public void listar_juegos_genero_plataforma();
	public void listar_todos_juegos();

}

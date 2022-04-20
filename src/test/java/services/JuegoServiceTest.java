package test.java.services;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.interfaces.IJuegoService;
import main.java.modelo.Juego;
import main.java.services.JuegoService;

public class JuegoServiceTest {

	IJuegoService juegoservice = new JuegoService();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testistar_todos_juegos() {
		ArrayList<Juego> listajuegos = new ArrayList<Juego>();
		assertNotNull("Ver que no hay valores NULL", listajuegos);
	}

}

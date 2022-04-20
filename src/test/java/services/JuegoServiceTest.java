package test.java.services;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.java.interfaces.IJuegoService;
import main.java.modelo.Juego;
import main.java.services.JuegoService;

public class JuegoServiceTest {

	IJuegoService juegoservice = new JuegoService();
	ArrayList<Juego> listajuegos = new ArrayList<Juego>();

	
	@Test
	public void testlistar_todos_juegos() {
		for (Juego j : listajuegos) {
			Assert.assertNotNull("No hay valor NULL",j);
		}

	}
	

}

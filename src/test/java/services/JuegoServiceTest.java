package test.java.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import main.java.interfaces.IJuegoService;
import main.java.modelo.Juego;
import main.java.services.JuegoService;

public class JuegoServiceTest {

	IJuegoService juegoservice = new JuegoService();
	ArrayList<Juego> listajuegos = new ArrayList<Juego>();
	Juego juego = new Juego();
	
	@Test
	public void testlistar_todos_juegos() {
		for (Juego j : listajuegos) {
			Assert.assertNotNull("No hay valor NULL",j);
		}

	}
	
	@Test
	public void test_crear_nuevo_juego_vacio() {
		Assert.assertNotEquals(juego, null);
	}
	
	@Test
	public void test_nombre_juego() {
		juego.setNombre("Antonio");
		Assert.assertEquals(juego.getNombre(), "Antonio");
	}
	
	@Test
	public void test_nombre_juego_null() {
		juego.setNombre(null);
		Assert.assertEquals(juego.getNombre(), null);
	}
	

}

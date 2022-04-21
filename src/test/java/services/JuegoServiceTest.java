package test.java.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.InputMismatchException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import main.java.interfaces.IJuegoDatos;
import main.java.modelo.Juego;
import main.java.services.JuegoService;

public class JuegoServiceTest {

	IJuegoDatos juegoservice = new JuegoService();
	ArrayList<Juego> listajuegos = new ArrayList<Juego>();
	Juego juego = new Juego();
	
	@Test
	public void testlistar_todos_juegos() {
		for (Juego j : listajuegos) {
			Assert.assertNotNull("No hay valor NULL",j);
		}

	}
	@Test
	public void test_anadir_juego_vacio() {
		Juego juego=null;
		//Si es igual a 2 significa que es nulo
		Assert.assertEquals(2, juegoservice.anadir_juego(juego));
	}
	@Test
	public void test_anadir_juego_malrango() {
		Juego juego = new Juego();
		//Le añado un rango menor al total del listado para asegurar que de error
		juego.setRango(listajuegos.size() - 1);
		juego.setNombre("Forza Motorsport 3");
		juego.setPlataforma("PC");
		juego.setAnio(2020);
		juego.setGenero("Racing");
		juego.setEditor("Mocosoft");
		//Si el rango del juego no es el siguiente disponible del listado, anadir_juego() devuelve un 3
		Assert.assertEquals(3, juegoservice.anadir_juego(juego));
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

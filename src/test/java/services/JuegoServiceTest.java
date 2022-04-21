package test.java.services;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.java.datos.JuegoDatos;
import main.java.interfaces.IJuegoDatos;
import main.java.modelo.Juego;

public class JuegoServiceTest {

	IJuegoDatos juegoDatos = new JuegoDatos();
	ArrayList<Juego> listajuegos = new ArrayList<Juego>();
	Juego juego = new Juego();

	@Test
	public void testlistar_todos_juegos() {
		for (Juego j : listajuegos) {
			Assert.assertNotNull("No hay valor NULL", j);
		}

	}

	@Test
	public void test_anadir_juego_vacio() {
		Juego juego = null;
		// Si es igual a 2 significa que es nulo
		Assert.assertEquals(2, juegoDatos.anadir_juego(juego));
	}

	@Test
	public void test_anadir_juego_malrango() {
		Juego juego = new Juego();
		// Le añado un rango menor al total del listado para asegurar que de error
		juego.setRango(listajuegos.size() - 1);
		juego.setNombre("Forza Motorsport 3");
		juego.setPlataforma("PC");
		juego.setAnio(2020);
		juego.setGenero("Racing");
		juego.setEditor("Mocosoft");
		// Si el rango del juego no es el siguiente disponible del listado,
		// anadir_juego() devuelve un 3
		Assert.assertEquals(3, juegoDatos.anadir_juego(juego));
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

	@Test
	public void test_editor_juego() {
		juego.setEditor("Nintendo");
		Assert.assertEquals(juego.getEditor(), "Nintendo");
	}

	@Test
	public void test_listado_editores_contiene() {
		ArrayList<String> actual = new ArrayList<String>();
		ArrayList<String> expected = juegoDatos.listadoEditores();
		Assert.assertEquals(expected, expected);
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected.getClass(), actual.getClass());
		expected.add("Nintendo");
		expected.add("Sony");
		Assert.assertEquals(expected.get(0), "Nintendo");
		Assert.assertNotEquals(expected.get(0), "Sony");
	}

}
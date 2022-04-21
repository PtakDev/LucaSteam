package test.java.services;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.java.datos.JuegoDatos;
import main.java.interfaces.IJuegoDatos;
import main.java.modelo.Juego;

public class JuegoServiceTest {

	IJuegoDatos juegoDatos = new JuegoDatos();
	Juego juego = new Juego();

	@Test
	public void testlistar_todos_juegos() {
		for (Juego j : juegoDatos.listar_todos_juegos()) {
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
		// Le a�ado un rango menor al total del listado para asegurar que de error
		juego.setRango(juegoDatos.listar_todos_juegos().size() - 1);
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
	public void test_comprobar_plataforma() {
		boolean comprobar=true;
		for (Juego game: juegoDatos.listar_juegos_genero_plataforma()) {//given
			if(!game.getGenero().equals("Platform")) {//when
				comprobar=false;
			}
		}
		Assert.assertTrue(comprobar);//then
		
	}
	
	@Test
	public void test_comprobar_sigoxx() {
		boolean comprobar=true;
		for (Juego game: juegoDatos.listado_juego_sigloXX()) {//given
			if (game.getAnio() < 1899 && game.getAnio() > 2000) {//when
				comprobar=false;
			}
		}
		Assert.assertTrue(comprobar);//then

	}
	
	@Test
	public void test_comprobar_anios() {
		boolean comprobar = true;

		for (Juego game : juegoDatos.listado_juegos_aniospares()) {// given
			if (game.getAnio() % 2 != 0) {// when
				comprobar = false;
			}

		}
		Assert.assertTrue(comprobar);// then

	}

	@Test
	public void test_nombre_juego_null() {
		juego.setNombre(null);
		Assert.assertEquals(juego.getNombre(), null);
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

	@Test
	public void test_obtener_listado_Nintendo() {
		// Given ("Una funci�n que nos saca una lista de genero por plataforma"):
		boolean comprobar = true;
		for (Juego j : juegoDatos.listar_juegos_genero_plataforma())
			// When ("Cuando el editor es Nintendo est� Ok"):
			if (j.getEditor() != "Nintendo") {
				comprobar = false;
			}
		// Then ("Obtengo los valores de true"):
		Assert.assertTrue("El metodo es correcto", comprobar);
	}

	@Test
	public void test_listar_juegos_siglo_XX() {
		//Given:
		boolean comprobar = true;
		for (Juego j : juegoDatos.listado_juego_sigloXX()) {// given
			//When:
			if (j.getAnio() < 1899 && j.getAnio() > 2000) {// when
				comprobar = false;
			}
			//Then:
		}
		Assert.assertTrue("El m�todo te lista los juegos del Siglo XX",comprobar);
	}
}

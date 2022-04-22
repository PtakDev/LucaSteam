package test.java.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.opencsv.CSVWriter;

import main.java.datos.JuegoDatos;
import main.java.interfaces.IJuegoDatos;
import main.java.modelo.Juego;

public class JuegoServiceTest {

	IJuegoDatos juegoDatos = new JuegoDatos();
	Juego juego = new Juego();

	// TESTS DEL METODO CARGAR DE FICHERO
	@Test
	public void test_carga_datos() {
		// given
		juegoDatos.cargar_datos(".\\datos\\vgsales.csv");
		boolean test_valor = true;
		if (juegoDatos.listadoEditores().size() < 1) {
			// when
			test_valor = false;
		}
		// then
		Assert.assertEquals(true, test_valor);
	}

	@Test
	public void test_carga_datos_vacio() throws IOException {
		// given
		File file = File.createTempFile("temp", ".csv", new File(".\\datos\\"));
		juegoDatos.cargar_datos(file.getAbsolutePath());
		boolean test_valor = true;
		if (juegoDatos.listadoEditores().size() < 1) {
			// when
			test_valor = false;
		}
		// then
		Assert.assertEquals(false, test_valor);
	}

	@Test(expected = Exception.class)
	public void test_datos_mal_formateado_en_fichero() throws IOException {
		// given
		File file = File.createTempFile("temp", ".csv", new File(".\\datos\\"));
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			String[] data1 = { "Aman", "10", "620" };
			writer.writeNext(data1);
			String[] data2 = { "Suraj", "10", "630" };
			writer.writeNext(data2);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// when
		ArrayList<Juego> aux = juegoDatos.cargar_datos(file.getAbsolutePath());
		// then
		Assert.assertEquals(aux.get(0).getRango(), "Aman");
	}

	@Test
	public void testlistar_todos_juegos() {
		for (Juego j : juegoDatos.listar_todos_juegos()) {
			Assert.assertNotNull("No hay valor NULL", j);
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
	public void test_comprobar_plataforma() {
		boolean comprobar = true;
		for (Juego game : juegoDatos.listar_juegos_genero_plataforma()) {// given
			if (!game.getGenero().equals("Platform")) {// when
				comprobar = false;
			}
		}
		Assert.assertTrue(comprobar);// then

	}

	@Test
	public void test_comprobar_sigoxx() {
		boolean comprobar = true;
		for (Juego game : juegoDatos.listado_juego_sigloXX()) {// given
			if (game.getAnio() < 1899 && game.getAnio() > 2000) {// when
				comprobar = false;
			}
		}
		Assert.assertTrue(comprobar);// then

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

	@Test(expected = Exception.class)
	public void test_listado_editores_no_anade_duplicados() throws IOException {
		// given
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Nintendo");

		File file = File.createTempFile("temp", ".csv", new File(".\\datos\\"));
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			String[] data1 = { "", "", "", "", "Nintendo" };
			writer.writeNext(data1);
			String[] data2 = { "", "", "", "", "Nintendo" };
			writer.writeNext(data2);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// when
		ArrayList<Juego> aux = juegoDatos.cargar_datos(file.getAbsolutePath());
		ArrayList<String> actual = ((IJuegoDatos) aux).listadoEditores();
		// then
		Assert.assertEquals(expected, actual);

	}

	@Test(expected = Exception.class)
	public void test_listado_editores() throws IOException {
		// given
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Nintendo");
		expected.add("Sony");

		File file = File.createTempFile("temp", ".csv", new File(".\\datos\\"));
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			String[] data1 = { "", "", "", "", "Nintendo" };
			writer.writeNext(data1);
			String[] data2 = { "", "", "", "", "Sony" };
			writer.writeNext(data2);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// when
		ArrayList<Juego> aux = juegoDatos.cargar_datos(file.getAbsolutePath());
		ArrayList<String> actual = ((IJuegoDatos) aux).listadoEditores();
		// then
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void test_obtener_listado_Nintendo() {
		// Given ("Una funcion que nos saca una lista de genero por plataforma"):
		boolean comprobar = true;
		for (Juego j : juegoDatos.listar_juegos_genero_plataforma())
			// When ("Cuando el editor es Nintendo este Ok"):
			if (j.getEditor() != "Nintendo") {
				comprobar = false;
			}
		// Then ("Obtengo los valores de true"):
		Assert.assertTrue("El metodo es correcto", comprobar);
	}

	@Test
	public void test_listar_juegos_siglo_XX() {
		// Given:
		boolean comprobar = true;
		for (Juego j : juegoDatos.listado_juego_sigloXX()) {// given
			// When:
			if (j.getAnio() < 1899 && j.getAnio() > 2000) {// when
				comprobar = false;
			}
			// Then:
		}
		Assert.assertTrue("El metodo te lista los juegos del Siglo XX", comprobar);
	}

	@Test
	public void test_anadir_juego_existente() {
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertFalse("Deberia ser false cuando ingreso un juego que ya existe", juegoDatos
				.anadir_juego(juegoDatos.listar_todos_juegos().get(juegoDatos.listar_todos_juegos().size() - 1)));
	}

	@Test
	public void test_anadir_juego_noexistente() {
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Juego juego = new Juego(juegoDatos.listar_todos_juegos().size() + 1, "Test", "PS", 1996, "Platform",
				"Sony Computer Entertainment");
		Assert.assertTrue("Deberia ser true cuando ingreso un juego que no existe", juegoDatos.anadir_juego(juego));
	}

	@Test
	public void test_editar_juego() {
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertTrue("El juego no se ha podido editar si salta este error. ",
				juegoDatos.editar_juego("Crash Bandicoot", "Pepe Remolinos"));
	}

	@Test
	public void test_buscar_juego() {
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertNotNull(
				"Si salta este error es que el juego sigue existiendo en el listado, por lo que no se ha editado el nombre. ",
				juegoDatos.buscar_juego("Crash Bandicoot"));
	}

	@Test
	public void test_eliminar_juego() {
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertTrue("El juego no se ha eliminado si salta este error. ", juegoDatos.eliminar_juego("Fallout 4"));
	}

	@Test
	public void test_eliminar_juego2() {
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertNotNull(
				"Si salta este error es que el juego sigue existiendo en el listado, por lo que no se ha eliminado correctamente. ",
				juegoDatos.buscar_juego("Fallout 4"));
	}
}
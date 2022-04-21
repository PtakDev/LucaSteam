package test.java.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	//TESTS DEL METODO CARGAR DE FICHERO
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
	public void test_anadir_juego_vacio() {
		Juego juego = null;
		// Si es igual a 2 significa que es nulo
		Assert.assertEquals(2, juegoDatos.anadir_juego(juego));
	}

	@Test
	public void test_anadir_juego_malrango() {
		Juego juego = new Juego();
		// Le añado un rango menor al total del listado para asegurar que de error
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

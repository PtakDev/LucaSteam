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
	
	@Test
	public void test_anadir_juego_existente() {
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertFalse("Deberia ser false cuando ingreso un juego que ya existe", juegoDatos.anadir_juego(juegoDatos.listar_todos_juegos().get(juegoDatos.listar_todos_juegos().size()-1)));
	}
	@Test
	public void test_anadir_juego_noexistente() {
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Juego juego = new Juego(juegoDatos.listar_todos_juegos().size()+1,"Test","PS",1996, "Platform", "Sony Computer Entertainment");
		Assert.assertTrue("Deberia ser true cuando ingreso un juego que no existe", juegoDatos.anadir_juego(juego));
	}
	
	@Test
	public void test_editar_juego(){
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertTrue("El juego no se ha podido editar si salta este error. ",juegoDatos.editar_juego("Crash Bandicoot", "Pepe Remolinos"));
	}
	@Test
	public void test_buscar_juego(){
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertNotNull("Si salta este error es que el juego sigue existiendo en el listado, por lo que no se ha editado el nombre. ",juegoDatos.buscar_juego("Crash Bandicoot"));
	}
	
	@Test
	public void test_eliminar_juego(){
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertTrue("El juego no se ha eliminado si salta este error. ",juegoDatos.eliminar_juego("Fallout 4"));
	}
	@Test
	public void test_eliminar_juego2(){
		juegoDatos.cargar_datos(".\\\\datos\\\\vgsales.csv");
		Assert.assertNotNull("Si salta este error es que el juego sigue existiendo en el listado, por lo que no se ha eliminado correctamente. ",juegoDatos.buscar_juego("Fallout 4"));
	}
}
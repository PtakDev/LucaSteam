package modelo;

public class Juego {
	private int rango;
	private String nombre;
	private String plataforma;
	private int anio;
	private String genero;
	private String editor;
	
	
	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juego(int rango, String nombre, String plataforma, int anio, String genero, String editor) {
		super();
		this.rango = rango;
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.anio = anio;
		this.genero = genero;
		this.editor = editor;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@Override
	public String toString() {
		return "Juego [rango=" + rango + ", nombre=" + nombre + ", plataforma=" + plataforma + ", anio=" + anio
				+ ", genero=" + genero + ", editor=" + editor + "]";
	}
	

	
}

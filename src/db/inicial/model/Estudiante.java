package db.inicial.model;

public class Estudiante {
	private int id;
	private String nombre;
	private String apellido;

	public Estudiante(String nombreEstudiante, String apellidoEstudiante) {
		this.nombre = nombreEstudiante;
		this.apellido = apellidoEstudiante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}

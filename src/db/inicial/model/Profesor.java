package db.inicial.model;

public class Profesor {
	private int id;
	private String nombre;
	private String apellido;
	private String email;

	public Profesor(String nombreProfesor, String apellidoProfesor, String emailProfesor) {
		this.nombre = nombreProfesor;
		this.apellido = apellidoProfesor;
		this.email = emailProfesor;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

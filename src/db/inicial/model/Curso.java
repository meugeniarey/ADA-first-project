package db.inicial.model;

public class Curso {
	private int id;
	private String name;

	public Curso(String nombreCurso) {
		this.name = nombreCurso;
	}

	public Curso(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package db.inicial.model;

public class Inscripcion {
	private int idInscripcion;
	private int idEstudiante;
	private int idCurso;
	private int estado_inscripcion;
	private int idProfesor;
	private int comision;
	private int nota1;
	private int nota2;

	public Inscripcion(int idEstudiante, int idCurso, int estado_inscripcion, int comision) {
		super();
		this.idInscripcion = idInscripcion;
		this.idEstudiante = idEstudiante;
		this.idCurso = idCurso;
		this.estado_inscripcion = estado_inscripcion;
		this.comision = comision;

	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getEstado_inscripcion() {
		return estado_inscripcion;
	}

	public void setEstado_inscripcion(int estado_inscripcion) {
		this.estado_inscripcion = estado_inscripcion;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

}

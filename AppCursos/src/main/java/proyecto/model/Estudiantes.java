package proyecto.model;

public class Estudiantes extends Persona{
	private char sexo;
	private String carrera;
	public Estudiantes() {
	}
	public Estudiantes(String codigo, String apellidos, String nombres, String correo, String direccion, char sexo, String carrera) {
		super(codigo, apellidos, nombres, correo, direccion);
		this.sexo = sexo;
		this.carrera = carrera;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
}


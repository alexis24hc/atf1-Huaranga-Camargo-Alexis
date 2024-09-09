package proyecto.model;

public class Asignatura {
	private String codigo;
	private String nombre;
	private int horas;
	private String tipo;
	private int creditos;

	public Asignatura() {
		// TODO Auto-generated constructor stub
	}

	public Asignatura(String codigo, String nombre, int horas, String tipo, int creditos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.horas = horas;
		this.tipo = tipo;
		this.creditos = creditos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
}

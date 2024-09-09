package proyecto.model;

public class Persona {
	private String codigo;
	private String apellidos;
	private String nombres;
	private String correo;
	private String direccion;
	//Metodos constructores
	public Persona() {
	}
	public Persona(String codigo, String apellidos, String nombres, String correo, String direccion) {
		super();
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.correo = correo;
		this.direccion = direccion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
